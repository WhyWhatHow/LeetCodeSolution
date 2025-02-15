package leetcode.algorithm.dfs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1706 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(3);
        Solution_1706 sol = new Solution_1706();
        System.out.println(sol.findBall(new int[][]{
//                {1}

//                {1, 1, 1, -1, -1},
//                {1, 1, 1, -1, -1},
//                {-1, -1, -1, 1, 1},
//                {1, 1, 1, 1, -1},
//                {-1, -1, -1, -1, -1}
                //////////////////////////////
//                {-1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 1, 1, -1, -1, -1, 1, 1, 1, -1, -1, 1, 1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, 1, -1, 1, -1, -1, 1, 1, -1, 1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, -1, 1, 1, 1, -1, -1, -1, 1, -1, 1, -1, -1, 1, 1, -1, -1, 1, -1, 1, -1, 1, 1, 1, -1, -1, -1, -1}
                //////////////////////////////
                {1, 1, 1, 1, 1, 1},
                {-1, -1, -1, -1, -1, -1},
                {1, 1, 1, 1, 1, 1},
                {-1, -1, -1, -1, -1, -1}
        }));
        System.out.println("==================");
    }


    public int[] findBall(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1)
            return new int[]{-1};
        int[] ans = new int[grid[0].length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < grid[0].length; i++) {
            dfs(grid, ans, 0, i, i);
        }
        return ans;
    }

    private void dfs(int[][] grid, int[] ans, int x, int y, int i) {

        int m = grid.length;
        int n = grid[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n) return;


        if (ans[i] != -1) return;
        if (grid[x][y] == 1) { // check right
            if (y + 1 < n && grid[x][y + 1] == -1) return; // 死角, gg
            if (y + 1 < n && grid[x][y + 1] == 1) dfs(grid, ans, x + 1, y + 1, i);
        } else { // check left
            if (y - 1 >= 0 && grid[x][y - 1] == 1) return;
            if (y - 1 >= 0 && grid[x][y - 1] == -1) dfs(grid, ans, x + 1, y - 1, i);
        }
        if (x == m - 1) {
            if (grid[x][y] == -1)
                ans[i] = y - 1 >=0 ? y - 1 : -1;
            else ans[i] = y + 1 < n ? y + 1 : -1;
        }
    }

}
