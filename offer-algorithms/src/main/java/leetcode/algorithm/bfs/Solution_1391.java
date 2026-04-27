package leetcode.algorithm.bfs;

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
//                new int[][]{{1, 1, 2}}
//                new int[][]{{1,2,1},{1,2,1}}
                new int[][]{{2, 4, 3}, {6, 5, 2}}
        ));
        System.out.println("==================");
    }

    // set int[] dirs up , right, left ,down , 0,1,2,3, if dirs[i] ==1 , means it can go i dir.
    public boolean hasValidPath(int[][] grid) {

        int[] dirs = new int[]{-1, 0, 1, 0, -1}; // up, right, down, left
        // 反方向 (dir+2)%4
        int[][] mm = new int[][]{
                {}, //up 0, down 2,right 1, left 3
                {1, 3},// right, left
                {0, 2},// up, down
                {3, 2}, // left , down
                {1, 2},// right, down
                {0, 3}, // top , left
                {0, 1}// top, right

        };

        int n = grid.length, m = grid[0].length;
        if (n == 1 && m == 1) return true;
        boolean res = false;
        boolean[][] v = new boolean[n][m];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        v[0][0] = true;

        while (!q.isEmpty()) {
            int[] curs = q.poll();
            int x = curs[0], y = curs[1];
            int to = grid[x][y];

            for (int i : mm[to]) {
                int dx = dirs[i] + x;
                int dy = dirs[i + 1] + y;

                if (dx < 0 || dx >= n || dy < 0 || dy >= m) continue;
                if (v[dx][dy]) continue;

                // check 反方向.
                boolean yes = canReach(i, mm, grid[dx][dy]);

                if (!yes) continue;

                if (dx == n - 1 && dy == m - 1) {
                    return true;
                }
                v[dx][dy] = true;
                q.add(new int[]{dx, dy});
            }
        }

        return false;

    }


    /**
     * 判断 (dx,dy) 是否可以接受上一个点.
     * @param i  : curDir, 上一个路口的方向.
     * @param mm
     * @return
     */
    private static boolean canReach(int i, int[][] mm, int t) {
        // i的反方向.
        int tar = (i + 2) % 4;
        // 判断grid[dx][dy] 是否可以接受 上一个路口的道路.
        boolean yes = false;
        for (int j : mm[t]) {
            if (j == tar) {
                yes = true;
                break;
            }
        }
        return yes;
    }

}
