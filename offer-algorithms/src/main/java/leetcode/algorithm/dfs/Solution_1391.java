package leetcode.algorithm.dfs;

import java.util.ArrayDeque;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1391 {

    public static void main(String[] args) {
        Solution_1391 sol = new Solution_1391();//
        System.out.println(sol.hasValidPath(
                new int[][]{{1, 1, 2}}
        ));
        System.out.println("==================");
    }

    // set int[] dirs up , right, left ,down , 0,1,2,3, if dirs[i] ==1 , means it can go i dir.
    public boolean hasValidPath(int[][] grid) {
        //
        int[][] mm = new int[][]{
                {},
                {0, 1, 0, 1}, // up, right, down, left
                {1, 0, 1, 0},
                {0, 0, 1, 1},
                {0, 1, 1, 0},
                {1, 0, 0, 1},
                {1, 1, 0, 0}
        };

        int n = grid.length, m = grid[0].length;
        if (n == 1 && m == 1) return true;
        boolean res = false;
        boolean[][] v = new boolean[n][m];
        ArrayDeque<int[]> q = new ArrayDeque<int[]>();
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] curs = q.poll();
            int x = curs[0], y = curs[1];
            v[x][y] = true;
            int dir = grid[x][y];
            for (int i = 0; i < mm[dir].length; i++) {
                int dx = x, dy = y;
                if (mm[dir][i] == 1) {
                    if (i == 0) { // up
                        dx--;
                    } else if (i == 1) { //right
                        dy++;
                    } else if (i == 2) { // down
                        dx++;
                    } else {
                        dy--;
                    }

                    if (dx < 0 || dx >= n || dy < 0 || dy >= m) continue;
                    if (v[dx][dy]) continue;

                    // check canReach
                    if (!canReach(grid[dx][dy], i, mm)) continue;

                    if (dx == n - 1 && dy == m - 1) {
                        return true;
                    }
                    q.add(new int[]{dx, dy});
                }
            }
        }
        return false;

    }

    private boolean canReach(int i, int dir, int[][] mm) {
        if ((dir == 0 && mm[i][2] == 1) || // up and down
                (dir == 2 && mm[i][0] == 1) ||
                // left and right
                (dir == 1 && mm[i][3] == 1) || (dir == 3 && mm[i][1] == 1)
        ) {
            return true;
        }
        return false;
    }


}
