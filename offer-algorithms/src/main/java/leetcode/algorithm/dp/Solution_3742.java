package leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3742 {

    public static void main(String[] args) {
        Solution_3742 sol = new Solution_3742();//

        System.out.println("==================");
    }

    //    值为 0 的单元格：分数增加 0，花费 0。
//    值为 1 的单元格：分数增加 1，花费 1。
//    值为 2 的单元格：分数增加 2，花费 1。
    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        //
        int[][][] f = new int[n][m][k]; // f(i,j,k) means go to point(i,j) maxScore.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(f[i][j], -1);
            }
        }
        f[0][0][0] = grid[0][0];
        dfs(f, grid, n - 1, m - 1, k);

        int res = 0;
        for (int i = 0; i < k; i++) {
            res = Math.max(f[n - 1][m - 1][i], res);
        }
        return res;

    }

    //f(i,j,k) means in point(i,j) ,max cost=k , maxPathScore.
//     nk = k==0?k:k-1;
    // f(i,j,k) = max ( f(i-1,j,k-1?0), f(i,j-1,k-1?0)) +x
    private int dfs(int[][][] f, int[][] grid, int i, int j, int k) {
        if (i < 0 || j < 0 || k < 0) return Integer.MIN_VALUE;
        if (i == 0 && j == 0) return 0;
        if (f[i][j][k] != -1) return f[i][j][k];

        int res = 0;
        boolean yes = grid[i][j] == 0;
        int nk = yes ? k : k - 1;
        res = Math.max(
                dfs(f, grid, i - 1, j, nk),
                dfs(f, grid, i, j - 1, nk)) + grid[i][j];

        f[i][j][k] = res;
        return res;
    }


}
