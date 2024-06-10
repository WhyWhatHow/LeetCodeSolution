package leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_518 {

    public static void main(String[] args) {
        Solution_518 sol = new Solution_518();
//        System.out.println(Integer.MAX_VALUE);
        int change = sol.change(5, new int[]{1, 2, 5});
        System.out.println(change);
    }

    /**
     *
     * dp[i] 表示 金额为i的 金币组成方式
     * 当amount =0 ,可以不选择任何金币,所以dp[0]=1
     *
     * condition {i>coins[j]} --> dp[i] = +dp[i-coins[j]]
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; //?  当amount =0 ,可以不选择任何金币,所以dp[0]=1
        Arrays.sort(coins);

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if (j < coins[i]) continue;
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

}


