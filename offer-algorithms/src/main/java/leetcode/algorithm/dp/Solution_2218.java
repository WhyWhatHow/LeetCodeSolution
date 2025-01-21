package leetcode.algorithm.dp;

import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #dp 0-1
 * @author: WhyWhatHow
 **/

public class Solution_2218 {

    public static void main(String[] args) {
        Solution_2218 sol = new Solution_2218();
        System.out.println("==================");
    }

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] mem = new int[n][k + 1];
        return dfs(n - 1, k, piles, mem);
    }

    /**
     * from [0,i] piles, get j number of coin's max value.
     * int max  =   Max(dfs(i-1,j-w)+v;) // w mean's in piles[i], we chose w number of coins.
     * dfs(i,j) Max(max, dfs(i-1, j) )
     *
     * @param i
     * @param j
     * @param piles
     * @param mem
     * @return
     */
    private int dfs(int i, int j, List<List<Integer>> piles, int[][] mem) {
        if (i < 0) return 0;

        if (mem[i][j] != 0) return mem[i][j];

        int res = dfs(i - 1, j, piles, mem); // [
        int len = Math.min(j, piles.get(i).size());
        int v = 0; // v means in piles[i], get w number of coins value.
        for (int w = 0; w < len; w++) {
            v += piles.get(i).get(w);
            res = Math.max(res, dfs(i - 1, j - 1 - w, piles, mem) + v);
        }

        mem[i][j] = res;
        return res;
    }
}
