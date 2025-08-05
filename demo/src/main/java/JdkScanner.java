import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * JdkScannerV3 使用多线程并发模型，以达到最快的扫描速度。
 * 它将 C:\ 下的每个子目录作为一个独立任务，交给线程池并发处理。
 */
public class JdkScanner {

    // 必须使用线程安全的 Set 来收集结果
    private static final Set<Path> foundJdks = ConcurrentHashMap.newKeySet();
    private static final int MAX_DEPTH = 5;

    public static void main(String[] args) {
        System.out.println("开始使用终极优化策略 (多线程并发扫描)...");
        long startTime = System.currentTimeMillis();

        // 定义需要从根目录直接排除的文件夹
        final Set<String> rootExclusions = new HashSet<>(Arrays.asList(
                "Windows", "ProgramData", "$Recycle.Bin", "System Volume Information",
                "Recovery", "PerfLogs", "Documents and Settings"
        ));

        Path root = Paths.get("C:\\");

        // 创建一个固定大小的线程池，大小通常设为CPU核心数，以实现计算和I/O的最佳平衡
        int poolSize = Runtime.getRuntime().availableProcessors();
        System.out.println("初始化线程池，大小为: " + poolSize);
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);

        // 获取 C:\ 根目录下的所有子目录
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(root)) {
            for (Path subDir : stream) {
                if (Files.isDirectory(subDir)) {
                    // 如果目录不在排除列表中，则为其创建一个扫描任务并提交到线程池
                    if (!rootExclusions.contains(subDir.getFileName().toString())) {
                        System.out.println("  -> 已分配扫描任务: " + subDir);
                        Runnable task = () -> scanDirectory(subDir);
                        executor.submit(task);
                    } else {
                        System.out.println("  -> 已跳过 (根据排除列表): " + subDir);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("错误：无法列出 C:\\ 的目录。请检查权限。 " + e.getMessage());
        }

        // 关闭线程池并等待所有任务完成
        // 这是确保主线程在所有扫描都结束后再继续执行的关键步骤
        executor.shutdown();
        try {
            // 等待最多10分钟，以防某些目录扫描时间过长
            if (!executor.awaitTermination(10, TimeUnit.MINUTES)) {
                System.err.println("扫描超时，部分目录可能未完成。");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.println("扫描过程被中断。");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        long endTime = System.currentTimeMillis();

        // 打印最终结果
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
     * 在单个线程中扫描指定的目录树。
     * @param startDir 要扫描的起始目录。
     */
    private static void scanDirectory(Path startDir) {
        try {
            Files.walkFileTree(startDir, new HashSet<>(), MAX_DEPTH, new JdkFileVisitor());
        } catch (IOException e) {
            // 在并发环境中，单个子任务的失败不应影响其他任务
            // System.err.println("扫描 " + startDir + " 时出错: " + e.getMessage());
        }
    }

    /**
     * FileVisitor 的实现保持不变，它本身是独立的。
     * 它负责检查JDK，并将结果添加到线程安全的 Set 中。
     */
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
            // 优雅地跳过无法访问的目录，这是保证并发任务顺利执行的关键
            return FileVisitResult.SKIP_SUBTREE;
        }
    }
}