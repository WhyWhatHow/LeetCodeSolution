package dsa;

/**
 * @program: LeetCodeSolution
 * @description: 树状数组
 * @author: WhyWhatHow
 * @create: 2024-06-05 20:37
 **/
public class FenwickTree {
    private int[] tree;
    private int n;

    public FenwickTree(int size) {
        this.n = size;
        this.tree = new int[n + 1]; // tree 的索引从 1 开始
    }

    // 更新操作：将索引 i 的值增加 value
    public void update(int i, int value) {
        while (i <= n) {
            tree[i] += value;
            i += lowbit(i); // 移动到下一个区间
        }
    }

    // 前缀和查询：计算从起始位置到索引 i 的和
    public int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= lowbit(i); // 移动到前一个区间
        }
        return sum;
    }

    // 区间和查询：计算从索引 l 到索引 r 的和
    public int queryRange(int l, int r) {
        return query(r) - query(l - 1);
    }

    // 计算 lowbit
    private int lowbit(int x) {
        return x & -x;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 5, 7, 9, 11}; // 示例数组，索引从 1 开始
        FenwickTree fenwickTree = new FenwickTree(arr.length - 1);

        // 初始化树状数组
        for (int i = 1; i < arr.length; i++) {
            fenwickTree.update(i, arr[i]);
        }

        // 查询前缀和
        System.out.println(fenwickTree.query(3)); // 输出 9 (1 + 3 + 5)

        // 更新操作
        fenwickTree.update(3, 2); // 将索引 3 的值增加 2

        // 再次查询前缀和
        System.out.println(fenwickTree.query(3)); // 输出 11 (1 + 3 + 7)

        // 区间和查询
        System.out.println(fenwickTree.queryRange(2, 5)); // 输出 24 (3 + 7 + 7 + 9)
    }
}
