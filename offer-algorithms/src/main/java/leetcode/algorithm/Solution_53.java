package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_53 {
    /**
     * dp[i] : 表示从 0 到i 的 子数组的最大和
     * dp[i] = nums[i] + math.max(dp[i-1],0)
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + Math.max(dp[i - 1], 0);
        }

        for (int i : dp) {
//            System.out.println(i);
            res = Math.max(res, i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_53 sol = new Solution_53();
        int i = sol.maxSubArray(new int[]{
//                -2, 1, -3, 4, -1, 2, 1, -5, 4
                -2, -1
        });
        System.out.println(i);
        System.out.println("==================");
    }
}


