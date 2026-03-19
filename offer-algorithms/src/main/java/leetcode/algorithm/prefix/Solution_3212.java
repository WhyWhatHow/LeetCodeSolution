package leetcode.algorithm.prefix;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3212 {

    public static void main(String[] args) {
        Solution_3212 sol = new Solution_3212();//
        System.out.println(sol.numberOfSubmatrices(new char[][]{{'X', 'Y', '.'}, {'Y', '.', '.'}}));
        System.out.println("==================");
    }

    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] f = new int[n][m][2]; // {x,y} (i,j) 组成的矩阵中 xy的数量.
        // init f
        f[0][0][0] = grid[0][0] == 'X' ? 1 : 0;
        f[0][0][1] = grid[0][0] == 'Y' ? 1 : 0;

        for (int i = 1; i < m; i++) {
            f[0][i][0] = grid[0][i] == 'X' ? f[0][i - 1][0] + 1 : f[0][i - 1][0];
            f[0][i][1] = grid[0][i] == 'Y' ? f[0][i - 1][1] + 1 : f[0][i - 1][1];
        }
        for (int i = 1; i < n; i++) {
            f[i][0][0] = grid[i][0] == 'X' ? f[i-1][0][0] + 1 : f[i-1][0][0];
            f[i][0][1] = grid[i][0] == 'Y' ? f[i-1][0][1] + 1 : f[i-1][0][1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // update x
                f[i][j][0] = grid[i][j] == 'X' ? 1 : 0;
                f[i][j][0] += f[i - 1][j][0] + f[i][j - 1][0] - f[i - 1][j - 1][0];
                // update y
                f[i][j][1] = grid[i][j] == 'Y' ? 1 : 0;
                f[i][j][1] += f[i - 1][j][1] + f[i][j - 1][1] - f[i - 1][j - 1][1];

            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (f[i][j][0] != 0 && f[i][j][0] == f[i][j][1])
                    res++;
            }
        }
        return res;

    }

}
