package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_198 {
    /***
     *  设dp[i]  表示 从 0-i 抢劫获取得到的最大值
     *   dp[0] =nums[0]
     *   dp[1] =math.max(nums[0],nums[1])
     *   dp[i] = math.max(dp[i-1], dp[i-2]+nums[i]) // dp[i-2] 表示从0到i-2 这个过程取得的最大值
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i],dp[i-1]) ;
//            if (max < dp[i]) {
//                max = dp[i];
//            }
        }
        return dp[dp.length-1];

    }

    public static void main(String[] args) {
        Solution_198 sol = new Solution_198();
        int rob = sol.rob(new int[]{
//                1, 2, 3, 1
                2,7,9,3,1
//                2,1,1,2
        });
        System.out.println(rob);
        System.out.println("==================");
    }
}


