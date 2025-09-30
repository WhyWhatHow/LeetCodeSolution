package leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1039 {

    public static void main(String[] args) {
        Solution_1039 sol = new Solution_1039();
        System.out.println(sol.minScoreTriangulation(new int[]{
                1,3,1,4,1,5
        }));
        System.out.println("==================");
    }

    // set f[i][j] means[i,j] range , min ScoreTriangulation value.
    // f[i][i+1] = 0 ; // can't build a trangle
    // f[i][j] = f[i][k]+ f[k][j] + v[i]*v[j]*v[k];  // k belong to [i+1, j)
    // ans is f[0][n-1]
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < f.length; i++) {
            Arrays.fill(f[i], -1);
        }
        return  dfs(0, n - 1, values, f);

    }

    private int dfs(int i, int j, int[] vs, int[][] f) {
        if (j == i + 1) return 0; // [i,i+1] only two points, not a triangle
        if (f[i][j] != -1) {
            return f[i][j];
        }
        int res = Integer.MAX_VALUE;

        for (int k = i + 1; k < j; k++) {
            res = Math.min(res, dfs(i, k, vs, f) + dfs(k, j, vs, f) + vs[i] * vs[j] * vs[k]);
        }

        return f[i][j] = res;
    }
}


