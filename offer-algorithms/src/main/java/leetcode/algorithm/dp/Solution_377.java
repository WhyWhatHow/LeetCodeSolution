package leetcode.algorithm.dp;

/**
 * @program: LeetCodeSolution
 * @description:  #dp
 * @author: WhyWhatHow
 **/

public class Solution_377 {

    public static void main(String[] args) {
        Solution_377 sol = new Solution_377();
        System.out.println("==================");
        int i = sol.combinationSum4(new int[]{1, 2, 3}, 4);
        System.out.println(i);
    }

/**
 * 类比爬楼梯, nums[i]  表示一次可以爬的楼梯数量
 */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }



}


