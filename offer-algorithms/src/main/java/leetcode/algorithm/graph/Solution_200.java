package leetcode.algorithm.graph;

import java.util.LinkedList;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_200 {

    public static void main(String[] args) {
        Solution_200 sol = new Solution_200();
        System.out.println("==================");
        System.out.println(sol.numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));
    }

    public int numIslands(char[][] grid) {
        int res = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    res++;
                    bfs(grid, i, j, vis);
//                    dfs(grid, i, j, vis);
                }
            }
        }
        return res;
    }

    int[] xx = new int[]{0, 1, 0, -1};
    int[] yy = new int[]{1, 0, -1, 0};

    void dfs(char[][] grid, int x, int y, boolean[][] vis) {
        int w = grid.length;
        int h = grid[0].length;

        if (x < 0 || y < 0 || x > w - 1 || y > h - 1 || grid[x][y] == '0' || vis[x][y] == true) return;

        vis[x][y] = true;  // 避免重复标记,也可以用标记数组

        for (int i = 0; i < xx.length; i++) {
            dfs(grid, x + xx[i], y + yy[i], vis);
        }
    }

    void bfs(char[][] grid, int x, int y, boolean[][] vis) {
        int rows = grid.length;
        int cols = grid[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int ix = poll[0];
            int iy = poll[1];

            if (ix < 0 || iy < 0 || ix >= rows || iy >= cols || grid[ix][iy] == '0' || vis[ix][iy]) {
                continue;
            }

            vis[ix][iy] = true;

            for (int i = 0; i < xx.length; i++) {
                queue.add(new int[]{ix + xx[i], iy + yy[i]});
            }

        }
    }
}


