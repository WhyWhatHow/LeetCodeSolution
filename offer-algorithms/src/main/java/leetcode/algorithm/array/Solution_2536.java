package leetcode.algorithm.array;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2536 {

    public static void main(String[] args) {
        Solution_2536 sol = new Solution_2536();
        System.out.println("==================");
    }

    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] g = new int[n][n];
        for (int[] q : queries) {
            int r = q[0], c = q[1], rr = q[2], cc = q[3];

            for (int i = r; i <= rr; i++) {
                for (int j = c; j <= cc; j++)
                    g[i][j]++;
            }

        }
        return g;
    }

}


