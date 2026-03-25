package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3546 {

    public static void main(String[] args) {
        Solution_3546 sol = new Solution_3546();//
        System.out.println(sol.canPartitionGrid(
                new int[][]{{54756, 54756}}
        ));
        System.out.println("==================");
    }

    public boolean canPartitionGrid(int[][] grid) {
        long all = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[] cs = new int[m];
        int[] rs = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rs[i] += grid[i][j];
                cs[j] += grid[i][j];
                all += grid[i][j];
            }
        }
        //  rows split
        long tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp += rs[i];
            if (all - tmp == tmp) {
                return true;
            }
        }
        // cols spl
        tmp = 0;
        for (int i = 0; i < m; i++) {
            tmp += cs[i];
            if (tmp == all - tmp) return true;
        }
        return false;
    }

}
