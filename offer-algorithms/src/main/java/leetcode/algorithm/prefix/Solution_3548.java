package leetcode.algorithm.prefix;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3548 {

    public static void main(String[] args) {
        Solution_3548 sol = new Solution_3548();//
//        System.out.println(Integer.MAX_VALUE > 1000_000_0000l);
        System.out.println(sol.canPartitionGrid(
//                new int[][]{{1, 2}, {3, 4}}
//                new int[][]{{4, 1, 8}, {3, 2, 6}}
//                new int[][]{{1, 2, 4}, {2, 3, 5}}
                new int[][]{{100000, 90234, 100000, 100000, 100000}}

        ));
        System.out.println("==================");
    }


    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long all = 0;

        // check rows
        var topMap = new HashMap<Integer, Integer>();
        var botMap = new HashMap<Integer, Integer>();
        for (int[] a : grid) {
            for (int i : a) {
                all += i;
                botMap.merge(i, 1, Integer::sum);
            }
        }
        long tsum = 0;
        for (int i = 0; i < n - 1; i++) {
            // init topMap
            for (int j = 0; j < m; j++) {
                tsum += grid[i][j];
                topMap.merge(grid[i][j], 1, Integer::sum);
                if (botMap.merge(grid[i][j], -1, Integer::sum) == 0) botMap.remove(grid[i][j]);
            }

            var bsum = all - tsum;
            if (bsum == tsum) return true;
//            int diff = (int) (tsum - bsum); // 数据溢出问题
            var diff = tsum - bsum;
            if (diff > 0 && diff <= 1000_00) {
                if (check(topMap, (int) diff, 0, i, 0, m - 1, grid)) return true;
            }
            if (diff < 0 && diff >= -1000_00) {
                if (check(botMap, (int) -diff, i + 1, n - 1, 0, m - 1, grid)) return true;
            }

        }

        /// check cols

        HashMap<Integer, Integer> leftMap = new HashMap<>(), rightMap = new HashMap<>();
        for (int[] row : grid)
            for (int v : row) rightMap.merge(v, 1, Integer::sum);


        long lsum = 0;
        for (int j = 0; j < m - 1; j++) {
            for (int i = 0; i < n; i++) {
                lsum += grid[i][j];
                leftMap.merge(grid[i][j], 1, Integer::sum);
                if (rightMap.merge(grid[i][j], -1, Integer::sum) == 0) rightMap.remove(grid[i][j]);
            }
            long rsum = all - lsum;
            if (lsum == rsum) return true;
            var diff = (lsum - rsum);
            if (diff > 0 && diff <= 1000_00) {
                if (check(leftMap, (int) diff, 0, n - 1, 0, j, grid)) return true;
            }
            if (diff < 0 && diff >= -1000_00) {
                if (check(rightMap, (int) -diff, 0, n - 1, j + 1, m - 1, grid)) return true;
            }
        }
        return false;
    }

    /**
     * 判断[ r, rr] , [c,cc] 矩阵中是否有值=diff 且可以去掉的情况.
     */
    private boolean check(HashMap<Integer, Integer> map,
                          int diff, int r, int rr, int c, int cc, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (!map.containsKey(diff)) return false;

        int dr = rr - r + 1, dc = cc - c + 1;
        if (dr >= 2 && dc >= 2) return true;// 存在两行或者两列, 那么可以删除任意个点的数据.

        // only one row or cols
        if (dr == 1) { //  一行的情况.
            // top-> bottom
            return grid[r][c] == diff || grid[r][cc] == diff;
        }
        // 只有一列
        // left -> right
        return grid[r][c] == diff || grid[rr][c] == diff;
    }

}
