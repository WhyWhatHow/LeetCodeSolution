package leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_1463 {

    public static void main(String[] args) {
        Solution_1463 sol = new Solution_1463();
        System.out.println(sol.cherryPickup(new int[][]{
//                {3, 1, 1},
//                {2, 5, 1},
//                {1, 5, 5},
//                {2, 1, 1}
                /////////////////////////
                {0, 8, 7, 10, 9, 10, 0, 9, 6},
                {8, 7, 10, 8, 7, 4, 9, 6, 10},
                {8, 1, 1, 5, 1, 5, 5, 1, 2},
                {9, 4, 10, 8, 8, 1, 9, 5, 0},
                {4, 3, 6, 10, 9, 2, 4, 8, 10},
                {7, 3, 2, 8, 3, 3, 5, 9, 8},
                {1, 2, 6, 5, 6, 2, 0, 10, 0}

        }));
        System.out.println("==================");
    }

    /**
     * 机器人 1 从左上角格子 (0,0) 出发，机器人 2 从右上角格子 (0, cols-1) 出发
     * 格子 (i,j) 出发，机器人可以移动到格子 (i+1, j-1)，(i+1, j) 或者 (i+1, j+1) : 即左下,下,右下.
     * dp[i][j][k] : 表示第I行A(i,j), 与B(i,k) 取得的最大值. | i row : A_col:j , B_col: k maxCherry |
     * dp[i][j][k] = max(dp[i-1][jj][kk]) +val
            * val: j==k ->  val = grid[i][j]
                 * j!=k =>  val = grid[i][j]+grid[i][k]
            * dp[i-1][jj][kk] 表示,第i层的取值.  jj -> {j-1,j+1,j} kk->{k-1,k,k+1}
     *`hint`:
     *      需要注意 某些节点的 上一层取不到有效值, dp[i][j][k] 的更新只能是在 max(dp[i-1][jj][kk]) >0 时候 进行更新.
     * @param grid
     * @return
     */
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][][] dp = new int[rows][cols][cols];

        // init
        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }

        // A[0,0] B[0,col-1]
        dp[0][0][cols - 1] = grid[0][0] + grid[0][cols - 1];

        // running
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < cols; k++) {

                    int val = grid[i][j];
                    if (j != k) val += grid[i][k];

                    // get max dp[i-1][jj][kk]
                    int max = -1;
                    for (int jj = j - 1; jj <= j + 1; jj++) {
                        for (int kk = k - 1; kk <= k + 1; kk++) {
                            // broad case
                            if (jj < 0 || jj >= cols || kk < 0 || kk >= cols) continue;
////                            can't be reach  point
                            if (dp[i - 1][jj][kk] == -1) continue;
                            max = Math.max(max, dp[i - 1][jj][kk]);
//                            if (0 <= jj && jj < cols && 0 <= kk && kk < cols && dp[i - 1][jj][kk] != -1) {
////                                max = Math.max(max, dp[i - 1][jj][kk]); // why ?
//                                dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][jj][kk]+val);
//                            }
                        }
                    }
                    // dp[i][j][k] = max(dp[i][jj][kk]), (jj->{j-1,j,j+1} ,kk ->{k-1,k,k+1}) + val
                    if (max == -1) continue;  // 排除为空的情况.
                    dp[i][j][k] = max + val;
                }
            }
        }

        int res = -1;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < cols; j++) {
                res = Math.max(res, dp[rows - 1][i][j]);
            }
        }

        return res;
    }

}


