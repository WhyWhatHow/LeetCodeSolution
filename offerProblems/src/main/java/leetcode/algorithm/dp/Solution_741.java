package leetcode.algorithm.dp;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_741 {

    public static void main(String[] args) {
        Solution_741 sol = new Solution_741();
        System.out.println(sol.cherryPickup(new int[][]{
                {0, 1, -1}, {1, 0, -1}, {1, 1, 1}
//                {1, 1, -1}, {1, -1, 1}, {-1, 1, 1}
//                {0, 1, 1, 0, 0}, {1, 1, 1, 1, 0}, {-1, 1, 1, 1, -1}, {0, 1, 1, 1, 0}, {1, 0, -1, 0, 0} // 11
        }));
        System.out.println("==================");
    }


    /**
     * 问题转化: 两人同时从(0,0)点出发 -> 到达(n-1,n-1) 过程中可以摘取的最大樱桃数.
     * hard: A(x1,y1) , B(x2,y2) 由于同时出发, 所以说步数相同 即 x1+y1=x2+y2 ,
     * 去掉AB 两人 同时位于同一个坐标的情况.
     * * A,B 到达(n-1,n-1) 一共走了 2n-2 步.
     * 设 f[k][i][ii]: 走了k步, A位于(i, k-i) , B 位于(ii, k-ii) 时 拿到的最大樱桃数.
     * A(i,k-i) B(ii, k-ii)
     * f[k][i][ii]  由 k-1 确定.
     * a:  A 右, B右 --> f[k-1][i][ii]
     * b:  A 右, B下 --> f[k-1][i][ii-1]
     * c:  A 下, B右 --> f[k-1][i-1][ii]
     * d:  A 下, B下 --> f[k-1][i-1][ii-1]
     * i!=ii : (A,B 不同位置)
     * f[k][i][ii] = max(a,b,c,d) + grid[i][k-i] + grid[ii][k-ii]
     * i ==ii : (A,B 同一位置)
     * f[k][i][ii] = max(a,b,c,d) + grid[i][k-i]
     * `init`:
     * 设 start :  f[2][1][1] = grid[0][0]
     * 对应的终点: f[2n][n][n] = grid[n-1][n-1]
     *
     * @param grid
     * @return
     */
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int nn = n + 2;
        int[][][] dp = new int[2 * nn][nn][nn];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k < dp[0][0].length; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        // running
        dp[2][1][1] = grid[0][0]; // grid[][] 在左侧与上侧加了一组.

        for (int k = 3; k < 2 * nn; k++) {
            for (int i = 1; i <= n; i++) {
                for (int ii = 1; ii <= n; ii++) {
                    int j = k - i, jj = k - ii;
                    if (i < 1 || ii < 1) continue;
                    if (j < 1 || jj < 1 || n < j || n < jj) continue;
                    // border check
                    if (grid[i - 1][j - 1] == -1 || grid[ii - 1][jj - 1] == -1) continue; // not pass

                    int va = grid[i - 1][j - 1], vb = grid[ii - 1][jj - 1];
                    int dd = dp[k - 1][i - 1][ii - 1];
                    int dr = dp[k - 1][i - 1][ii];
                    int rd = dp[k - 1][i][ii - 1];
                    int rr = dp[k - 1][i][ii];
                    int max = Math.max(Math.max(dd, dr), Math.max(rd, rr)) + va;
                    if (i != ii) max += vb;
                    dp[k][i][ii] = max;
                }
            }

        }
        return dp[2 * n ][n][n] < 0 ? 0 : dp[2 * n ][n][n];

    }

    public int cherryPickupOld(int[][] grid) {
        int n = grid.length;
        int nn = n + 2;
        int[][][] dp = new int[2 * nn][nn][nn];
        // init dp
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k < dp[0][0].length; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        // running
        dp[2][1][1] = grid[0][0]; // 相当于 数组向右向上
        for (int k = 3; k < 2 * nn; k++) { // k 步数,
            for (int i = 1; i <= n; i++) {
                for (int ii = 1; ii <= n; ii++) {
                    int j = k - i, jj = k - ii;
                    // 边界判定
                    if (j < 1 || jj < 1 || n < j || n < jj) continue;

                    if (grid[i - 1][j - 1] == -1 || grid[ii - 1][jj - 1] == -1) continue; // not pass
                    int rr = dp[k - 1][i][ii]; // r r
                    int rd = dp[k - 1][i][ii - 1]; // r d
                    int dr = dp[k - 1][i - 1][ii];
                    int dd = dp[k - 1][i - 1][ii - 1];
                    int max = Math.max(Math.max(rr, rd), Math.max(dr, dd)) + grid[i - 1][j - 1];
                    if (i != ii) max += grid[ii - 1][jj - 1];
                    dp[k][i][ii] = max;
                }
            }
        }
        return dp[2 * n][n][n] < 0 ? 0 : dp[2 * n][n][n];
    }
}


