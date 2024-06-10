package leetcode.algorithm.graph;

import java.util.LinkedList;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_994 {

    public static void main(String[] args) {
        Solution_994 sol = new Solution_994();

        System.out.println("==================");
        System.out.println(sol.orangesRotting(new int[][]{
//                {2, 1, 2},
//                {0, 1, 1},
//                {1, 0, 1},
//                [[2,1,1],[1,1,0],[0,2,1]]
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        }));
    }

    // bfs
    public int orangesRotting(int[][] grid) {
        int cnt = 0;
        var q = new LinkedList<int[]>(); // int[] ==>grid[x][y],{x,y}
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] v = new boolean[n][m];
        // init
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    v[i][j] = true;
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    cnt++;
                }
            }
        }

        if (cnt == 0) return 0;

        // bfs
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] now = q.poll();
                for (int j = 0; j < d.length - 1; j++) {
                    int x = now[0] + d[j];
                    int y = now[1] + d[j + 1];

                    // border check
                    if (x < 0 || y < 0 || x >= n || y >= m) continue;

                    if (grid[x][y] == 1 && !v[x][y]) {
                        cnt--;
                        v[x][y] = true;
                        grid[x][y] = 2;
                        q.add(new int[]{x, y});
                    }
                }
            }
            res++;
            if (cnt == 0) break;
        }
        return cnt == 0 ? res : -1;
    }

    // x 0,1,0,-1
    // y 1,0,-1,0 (0,1)(1,0),(-1,0)
    int[] d = new int[]{0, 1, 0, -1, 0};

    int cnt = 0;

    public int orangesRottingOld(int[][] grid) {
        int res = 0;

        boolean[][] vis = new boolean[grid.length][grid[0].length];
        LinkedList<int[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    vis[i][j] = true;
                    q.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    cnt++;
                }
                if (grid[i][j] == 0) vis[i][j] = true;
            }
        }
        if (cnt == 0) return 0;
        res = bfs(q, grid);
        return res;

    }

    int[] dir = new int[]{1, 0, -1, 0, 1};

    private int bfs(LinkedList<int[]> q, int[][] grid) {
        LinkedList<int[]> qq = new LinkedList<>();
        int res = 0;
        while (!q.isEmpty() || !qq.isEmpty()) {
            if (!q.isEmpty()) {
                qq = visit(q, grid, qq);
                res++;
            }
            if (!qq.isEmpty()) {
                q = visit(qq, grid, q);
                res++;
            }
        }

        return cnt == 0 ? res - 1 : -1;
    }

    private LinkedList visit(LinkedList<int[]> q, int[][] grid, LinkedList<int[]> qq) {
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];


            for (int i = 0; i < dir.length - 1; i++) {
                int xx = dir[i] + x;
                int yy = dir[i + 1] + y;
                if (xx >= 0 && xx < grid.length && yy >= 0 && yy < grid[0].length) {
                    if (grid[xx][yy] == 1) {
                        qq.add(new int[]{xx, yy});
                        // update
                        grid[xx][yy] = 2;//
                        cnt--;
                    }
                }

            }
        }
        return qq;
    }

}


