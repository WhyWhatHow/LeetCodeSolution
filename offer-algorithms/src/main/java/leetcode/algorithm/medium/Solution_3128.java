package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3128 {

    public static void main(String[] args) {
        Solution_3128 sol = new Solution_3128();
        System.out.println(sol.numberOfRightTriangles(new int[][]{
                {1,1},
                {1,0},
                {0,1}
        }));
        System.out.println("==================");
    }

    public long numberOfRightTriangles(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] rows = new int[n];
        int[] cols = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) rows[i]++;
            }
        }
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (grid[i][j] == 1) cols[j]++;
            }
        }

        long res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && rows[i] > 1 && cols[j] > 1) {
                    res += (rows[i]-1) * (cols[j]-1);
                }
            }
        }

        return res;
    }

}


