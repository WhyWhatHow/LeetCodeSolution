package leetcode.algorithm.dfs;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3459 {

    public static void main(String[] args) {
        Solution_3459 sol = new Solution_3459();
        System.out.println(sol.lenOfVDiagonal((new int[][]{
//                {2, 2, 1, 2, 2}, {2, 0, 2, 2, 0}, {2, 0, 1, 1, 0}, {1, 0, 2, 2, 2}, {2, 0, 0, 2, 2}
                {2, 2, 2, 2, 2}, {2, 0, 2, 2, 0}, {2, 0, 1, 1, 0}, {1, 0, 2, 2, 2}, {2, 0, 0, 2, 2}
        })));

        System.out.println("==================");
    }

    int[] dir = new int[]{-1, -1, 1, 1, -1};


    /**
     * 有题意可以得到一个推论, 对于(i,j) 位置, 可以构成的最大且符合题意的长度即为其对角线长度.假设(0,0) , 那么最大值最大会是其对角线长度,即单一方向的长度.
     * 对于(i,j) 我们有,
     * - 先↖️, 在↗️, 最大值是 i+1,
     * - 先↗️, 在↘️, 最大值是 n-j;
     * - 先↘️, 在↙️ , 最大值是 m-i;
     * - 先↙️, 在↖️, 最大值是 j+1;
     */

    public int lenOfVDiagonal(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {

                    int[] maxs = new int[]{i + 1, n - j, m - i, j + 1};
                    for (int k = 0; k < 4; k++) {
                        if (res < maxs[k])
                            res = Math.max(dfs(i, j, k, 0, 2, grid) + 1, res);
                    }
                }
            }
        }
        return res;
    }


    //       final static HashMap<Long, Integer> map = new HashMap<>();
    HashMap<Integer, Integer> map = new HashMap<>(); // 超时.
//    int[][][] map;

    /**
     * hint : 我们要的字符串是 1,2,0,2,0,2,0 这个, 所以进入dfs的我们可以默认是1,因此我们的target的值只能是2,0.
     * <p>
     * <p>
     * 在上一个位置是(i,j), 下一个点是 (i+dir[k], j+dir[k+1]) 下一个节点其目标值应是target,  yes 表示是否可以转向, 的情况下,最大取值.
     * yes =0 , 那么可以改变方向 对应的下一个点的坐标是 (k+1)%4, yes =1, 标记不可以改变方向.
     * i,j <=500, 那么 对应key 就应该是 key = (i<<40)| (j<<30) | (k<<20)| (yes<<10)| tar
     */
    int dfs(int i, int j, int k, int yes, int target, int[][] grid) {

        i = i + dir[k]; // 当前节点的位置.
        j = j + dir[k + 1];

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != target)
            return 0;

        // 超时
//        long key = ((long) i << 40) | ((long) j << 30) | ((long)  k << 20) | ((long) yes << 10) | (long) target;
        int key = (i << 14) | (j << 4) | (k << 1) | yes;
        if (map.containsKey(key)) return map.get(key);

        int res = dfs(i, j, k, yes, 2 - target, grid);
        if (yes == 0) {
            res = Math.max(res, dfs(i, j, (k + 1) % 4, 1, 2 - target, grid));
        }

        map.put(key, res + 1); // +1 表示当前位置.
        return res + 1;
    }


}


