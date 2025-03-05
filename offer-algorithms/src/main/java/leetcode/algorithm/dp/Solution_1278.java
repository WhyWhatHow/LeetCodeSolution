package leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1278 {

    public static void main(String[] args) {
        Solution_1278 sol = new Solution_1278();
        System.out.println(sol.palindromePartition(
//                "abc", 2
//                "leetcode", 8
//                "tcymekt", 4
                "aabbc" ,3
        ));
        System.out.println("==================");
    }

    int[][] minCost; // S[i,j] -> pal min cost
    int[][] f; // s[0,i]中有k个分割的回文子串.

    public int palindromePartition(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        minCost = new int[n][n];
        f = new int[n][k + 1];
        for (int i = 0; i < f.length; i++) {
            Arrays.fill(f[i], -1);
        }
        init(cs);
        dfs(cs, n - 1, k);
        return f[n - 1][k];
    }

    /**
     * f[i][k] = f[l][k-1]+ minCost[l+1][i];
     *
     * @param cs
     * @param i
     * @param k
     * @return
     */
    private int dfs(char[] cs, int i, int k) {

        if (i == k - 1) return f[i][k] = 0; // [0,i] 构建 k 个子串.
        if (k == 1) return f[i][k] = minCost[0][i];//
        if (f[i][k] != -1) return f[i][k];
        int res = Integer.MAX_VALUE;
        int start = Math.max(0, k - 2);
        for (int l = start; l < i; l++) { // s[l+1][i] 子串, 0,  k-2=l ,  i,
            res = Math.min(res, dfs(cs, l, k - 1) + minCost[l + 1][i]);
        }

        return f[i][k] = res;
    }

    private void init(char[] cs) {
        int n = cs.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                // aa, aba
                if (j - i <= 2) minCost[i][j] = cs[i] == cs[j] ? 0 : 1;
                else {
                    minCost[i][j] += cs[i] == cs[j] ? 0 : 1;
                    minCost[i][j] += minCost[i + 1][j - 1]; //s[i+1,j-1]
                }
            }
        }
    }
}


