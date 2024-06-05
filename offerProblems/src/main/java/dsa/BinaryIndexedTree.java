package dsa;

/**
 * @program: LeetCodeSolution
 * @description: 树状数组
 * @author: WhyWhatHow
 * @create: 2024-06-05 21:21
 **/
public class BinaryIndexedTree {
    int[] tree;
    int[] nums;

    public BinaryIndexedTree(int[] nums) {
        this.nums = new int[nums.length];
        tree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }
    }

    // update [idx+1,tree.length) val
    void update(int idx, int val) {
        for (int i = idx + 1; i < tree.length; i += lowbit(i)) {
            tree[i] += val;
        }
    }

    // [1,idx] 前缀和
    int query(int idx) {
        int sum = 0;
        for (int i = idx; i > 0; i -= lowbit(i)) {
            sum += tree[i];
        }
        return sum;
    }

    // [left,right]  = [1,right]-[1,left-1]
    int queryRange(int left, int right) {
        return query(right) - query(left - 1);
    }

    // 返回i 的最右侧的第一个i
    //eg: 6->2
    int lowbit(int i) {
        return -i & i;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 45, 6, 9, 1, 7, 10};
        BinaryIndexedTree tree = new BinaryIndexedTree(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(tree.query(i));
        }


        // 测试更新操作
        tree.update(3, 15); // 将索引 3 的值更新为 15
        System.out.println("After update:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Prefix sum of index " + i + ": " + tree.query(i));
        }

        // 测试区间和查询
        System.out.println("Sum of range [2, 5]: " + tree.queryRange(2, 5)); // 输出区间 [2, 5] 的和
    }
}



