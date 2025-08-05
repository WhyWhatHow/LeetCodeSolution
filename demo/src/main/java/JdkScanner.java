import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * JdkScannerV2 采用混合策略高效扫描JDK。
 * 1. 优先扫描高可能性目录。
 * 2. 普查 C:\ 时主动跳过已知的、大型的、无关的系统目录。
 */
public class JdkScanner {

    // 使用线程安全的 Set 来存储找到的 JDK 路径，防止重复添加。
    private static final Set<Path> foundJdks = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("开始使用优化策略扫描 JDK...");
        long startTime = System.currentTimeMillis();

        // --- 阶段1: 扫描高可能性目录 ---
        System.out.println("\n[阶段 1/2] 正在扫描高可能性目录...");
        List<Path> highProbabilityPaths = getHighProbabilityPaths();
        for (Path path : highProbabilityPaths) {
            if (Files.exists(path)) {
                System.out.println(" -> 扫描: " + path);
                scanDirectory(path, 5, null); // 不设置排除项
            }
        }

        // --- 阶段2: 普查 C:\ 根目录，并排除已知目录 ---
        System.out.println("\n[阶段 2/2] 正在普查 C:\\ 根目录 (排除系统和已扫描目录)...");
        Set<String> rootExclusions = new HashSet<>(Arrays.asList(
                "Program Files", "Program Files (x86)", "Users", "Windows",
                "ProgramData", "$Recycle.Bin", "System Volume Information", "Recovery"
        ));
        scanDirectory(Paths.get("C:\\"), 5, rootExclusions);

        long endTime = System.currentTimeMillis();

        // --- 打印结果 ---
        System.out.println("\n----------------------------------------------------------");
        if (foundJdks.isEmpty()) {
            System.out.println("扫描完成，未找到任何 JDK。");
        } else {
            System.out.println("扫描完成！共找到 " + foundJdks.size() + " 个 JDK：");
            foundJdks.stream().sorted().forEach(System.out::println);
        }
        System.out.println("总耗时: " + (endTime - startTime) / 1000.0 + " 秒。");
    }

    /**
     * 获取常见 JDK 安装位置的列表。
     */
    private static List<Path> getHighProbabilityPaths() {
        String userHome = System.getProperty("user.home");
        return Arrays.asList(
                Paths.get("C:\\Program Files\\Java"),
                Paths.get("C:\\Program Files"),
                Paths.get("C:\\Program Files (x86)"),
                Paths.get("C:\\tools"),
                Paths.get(userHome)
        ).stream().distinct().collect(Collectors.toList());
    }

    /**
     * 执行扫描的核心方法
     * @param startDir 起始目录
     * @param maxDepth 最大深度
     * @param exclusions 在起始目录的第一层需要排除的文件夹名称, null 则不排除
     */
    private static void scanDirectory(Path startDir, int maxDepth, Set<String> exclusions) {
        try {
            Files.walkFileTree(startDir, new HashSet<>(), maxDepth, new JdkFileVisitor(startDir, exclusions));
        } catch (IOException e) {
            System.err.println("扫描目录 " + startDir + " 时出错: " + e.getMessage());
        }
    }

    /**
     * 自定义的 FileVisitor，用于寻找 JDK 并实现排除逻辑。
     */
    static class JdkFileVisitor extends SimpleFileVisitor<Path> {
        private final Path scanRoot;
        private final Set<String> exclusions;

        public JdkFileVisitor(Path scanRoot, Set<String> exclusions) {
            this.scanRoot = scanRoot;
            this.exclusions = exclusions;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            // **排除逻辑**：仅当目录是扫描根目录的直接子目录时，才应用排除规则
            if (exclusions != null && dir.getParent() != null && dir.getParent().equals(scanRoot)) {
                if (exclusions.contains(dir.getFileName().toString())) {
                    // System.out.println("  (跳过 " + dir + ")"); // 用于调试
                    return FileVisitResult.SKIP_SUBTREE; // 跳过此目录及其所有子目录
                }
            }

            // **JDK 检查逻辑**
            if (Files.isRegularFile(dir.resolve("bin").resolve("javac.exe"))) {
                foundJdks.add(dir.toAbsolutePath().normalize());
                return FileVisitResult.SKIP_SUBTREE; // 优化：找到后不再深入
            }

            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            // 优雅地跳过无法访问的文件/目录
            return FileVisitResult.SKIP_SUBTREE;
        }
    }
}