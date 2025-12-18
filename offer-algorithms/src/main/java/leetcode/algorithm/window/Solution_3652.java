package leetcode.algorithm.window;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3652 {

    public static void main(String[] args) {
        Solution_3652 sol = new Solution_3652();
        System.out.println(sol.maxProfit(
                new int[]{4, 2, 8, 10, 16},
                new int[]{-1, 0, 1, 1, -1},
                4));
        System.out.println("==================");
    }

    /**
     * strategy[i] 表示第 i 天的交易策略，其中：
     * -1 表示买入一单位股票。
     * 0 表示持有股票。
     * 1 表示卖出一单位股票。
     * <p>
     * 同时给你一个 偶数 整数 k，你可以对 strategy 进行 最多一次 修改。一次修改包括：
     * <p>
     * 选择 strategy 中恰好 k 个 连续 元素。
     * 将前 k / 2 个元素设为 0（持有）。
     * 将后 k / 2 个元素设为 1（卖出）。
     * 利润 定义为所有天数中 strategy[i] * prices[i] 的 总和 。
     *
     * @param prices
     * @param strategy
     * @param k
     * @return
     */
    public long maxProfit(int[] prices, int[] strategy, int k) {
        // 定长滑动数组模拟每一种情况.
        int n = prices.length;
        long[] ps = new long[n + 1];
        for (int i = 0; i < prices.length; i++) {
            ps[i + 1] = ps[i] + prices[i] * strategy[i];
        }
        long res = ps[n];
        int l = 0; // k-> 0,1
        long tmp = 0;
        for (int i = k / 2; i < n; ) {
            if (i - l == k) {
                tmp -= prices[l + (i - l) / 2];
                l++;
            }
            while (i - l < k && i < n) {
                tmp += prices[i];
                i++;
            }
            // 更新res : l-r range sum = ps[r+1]-ps[l] ;
            // new res= max (res, ps[n] - sum(l,r) + change(l,r)) ;
            res = Math.max(res, ps[n] - (ps[i] - ps[l]) + tmp);
        }
        return res;
    }

}


