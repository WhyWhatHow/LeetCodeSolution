package leetcode.algorithm.medium;

import java.util.BitSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2711 {

    public static void main(String[] args) {
        Solution_2711 sol = new Solution_2711();
        BitSet set = new BitSet();
        set.set(2);
        System.out.println(set.size());

        System.out.println(set.get(0));
        System.out.println(set.get(2));
        System.out.println(set.stream().count());
        System.out.println(sol.differenceOfDistinctValues(new int[][]{
                {1, 2, 3},
                {3, 1, 5},
                {3, 2, 1}
        }));
        ;
        System.out.println("==================");
    }


    public int[][] differenceOfDistinctValues(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        NPair[][] ans = new NPair[n][m];
        // init
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = new NPair();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                doHandle(i, j, ans, grid);
            }
        }
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = (int) Math.abs(ans[i][j].lt.stream().count() - ans[i][j].rb.stream().count());
            }
        }
        return res;

    }

    private void doHandle(int i, int j, NPair[][] ans, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int x = i + 1, y = j + 1;
        while (x < n && y < m) {
            ans[i][j].rb.set(grid[x][y]);
            ans[x][y].lt.set(grid[i][j]);

            x++;
            y++;
        }
    }


    class NPair {
        BitSet lt = new BitSet();
        BitSet rb = new BitSet();
    }
}


