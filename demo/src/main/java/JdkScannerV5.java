import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

/**
 * JdkScannerV5 (需要 JDK 21+)
 * 终极性能版：采用超积极剪枝策略 + 虚拟线程并发。
 * 速度极快，但牺牲了对非标准位置的查找能力。
 */
public class JdkScannerV5 {

    private static final Set<Path> foundJdks = ConcurrentHashMap.newKeySet();
    private static final int MAX_DEPTH = 5;

    // =====================================================================================
    // 核心优化：超积极的“深度排除名单”。遍历时，任何匹配此列表的文件夹都将被整个跳过。
    // 使用 .toLowerCase() 进行不区分大小写的匹配。
    // =====================================================================================
    private static final Set<String> DEEP_EXCLUSION_LIST = new HashSet<>(Arrays.asList(
            // === 系统和用户数据 ===
            "windows", "programdata", "$recycle.bin", "system volume information",
            "config.msi", "perflogs", "documents and settings", "appdata", "local settings",
            "application data",
            // === 常见开发相关，但非JDK ===
            ".git", ".svn", ".vscode", ".idea", "node_modules", "vendor", "target", "build", "dist",
            // === 常见大型软件 ===
            "adobe", "microsoft", "microsoft office", "google", "chrome", "edge",
            "nvidia", "intel", "amd", "autodesk", "steam", "epic games", "riot games",
            "docker", "vmware", "virtualbox",
            // === 压缩文件和缓存 ===
            "temp", "tmp", "cache", "log", "logs"
    ));

    public static void main(String[] args) {
        System.out.println("开始使用 V5 终极策略 (超积极剪枝 + 虚拟线程)...");
        long startTime = System.currentTimeMillis();

        Path root = Paths.get("C:\\");

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            // 将用户的根目录作为一个高优先级任务单独提交
            Path userHome = Paths.get(System.getProperty("user.home"));
            System.out.println("  -> 分配高优先级任务: " + userHome);
            executor.submit(() -> scanDirectory(userHome));

            // 遍历C盘根目录，跳过顶层排除项，为其他目录分配任务
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(root)) {
                for (Path subDir : stream) {
                    if (Files.isDirectory(subDir)) {
                        String dirNameLower = subDir.getFileName().toString().toLowerCase();
                        // 只需在顶层检查少数几个明确的目录，深层检查交给FileVisitor
                        if (!DEEP_EXCLUSION_LIST.contains(dirNameLower) && !subDir.equals(userHome)) {
                            executor.submit(() -> scanDirectory(subDir));
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("错误：无法列出 C:\\ 的目录: " + e.getMessage());
            }
        } // try-with-resources 会自动关闭 executor 并等待任务完成

        long endTime = System.currentTimeMillis();

        System.out.println("\n----------------------------------------------------------");
        if (foundJdks.isEmpty()) {
            System.out.println("扫描完成，未找到任何 JDK。");
        } else {
            System.out.println("扫描完成！共找到 " + foundJdks.size() + " 个 JDK：");
            foundJdks.stream().sorted().forEach(System.out::println);
        }
        System.out.println("总耗时: " + (endTime - startTime) / 1000.0 + " 秒。");
    }

    private static void scanDirectory(Path startDir) {
        try {
            Files.walkFileTree(startDir, new HashSet<>(), MAX_DEPTH, new JdkFileVisitor());
        } catch (IOException e) {
            // 忽略错误
        }
    }

    static class JdkFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            // **核心剪枝逻辑**：在进入任何目录前，先检查它是否在黑名单中
            String dirNameLower = dir.getFileName().toString().toLowerCase();
            if (DEEP_EXCLUSION_LIST.contains(dirNameLower)) {
                return FileVisitResult.SKIP_SUBTREE; // 跳过整个子树
            }

            // 检查是否为JDK
            // 使用 Files.exists 更快，因为它不要求是文件，减少一次系统调用
            if (Files.exists(dir.resolve("bin").resolve("javac.exe"))) {
                foundJdks.add(dir.toAbsolutePath().normalize());
                return FileVisitResult.SKIP_SUBTREE; // 找到后跳过子树
            }

            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            return FileVisitResult.SKIP_SUBTREE; // 遇到任何错误（如权限问题），直接跳过
        }
    }
}