package leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_300 {

    public static void main(String[] args) {
        Solution_300 sol = new Solution_300();
        int i = sol.lengthOfLIS(new int[]{
                10,9,2,5,3,7,101,18
        });
        System.out.println(i);

        System.out.println("==================");
    }

    /**
     * dp[i] i pos max length of (0,i)
     * j <==>(0,i) == 0<=j<i,
     *      if nums[i] >nums[j] dp[i] = max(dp[j]+1,dp[i]);
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        // init
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        //
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }


        int res = -1;
        for (int i : dp) {
            res = res < i ? i : res;
        }
        return res;
    }
}


