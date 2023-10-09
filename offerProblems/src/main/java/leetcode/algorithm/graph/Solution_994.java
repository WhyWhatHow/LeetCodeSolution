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
                {0, 2, 1}
        }));
    }

    int cnt = 0;

    public int orangesRotting(int[][] grid) {
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


