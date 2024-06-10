package leetcode.algorithm.graph;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_463 {

    public static void main(String[] args) {
        Solution_463 sol = new Solution_463();
        System.out.println("==================");
        System.out.println(sol.islandPerimeter(new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        }));
    }

    int res = 0;

    public int islandPerimeter(int[][] grid) {

        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, vis);
                }
            }
        }
//        dfs(grid,)
        return res;
    }

    int[] xx = new int[]{0, 1, 0, -1};
    int[] yy = new int[]{1, 0, -1, 0};

    private void dfs(int[][] grid, int i, int j, boolean[][] vis) {
        int rows = grid.length;
        int cols = grid[0].length;
        // 越界
        if (i < 0 || j < 0 || i >= rows || j >= cols) {
            res++;
            return;
        }
        // 水
        if (grid[i][j] == 0) {
            res++;
            return;
        }

        if (vis[i][j]) return;

        vis[i][j] = true;

        for (int ii = 0; ii < xx.length; ii++) {
            dfs(grid, i + xx[ii], j + yy[ii], vis);
        }

    }
}


