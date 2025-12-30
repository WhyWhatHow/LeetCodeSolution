package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_840 {

    public static void main(String[] args) {
        Solution_840 sol = new Solution_840();
        System.out.println("==================");
    }

    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m < 3 || n < 3) return 0;
        int cnt = 0;
        for (int i = 0; i <= m - 3; i++) {
            for (int j = 0; j <= n - 3; j++) {
                if (check(grid, i, j)) cnt++;


            }
        }
        return cnt;
    }

    private boolean check(int[][] g, int x, int y) {
        int endx = x + 2;
        int endy = y + 2;
        // check num, number should be different.
        boolean[] v = new boolean[10];
        v[0] = true;
        for (int i = x; i <= endx; i++) {
            for (int j = y; j <= endy; j++) {

                if (g[i][j] < 1 || g[i][j] > 9) return false;
                v[g[i][j]] = true;
            }
        }
        for (int i = 0; i < v.length; i++) {
            if (!v[i]) return false;
        }
        // 检查对角线
        if (g[x][y] + g[endx][endy] != g[x][endy] + g[endx][y]) {
            return false;
        }
        int tar = g[x][y] + g[x + 1][y + 1] + g[x + 2][y + 2];
        // check row
        for (int i = x; i <= endx; i++) {
            int t = 0;
            for (int j = y; j <= endy; j++) {
                t += g[i][j];
            }
            if (t != tar) return false;
        }
        // check col
        for (int i = y; i <= endy; i++) {
            int t = g[x][y] + g[x + 1][y] + g[x + 2][y];
            if (t != tar) return false;
        }
        return true;
    }

}


