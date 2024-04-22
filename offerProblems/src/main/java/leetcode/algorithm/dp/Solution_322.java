package leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_322 {

    public static void main(String[] args) {
        Solution_322 sol = new Solution_322();

        int i = sol.coinChange(new int[]{
//                        1, 2, 5
                        2
                },
//                11
//                3
                0
        );
        System.out.println(i);
        System.out.println("==================");
    }

//
    /**
     * dp[i] => i min num coins
     * dp[0] = 0 ;
     * dp[i] = min(dp[i],dp[i-coin]+1);
     * dp[i-coin] +1 ( value = coin )
     *
     *
     * 确定状态：
     * 创建一个数组 dp 来表示各种金额所需的最少硬币数量，其中 dp[i] 的值就是凑成金额 i 所需的最小硬币数量。
     * 初始化状态：
     * 初始化 dp[0] = 0，因为金额为 0 时，不需要任何硬币。
     * 对于所有金额 i > 0，可以将 dp[i] 初始化为一个大数，例如 amount + 1，表示在初始状态下，我们不知道如何凑成金额 i。
     * 状态转移方程：
     * 对于每个金额 i，遍历所有的硬币面额 coin。如果硬币面额小于等于金额 i，我们就看看是否能在已有的硬币数基础上加上一个硬币 coin，使得硬币数更少：
     * plaintext
     *    dp[i] = min(dp[i], dp[i - coin] + 1)
     * 这里，dp[i - coin] + 1 表示如果取一个硬币面额为 coin 的硬币，那么凑成金额 i 所需硬币的最小数量就是凑成金额 i - coin 所需的最小数量加上这一个硬币。
     * 遍历顺序：
     * 金额 i 从 1 遍历到 amount。
     * 每一个金额 i，都要遍历一遍所有的硬币面额。
     * 最终答案：
     * 最终 dp[amount] 就是所求答案。如果 dp[amount] 的值为初始化的 amount + 1，表示无法凑出该金额，返回 -1。
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
//
        int[] dp = new int[amount + 1];
        // init
        int max = amount + 1;
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int coin : coins) {
            if (coin < amount) {
                dp[coin] = 1;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] >= max ? -1 : dp[amount];
    }

}


