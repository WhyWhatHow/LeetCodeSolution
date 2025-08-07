package leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_931 {

    public static void main(String[] args) {
        Solution_931 sol = new Solution_931();

        System.out.println("==================");
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < f.length; i++) {
            Arrays.fill(f[i], Integer.MIN_VALUE);
        }
        for (int i = 0; i < n; i++) {
            f[0][i] = matrix[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = f[i - 1][j] + matrix[i][j];
                if (j - 1 >= 0) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + matrix[i][j]);
                }
                if (j + 1 < n)
                    f[i][j] = Math.min(f[i][j], f[i - 1][j + 1] + matrix[i][j]);
            }
        }

        int res = f[n - 1][0];
        for (int i = 1; i < n; i++) {
            res = Math.min(res, f[n - 1][i]);
        }
        return res;
    }
}


