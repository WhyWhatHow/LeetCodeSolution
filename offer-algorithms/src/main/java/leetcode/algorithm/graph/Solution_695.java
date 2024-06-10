package leetcode.algorithm.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_695 {

    public static void main(String[] args) {
        Solution_695 sol = new Solution_695();
        System.out.println("==================");
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    vis[i][j] = true;
                    max = Math.max(max, bfs(grid, i, j, vis));
                }
            }
        }
        return max;
    }

    int[] xx = new int[]{0, 1, 0, -1};
    int[] yy = new int[]{1, 0, -1, 0};

    private int bfs(int[][] grid, int i, int j, boolean[][] vis) {
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            res++;
            for (int ii = 0; ii < xx.length; ii++) {
                int px = xx[ii] + x;
                int py = yy[ii] + y;
                if (px >= 0 && px < rows && py >= 0 && py < cols && grid[px][py] == 1 && !vis[px][py]) {
                    q.add(new int[]{px, py});
                    vis[px][py] = true;
                }
            }
        }
        return res;
    }
}


