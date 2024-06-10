package leetcode.algorithm.weekly;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_100299 {

    public static void main(String[] args) {
        Solution_100299 sol = new Solution_100299();
        System.out.println(sol.satisfiesConditions(new int[][]{
                {1, 0, 2},
                {1, 0, 2}
        }));
        ;
        System.out.println("==================");
    }

    public boolean satisfiesConditions(int[][] grid) {
        boolean checked = true;
        // check down
        for (int i = 0; i < grid.length; i++) {
            if (i + 1 >= grid.length) break;
            for (int j = 0; j < grid[0].length; j++) {
                // check down
                if (grid[i][j] != grid[i + 1][j]) {
                    checked = false;
                    break;
                }
            }
            if (!checked) {
                break;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // check right
                if (j + 1 >= grid[0].length) break;
                if (grid[i][j] == grid[i][j + 1]) {
                    checked = false;
                    break;
                }
            }
            if (!checked) {
                break;
            }
        }

        return checked;
    }


}


