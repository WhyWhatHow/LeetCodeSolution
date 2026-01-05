package leetcode.algorithm.greedy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1975 {

    public static void main(String[] args) {
        Solution_1975 sol = new Solution_1975();
        System.out.println(sol.maxMatrixSum(
//
//                new int[][]{{1, 2, 3}, {-1, -2, -3}, {1, 2, 3}}
//                new int[][]{{-10000, -10000, -10000}, {-10000, -10000, -10000}, {-10000, -10000, -10000}}
                new int[][]{{10, -6, -6, -8}, {-3, -7, -8, -9}, {-4, -8, -5, -8}, {-9, -9, -6, -8}}
        ));
        System.out.println("==================");
    }

    /**
     * 如果matrix 有偶数个 负数,那么 这偶数个负数一定转换成正数.
     * 如果有有奇数个负数, 那么一定会留下一个负数 , 最好的options 把这个负数换成最小的正数.
     *
     * @param matrix
     * @return
     */
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        long res = 0;
        int cnt = 0;
        int cntZero = 0;
        int min = 1000_01;
        int max = -1000_01;
        for (int[] ints : matrix) {
            for (int i : ints) {
                if (i < 0) {
                    cnt++;
                    max = Math.max(max, i);
                } else if (i == 0) cntZero++;
                else {
                    min = Math.min(min, i);
                }
                res += Math.abs(i);
            }
        }

        if ((cnt & 1) == 0 || cntZero > 0) {
            return res;
        } else {
            if (Math.abs(max) < min) {
                return res + 2 * max;
            } else {
                return res - 2 * min;
            }
        }

    }

}


