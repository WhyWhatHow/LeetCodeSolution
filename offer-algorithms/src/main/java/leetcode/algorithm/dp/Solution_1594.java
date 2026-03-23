package leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1594 {

    public static void main(String[] args) {
        Solution_1594 sol = new Solution_1594();//
        System.out.println(sol.maxProductPath(
                new int[][]{{1, -1, 2, 1, -1, 0, 0, 4, 3, 2, 0, -2, -2}, {-2, 3, 3, -1, -1, 0, 0, -2, 4, -3, 3, 0, 0}, {-4, -1, -1, -2, 2, -1, -2, -2, 0, 3, -1, -4, 1}, {-3, 4, -3, 0, -3, 1, -3, 1, 4, 4, -4, -4, -2}, {3, -3, 1, 0, -1, -4, -4, -4, 3, 2, 2, 3, 3}, {2, -1, -1, -4, -3, -3, 4, 2, 3, 4, 4, -4, 0}, {4, -1, 2, -3, -1, -1, -3, -4, 4, 4, 4, -3, -1}, {-3, -4, 4, -2, -1, 2, 3, -1, 2, 3, 4, 4, -4}, {-3, -1, -2, 1, 1, -1, -3, -4, -3, 1, -3, 3, -4}, {2, 4, 4, 4, -3, -3, 1, -1, 3, 4, -1, 1, 4}, {2, -2, 0, 4, -1, 0, -2, 4, -4, 0, 0, 2, -3}, {1, 1, -3, 0, -4, -4, -4, -4, 0, -1, -4, -1, 0}, {3, -1, -3, -3, -3, -2, -1, 4, -1, -2, 4, 2, 3}}
        ));

        System.out.println("==================");
    }

    int mod = 1000_000_007;

    public int maxProductPath(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        //set f(i,j) means (i,j) range 路径中的最大值.
        long[][] f = new long[n][m];
        long[][] mns = new long[n][m]; // mns(i,j) means (i,j) range 最小值. 负负得正.

        for (int i = 0; i < f.length; i++) {
            Arrays.fill(f[i], 1);
            Arrays.fill(mns[i], 1);
        }
        mns[0][0] = f[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            mns[0][i] = f[0][i] = f[0][i - 1] * grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            mns[i][0] = f[i][0] = f[i - 1][0] * grid[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // wa : 不能取模, 取模会导致负数->0
                long a = 1l * f[i - 1][j] * grid[i][j];
                long b = 1l * f[i][j - 1] * grid[i][j];
                long c = 1l * mns[i - 1][j] * grid[i][j];
                long d = 1l * mns[i][j - 1] * grid[i][j];
                f[i][j] = getMax(a, b, c, d);
                mns[i][j] = getMIn(a, b, c, d);
            }
        }
        int ans = (int) (f[n - 1][m - 1] % mod);
        return f[n - 1][m - 1] < 0 ? -1 : ans;
    }

    private long getMax(long a, long b, long c, long d) {
        return Math.max(Math.max(a, b), Math.max(c, d));
    }

    private long getMIn(long a, long b, long c, long d) {
        return Math.min(Math.min(a, b), Math.min(c, d));
    }
}
