package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1895 {

    public static void main(String[] args) {
        Solution_1895 sol = new Solution_1895();
        System.out.println(sol.largestMagicSquare(
                new int[][]{{5, 1, 3, 1}, {9, 3, 3, 1}, {1, 3, 3, 8}}
        ));
        System.out.println("==================");
    }


    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxk = Math.min(n, m);
        int res = 1;


        for (int k = 2; k <= maxk; k++) {
            boolean yes = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (getMax(i, j, k, grid) > 0) {
                        yes = true;
                        break;
                    }
                }
                if (yes) break;
            }
            if (yes) {
                res = k;
            }
        }
        return res;

    }

    private int getMax(int x, int y, int k, int[][] grid) {
        int ex = x + k;
        int ey = y + k;
        int n = grid.length;
        int m = grid[0].length;

        if (ex > n || ey >m) return 0;

        // 获取目标和
        int tar = 0;

        // check row
        for (int i = x; i < ex; i++) {
            int sum = 0;
            for (int j = y; j < ey; j++) {
                sum += grid[i][j];
            }
            if (tar == 0) {
                tar = sum;
            } else if (tar != sum) {
                return 0;
            }
        }
        // check col
        for (int i = y; i < ey; i++) {
            int sum = 0;
            for (int j = x; j < ex; j++) {
                sum += grid[j][i];
            }
            if (sum != tar) return 0;
        }


        //check 对角线.
        // x+1, y+1 ,
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += grid[x + i][y + i];
        }
        if (sum != tar) return 0;

        // x+1, y-1
        sum = 0;
        for (int i = 0; i < k; i++) {
            sum += grid[x + i][ey - i - 1];
        }

        if (sum != tar) return 0;
        return tar;
    }

}


