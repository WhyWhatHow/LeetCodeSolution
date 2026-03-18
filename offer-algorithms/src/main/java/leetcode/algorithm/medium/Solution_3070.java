package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3070 {

    public static void main(String[] args) {
        Solution_3070 sol = new Solution_3070();//
        System.out.println(sol.countSubmatrices(
                new int[][]{{7, 2, 9}, {1, 5, 0}, {2, 6, 6}},
                20
        ));
        System.out.println("==================");
    }

    public int countSubmatrices(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;
        long[][] f = new long[n][m];
        f[0][0] = grid[0][0];
        int cnt = f[0][0] > k ? 0 : 1;
        for (int i = 1; i < m; i++) {
            f[0][i] = f[0][i - 1] + grid[0][i];
            if (f[0][i] <= k) cnt++;
        }
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];
            if (f[i][0] <= k) cnt++;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1] + grid[i][j] - f[i - 1][j - 1];
                if (f[i][j] <= k) cnt++;
            }
        }


        return cnt;
    }
}
