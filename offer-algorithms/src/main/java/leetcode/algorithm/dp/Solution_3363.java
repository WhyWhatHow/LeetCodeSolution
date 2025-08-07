package leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3363 {

    public static void main(String[] args) {
        Solution_3363 sol = new Solution_3363();
        System.out.println(sol.maxCollectedFruits(new int[][]{
                {1, 2, 3, 4}, {5, 6, 8, 7}, {9, 10, 11, 12}, {13, 14, 15, 16}
        }));

        System.out.println("==================");
    }

    // f[i][j] 表示到达(i,j) 收集到的最多的水果数量
    //(0,0) 老哥只能走对角线,
    //(0,n-1)  右上区间 :  f[i][j] = max(f[i-1][j-1], f[i-1][j] ,f[i-1][j+1]) + fs[i][j]
    // (n-1, 0 ) 左下区间: (i,j) 位于右半部分 f[i][j] = max(f[i-1][j-1],f[i][j-1], f[i+1][j-1]) + fs[i][j]
    public int maxCollectedFruits(int[][] fs) {
        int n = fs.length;
        int[][] f = new int[n][n]; //
        int res = 0;
        for (int i = 0; i < f.length; i++) {
            Arrays.fill(f[i], Integer.MIN_VALUE);
        }
        for (int i = 0; i < fs.length; i++) {
            res += fs[i][i];
            f[i][i] = i == 0 ? fs[i][i] : res;
        }

        // (0,n-1)  -> (i+1, j-1), (i+1,j) , (i+1, j+1) // 看 x
        f[0][n - 1] = fs[0][n - 1];
        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = Math.max(f[i - 1][j - 1], f[i - 1][j]);
                if (j + 1 < n)
                    f[i][j] = Math.max(f[i][j], f[i - 1][j + 1]);
                f[i][j] += fs[i][j];// 当前节点的果实价值
            }
            y--;
        }

        // (n-1, 0 ) -> (
        // 左下区间
        f[n - 1][0] = fs[n - 1][0];
        for (int j = 1; j < n - 1; j++) {
            for (int i = j + 1; i < n; i++) {
                f[i][j] = Math.max(f[i - 1][j - 1], f[i][j - 1]);
                if (i + 1 < n)
                    f[i][j] = Math.max(f[i][j], f[i + 1][j - 1]);
                f[i][j] += fs[i][j];
            }

        }
        return f[n - 1][n - 1] + f[n - 1][n - 2] + f[n - 2][n - 1];
    }

}


