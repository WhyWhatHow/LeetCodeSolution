package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_64 {
    /**
     *  第一行:        dp[0][i] = grid[0][i] + dp[0][i - 1];
     *
     *  第一 列:          dp[i][0] = dp[i - 1][0] + grid[i][0];
     * 其他:
     *
     * dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
     *
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        // 处理 dp[0][j] 向右走
        for (int i = 1; i < n; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        // 处理 dp[i][0] 向下走
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        res = dp[m - 1][n - 1];
        return res;
    }

    public static void main(String[] args) {
        Solution_64 sol = new Solution_64();
        int i = sol.minPathSum(new int[][]{

                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        });
        System.out.println(i);
        System.out.println("==================");
    }
}


