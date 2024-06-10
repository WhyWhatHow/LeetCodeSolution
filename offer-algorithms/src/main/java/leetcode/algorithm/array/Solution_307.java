package leetcode.algorithm.array;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_307 {

    public static void main(String[] args) {
        Solution_307 sol = new Solution_307();

        System.out.println("==================");
    }


}


class NumArray {
    int[] nums;
    int[] tree;

    public NumArray(int[] nums) {
        this.nums = new int[nums.length];
        tree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }
    }

    public void update(int index, int val) {
        int temp = val - nums[index];
        nums[index] = val;
        for (int i = index + 1; i < tree.length; i += lowbit(i)) {
            tree[i] += temp;
        }
    }

    int query(int idx) {
        int sum = 0;
        for (int i = idx + 1; i > 0; i -= lowbit(i)) {
            sum += tree[i];
        }
        return sum;
    }

    // 计算 low bit , 比如6-> 2
    int lowbit(int i) {
        return -i & i;
    }
    // [left, right] = [0,right]-[0,left-1]
    public int sumRange(int left, int right) {
        return query(right) - query(left-1);
    }
}

