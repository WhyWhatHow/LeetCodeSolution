package leetcode.algorithm.hard;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3197 {

    public static void main(String[] args) {
        Solution_3197 sol = new Solution_3197();

        System.out.println("==================");
    }

    /**
     * 考虑把grid 切成三个部分,分别枚举在三个部分中,
     * 大值会有6种切法, 枚举每一种切法, 求最小值就好.
     *
     * @param grid
     * @return
     */
    public int minimumSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = n * m;
        // 横着切两刀.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int area = getMinArea(grid, 0, i, 0, m - 1);
                area += getMinArea(grid, i + 1, j, 0, m - 1);
                area += getMinArea(grid, j + 1, n - 1, 0, m - 1);
                res = Math.min(res, area);
            }
        }

        // 第二种切法, 1.横着一刀, 2.竖着一刀.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int area = getMinArea(grid, 0, i, 0, m - 1);

                area += getMinArea(grid, i, n - 1, 0, j);
                area += getMinArea(grid, i, n - 1, j + 1, m - 1);
                res = Math.min(res, area);
            }
        }
        // 第三种切法.  先竖起切,在横切.
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < m; j++) {
                int area = getMinArea(grid, i, n - 1, 0, m - 1);
                area += getMinArea(grid, 0, i - 1, 0, j);
                area += getMinArea(grid, 0, i - 1, j + 1, m - 1);
                res = Math.min(res, area);
            }
        }
        // 第四种, | |
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {

                int area = getMinArea(grid, 0, n - 1, 0, i);
                area += getMinArea(grid, 0, n - 1, i + 1, j);
                area += getMinArea(grid, 0, n - 1, j + 1, m - 1);
                res = Math.min(area, res);
            }
        }
        // 第五种, |-
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int area = getMinArea(grid, 0, n - 1, 0, i);
                area += getMinArea(grid, 0, j, i + 1, m - 1);
                area += getMinArea(grid, j + 1, n - 1, i + 1, m - 1);
                res = Math.min(res, area);
            }
        }
        // 6: -|
        for (int i = m - 1; i > 0; i--) {
            for (int j = 0; j < n; j++) {
                int area = getMinArea(grid, 0, n - 1, i, m - 1);
                area += getMinArea(grid, 0, j, 0, i - 1);
                area += getMinArea(grid, j + 1, n - 1, 0, i - 1);
                res = Math.min(res, area);
            }
        }

        return res;
    }

    /**
     * g[i][j] i belong to [startx,endx], j belong [starty, endy] range minArea.
     */
    int getMinArea(int[][] g, int startx, int endx, int starty, int endy) {
//        if (endx < startx) endx = startx;
//        if (endy < startx) endy = starty;
        int sx = endx, sy = endy, ex = -1, ey = -1;
        for (int i = startx; i <= endx; i++) {
            for (int j = starty; j <= endy; j++) {
                if (g[i][j] == 1) {
                    sx = Math.min(sx, i);
                    sy = Math.min(sy, j);
                    ex = Math.max(i, ex);
                    ey = Math.max(ey, j);
                }
            }
        }
        return (ex - sx + 1) * (ey - sy + 1);
    }
}


