import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * JdkScanner 类用于扫描指定路径下的所有JDK安装。
 * 这个版本使用了 Files.walkFileTree 和自定义的 FileVisitor，
 * 以便能优雅地处理 "Access Denied" 异常，避免程序崩溃。
 */
public class JdkScanner {

    public static void main(String[] args) {
        // 1. 设置起始路径和最大扫描深度
        final Path startDir = Paths.get("C:\\");
        final int maxDepth = 5;
        final Set<Path> foundJdks = new HashSet<>();

        System.out.println("开始扫描 C:\\ 盘寻找 JDKs，最大深度为 " + maxDepth + "...");
        System.out.println("注意：此过程可能需要几分钟，具体取决于您的磁盘性能和文件数量。");
        System.out.println("----------------------------------------------------------");

        long startTime = System.currentTimeMillis();

        // 2. 创建自定义的 FileVisitor 实例
        JdkFileVisitor visitor = new JdkFileVisitor(foundJdks);

        // 为了让 walkFileTree 遵循符号链接（比如 C:\Documents and Settings），我们添加一个选项。
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);

        try {
            // 3. 使用 walkFileTree 开始遍历，它比 Files.walk() 更能容忍错误
            Files.walkFileTree(startDir, options, maxDepth, visitor);
        } catch (IOException e) {
            // walkFileTree 本身也可能在启动时就失败，虽然概率较小
            System.err.println("启动文件遍历时发生致命错误: " + e.getMessage());
        }

        long endTime = System.currentTimeMillis();

        // 4. 打印结果
        System.out.println("\n----------------------------------------------------------");
        if (foundJdks.isEmpty()) {
            System.out.println("扫描完成，未找到任何 JDK。");
        } else {
            System.out.println("扫描完成！共找到 " + foundJdks.size() + " 个 JDK：");
            // 为了美观，对结果进行排序后输出
            foundJdks.stream().sorted().forEach(System.out::println);
        }
        System.out.println("总耗时: " + (endTime - startTime) / 1000.0 + " 秒。");
    }
}

/**
 * 自定义的 FileVisitor，用于在遍历文件树时寻找 JDK。
 */
class JdkFileVisitor extends SimpleFileVisitor<Path> {

    private final Set<Path> foundJdks;

    public JdkFileVisitor(Set<Path> foundJdks) {
        this.foundJdks = foundJdks;
    }

    /**
     * 在访问一个目录之前被调用。
     * 我们在这里检查这个目录是否是 JDK 的根目录。
     */
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        // 检查 "bin/javac.exe" 是否存在
        Path javacPath = dir.resolve("bin").resolve("javac.exe");

        if (Files.isRegularFile(javacPath)) {
            // 找到了一个 JDK！
            foundJdks.add(dir.normalize());

            // 优化：既然已经确认这是一个JDK目录，就没有必要再深入扫描它的子目录了。
            // 跳过此目录的子树可以提高效率。
            return FileVisitResult.SKIP_SUBTREE;
        }

        // 继续遍历
        return FileVisitResult.CONTINUE;
    }

    /**
     * 当访问文件或目录失败时被调用。这是处理 AccessDeniedException 的关键。
     */
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        if (exc instanceof AccessDeniedException) {
            // 如果是访问被拒绝，打印一条警告信息，然后跳过这个目录/文件。
            // System.err.println("跳过无法访问的路径: " + file + " (" + exc.getMessage() + ")");
            return FileVisitResult.SKIP_SUBTREE; // 跳过这个目录和它的所有子目录
        }

        // 对于其他类型的IO异常，我们打印错误并继续
        System.err.println("访问时发生错误: " + file + " [" + exc + "]");
        return FileVisitResult.CONTINUE;
    }
}

