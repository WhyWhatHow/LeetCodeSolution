package leetcode.algorithm.dp;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_1553 {

    public static void main(String[] args) {
        Solution_1553 sol = new Solution_1553();
        System.out.println(sol.minDays(10));
        System.out.println(sol.minDays(56));

        System.out.println("==================");
    }

    /**
     * 设dfs(n) , 吃掉n个橘子所要的天数
     * n = floor(n/2) + n % 2
         * n%2 == 0 : 偶数, 不用在意
         * n/2 == 1: 剩余1个,直接吃掉即可
     * n 为偶数时, 可以吃掉n/2个橘子
     * dfs(n) = dfs(n/2)+ n%2 +1
     * dfs(n/2)+n%2 :
     * +1 : 表示 `吃掉的 n/2 个橘子树` 所用的天数.
     * 所以索求时间就是dfs(n) =dfs(n/2)+n%2 + 1
     * ***************************************
     * n = floor(n/3) + n % 3
     * n%3 = 0,1,2 ->  当橘子数分别是0,1,2 时,所需要的天数刚好分别是0,1,2
     * 由 题意只, 当n%3 == 0 , --> 可以吃掉2n/3个橘子, 余 n/3个橘子
     * 对应为 dfs(n) = dfs(n/3)+ n%3  + 1
     * dfs(n/3)+n%3 剩余橘子吃掉所需要的时间
     * +1 : 当天吃掉了 2*n/3 个橘子
     * 吃掉n个橘子的最小天数
     *
     * @param n
     * @return
     */
    private int minDays(int n) {
        return dfs(n);
    }

    // 记忆吃过n个橘子所花的时间
    HashMap<Integer, Integer> map = new HashMap<>();

    int dfs(int n) {
        if (n <= 2) return n;
        if (map.containsKey(n)) {
            return map.get(n);
        }
        // n &1 偶数
        int v2 = dfs(n / 2) + n % 2 + 1; // +1 : 1day 吃掉了n/2个橘子
        int v3 = dfs(n / 3) + n % 3 + 1; // +1 : 1day 吃掉了2n/3个橘子
        int res = Math.min(v2, v3);

        // store
        map.put(n, res);
        return res;
    }

    /**
     * dp[i] : 吃i个橘子的最小天数
     * dp[i] = min(dp[i/2], dp[2*(i/3)], dp[i-1])+1
     *
     * @param n 2*10^9 越界,不可以
     * @return
     */
    public int minDaysByDp(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + 1;
            if ((i & 1) == 0)// 偶数
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[2 * (i / 3)] + 1);
            }
        }
        return dp[n];
    }

}


