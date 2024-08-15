package leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3148 {

    public static void main(String[] args) {
        Solution_3148 sol = new Solution_3148();
        List<List<Integer>> grid = new ArrayList<>();

        List<Integer> row1 = new ArrayList<>(Arrays.asList(9, 5, 7, 3));
        List<Integer> row2 = new ArrayList<>(Arrays.asList(8, 9, 6, 1));
        List<Integer> row3 = new ArrayList<>(Arrays.asList(6, 7, 14, 3));
        List<Integer> row4 = new ArrayList<>(Arrays.asList(
                2, 5, 3, 1
        ));

        grid.add(row1);
        grid.add(row2);
        grid.add(row3);
        grid.add(row4);

        sol.maxScore(grid);
        System.out.println("==================");
    }


    /**
     * dp[i][j] means [0:i] ,[0:j] ,最小值.
     * //     * dp[i][j] = min(dp[i-1][j], dp[i][j-1], g[i][j]) // wa , at least jump once, so no g[i][j]
     *
     * @param grid
     * @return
     */
    public int maxScore(List<List<Integer>> grid) {

        int m = grid.size();
        int n = grid.getFirst().size();
        int[][] dp = new int[m + 1][n + 1];

        Arrays.fill(dp[0], Integer.MAX_VALUE);

        // init dp[i][0]
        for (int i = 1; i <=m; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        // get dp

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur = grid.get(i).get(j);
                int min = Math.min(dp[i + 1][j], dp[i][j + 1]);
                res = Math.max(res, cur - min);
                dp[i + 1][j + 1] = Math.min(min, cur);
            }
        }
        return res;

    }
}


