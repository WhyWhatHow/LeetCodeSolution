package leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_674 {

    public static void main(String[] args) {
        Solution_674 sol = new Solution_674();
        int lengthOfLCIS = sol.findLengthOfLCIS(new int[]{
                1, 3, 5, 4, 7
        });
        System.out.println(lengthOfLCIS);


        System.out.println("==================");
    }

    /**
     * dp[i] [0,i] 最长连续递增子序列
     *
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int res = -1;
        for (int i = 0; i < dp.length; i++) {
            if (res < dp[i]) {
                res = dp[i];
            }
        }
        return res;
    }
}


