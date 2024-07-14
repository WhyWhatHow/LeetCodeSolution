package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_807 {

    public static void main(String[] args) {
        Solution_807 sol = new Solution_807();
        System.out.println("==================");
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];

        // get max number of each row
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (max < grid[i][j])
                    max = grid[i][j];
            }
            rows[i] = max;
        }

        // get max number of each col
        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                if (max < grid[j][i])
                    max = grid[j][i];
            }
            cols[i] = max;
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                res += Math.min(rows[i], cols[j]) - grid[i][j];
            }
        }
        return res;
    }
}


