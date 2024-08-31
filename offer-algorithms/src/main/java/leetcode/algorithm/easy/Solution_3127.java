package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3127 {

    public static void main(String[] args) {
        Solution_3127 sol = new Solution_3127();
        System.out.println("==================");
    }

    public boolean canMakeSquare(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean yes = false;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check(i, j, grid)) return true;
            }
        }
        return yes;

    }

    private boolean check(int x, int y, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (y == m - 1 || x == n - 1) return false;
        int cntB = 0, cntW = 0;
        for (int i = x; i < x + 2; i++) {
            for (int j = y; j < y + 2; j++) {
                if (grid[i][j] == 'W') cntW++;
                if (grid[i][j] == 'B') cntB++;
            }
        }
        if (cntW >= 3 || cntB >= 3) return true;
        else return false;
    }

}


