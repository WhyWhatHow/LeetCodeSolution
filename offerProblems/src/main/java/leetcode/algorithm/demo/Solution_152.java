package leetcode.algorithm.demo;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_152 {
    /**
     * 子数组最少可以有一个元素,也就是自身.
     * 设 dp[i] 为i位置的最大乘积
        * dp[i] = Math.max(nums[i], dp[i - 1] * nums[i]);
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] * nums[i]);
            max = dp[i] > max ? dp[i] : max;
        }
        return max;
//        [-2,-3,-2,4] [-2,0,-1]
//         2,6,-2,4   -2,0,0
    }

    public static void main(String[] args) {
        Solution_152 sol = new Solution_152();
        System.out.println("==================");
    }
}


