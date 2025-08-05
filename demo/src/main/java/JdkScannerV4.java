import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * JdkScannerV4 (需要 JDK 21+)
 * 使用虚拟线程 (Virtual Threads) 实现并发扫描。
 * 代码更简洁，面向未来的 I/O 模型。
 */
public class JdkScannerV4 {

    private static final Set<Path> foundJdks = ConcurrentHashMap.newKeySet();
    private static final int MAX_DEPTH = 5;

    public static void main(String[] args) {
        System.out.println("开始使用 JDK 21+ 虚拟线程策略进行扫描...");
        long startTime = System.currentTimeMillis();

        final Set<String> rootExclusions = new HashSet<>(Arrays.asList(
                "Windows", "ProgramData", "$Recycle.Bin", "System Volume Information",
                "Recovery", "PerfLogs", "Documents and Settings"
        ));

        Path root = Paths.get("C:\\");

        // 1. 使用为每个任务创建新虚拟线程的 ExecutorService
        // 这是虚拟线程最核心的用法！
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            System.out.println("使用虚拟线程为 C:\\ 下的每个合格目录分配扫描任务...");
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(root)) {
                for (Path subDir : stream) {
                    if (Files.isDirectory(subDir) && !rootExclusions.contains(subDir.getFileName().toString())) {
                        // 2. 为每个目录提交一个任务，Executor 会自动为其创建一个虚拟线程
                        executor.submit(() -> scanDirectory(subDir));
                    }
                }
            } catch (IOException e) {
                System.err.println("错误：无法列出 C:\\ 的目录。请检查权限。 " + e.getMessage());
            }

            // 3. ExecutorService 会自动管理虚拟线程的生命周期，
            // try-with-resources 语句会在退出时隐式调用 shutdown 和 awaitTermination。

        } // executor.close() is called here

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
            // System.out.println("Thread [" + Thread.currentThread().threadId() + "] scanning " + startDir); // 用于观察线程
            Files.walkFileTree(startDir, new HashSet<>(), MAX_DEPTH, new JdkFileVisitor());
        } catch (IOException e) {
            // 忽略单个目录的扫描错误
        }
    }

    static class JdkFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            if (Files.isRegularFile(dir.resolve("bin").resolve("javac.exe"))) {
                foundJdks.add(dir.toAbsolutePath().normalize());
                return FileVisitResult.SKIP_SUBTREE;
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            return FileVisitResult.SKIP_SUBTREE;
        }
    }
}