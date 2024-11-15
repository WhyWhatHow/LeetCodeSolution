package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3239 {

    public static void main(String[] args) {
        Solution_3239 sol = new Solution_3239();
        System.out.println("==================");
    }

    public int minFlips(int[][] grid) {
        int res = Integer.MAX_VALUE;
        int n = grid.length;
        int m = grid[0].length;

        int l, r;
        int cnt = 0;
        // row count
        for (int i = 0; i < n; i++) {
            l = 0;
            r = m - 1;
            while (l < r) {
                if (grid[i][l] != grid[i][r]) cnt++;
                l++;
                r--;
            }
        }
        res = Math.min(res, cnt);
        cnt = 0;

        for (int i = 0; i < m; i++) {
            l = 0;
            r = n - 1;
            while (l < r) {
                if (grid[l][i] != grid[r][i]) cnt++;
                l++;
                r--;
            }
        }
        res = Math.min(res, cnt);
        return res;
    }

}


