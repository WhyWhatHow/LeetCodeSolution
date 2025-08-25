package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_498 {

    public static void main(String[] args) {
        Solution_498 sol = new Solution_498();
        System.out.println(sol.findDiagonalOrder(new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        }));
        System.out.println("==================");
    }

    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] d = new int[]{-1, 1, -1};
        int cnt = 0;

        int[] as = new int[m * n];
        int x = 0, y = 0;
        boolean up = true;
        as[cnt++] = mat[x][y];

        while (cnt < m * n) {
            if (up) {
                x += d[0];
                y += d[1];
                if (x < 0 || y == m) {
                    x++;
                    up = false;

                }
            } else {
                x += d[1];
                y += d[2];
                if (y < 0 || x == n) {
                    y++;
                    up = true;
                }
            }
            if (x < 0 || x >= n || y < 0 || y >= m) continue;
            else as[cnt++] = mat[x][y];

        }
        return as;
    }

}


