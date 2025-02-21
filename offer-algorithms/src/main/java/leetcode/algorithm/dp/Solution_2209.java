package leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2209 {

    public static void main(String[] args) {
        Solution_2209 sol = new Solution_2209();
        System.out.println(sol.minimumWhiteTiles(
                "11111"
//                "10110101"
//                "1110111"
                ,
                2, 3
//                2, 2
//                2, 1
        ));
        System.out.println("==================");
    }

    // f[i][j] means [0,i] of floor, has j carpets  min number of white.
    int[][] f;
    int max = 10001;

    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int n = floor.length();

        f = new int[n][numCarpets + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], -1);
        }

        char[] cs = floor.toCharArray();

        dfs(cs, n - 1, numCarpets, carpetLen);
        return f[n - 1][numCarpets];
    }

    /**
     * f[i][j] = f[i-1][j]
     * j>0:
     * use : f[i][j] = dfs(i-len, j-1) ;
     * not use:  f[i][j] = dfs(i-1, j)+ cs[i]-'0';
     * j==0 :
     * f[i][j] = dfs(i-1, j) +cs[i]-'0' ;
     *
     * @param cs
     * @param i  [0,i]
     * @param j  j number of carpet.
     * @return
     */
    private int dfs(char[] cs, int i, int j, int len) {
        if (i < 0) return 0; // if i<0 , means no floor, so it should return 0.
        if (i < len * j) { // len*j means all carpet can cover floor number , if len*j >i ,means all of can be covered, so don't need to use it .
            return f[i][j] = 0;
        }

        if (f[i][j] != -1) return f[i][j];
        int res;
        if (j > 0) {
            // black not use.
            int unUse = dfs(cs, i - 1, j, len) + cs[i] - '0';

            int use = dfs(cs, i - len, j - 1, len);
            res = Math.min(unUse, use);
        } else {
            res = f[i][0] + cs[i] - '0';
        }
        f[i][j] = res;

        return res;
    }

}
