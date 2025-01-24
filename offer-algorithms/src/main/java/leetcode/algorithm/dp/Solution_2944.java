package leetcode.algorithm.dp;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2944 {

    public static void main(String[] args) {
        Solution_2944 sol = new Solution_2944();
        System.out.println(sol.minimumCoins(new int[]{
//                26,18,6,12,49,7,45,45
                32, 4
        }));
        System.out.println("==================");
    }

    /**
     * f[i] mean's [0,i] range min Coins used.
     * p[i] -> [i+1,i+i] range min coins used.
     *
     * @param prices
     * @return
     */
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        int[] mem = new int[n + 1]; //
        return dfs(1, prices, mem);
    }

    // dfs(i) means [i,n) min coin used.
    // dfs(i) = prices[i-1] + min(dfs(j)) , j==> [i+1, 2i+1]
    private int dfs(int i, int[] prices, int[] mem) {
        if (i * 2 >= prices.length) return prices[i - 1];
        if (mem[i] != 0) return mem[i];
        int res = Integer.MAX_VALUE;

        for (int j = i + 1; j <= 2 * i + 1; j++) {
            res = Math.min(res, dfs(j, prices, mem));
        }

        return mem[i] = res + prices[i - 1];
    }


}
