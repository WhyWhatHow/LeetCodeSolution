package leetcode.algorithm.prefix;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_330 {

    public static void main(String[] args) {
        Solution_330 sol = new Solution_330();
        System.out.println("==================");
    }


}


class NumArray {
    int[] s; // s[i] means nums[0,i) prefix sum,
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        s = new int[nums.length + 1];
        s[0] = 0;
        for (int i = 1; i < s.length; i++) {
            s[i] = s[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return s[right + 1] - s[left];
    }
}