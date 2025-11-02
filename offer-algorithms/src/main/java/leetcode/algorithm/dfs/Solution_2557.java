package leetcode.algorithm.dfs;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2557 {

    public static void main(String[] args) {
        Solution_2557 sol = new Solution_2557();
        System.out.println(sol.countUnguarded(
                4, 6,
                new int[][]{
                        {0, 0}, {1, 1}, {2, 3}
                }, new int[][]{
                        {0, 1}, {2, 2}, {1, 4}
                }
        ));
        System.out.println("==================");
    }

    int[] d = new int[]{-1, 0, 1, 0, -1}; // left,up, right ,down

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] g = new int[m][n];
        // init walls
        for (int[] a : walls) {
            g[a[0]][a[1]] = 2; // wall
        }
        // init guards
        for (int[] a : guards) {
            g[a[0]][a[1]] = 2; // guard
        }

        for (int[] a : guards) {
            int x = a[0], y = a[1];
            for (int i = 1; i < d.length; i++) {
                int dx = x, dy = y;
                while (true) {
                    dx = dx + d[i - 1];
                    dy = dy + d[i];
                    if (dx < 0 || dx >= m || dy < 0 || dy >= n) break;
                    if (g[dx][dy] == 2) break;
                    g[dx][dy] = 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 0) res++;
            }
        }
        return res;

    }
}


