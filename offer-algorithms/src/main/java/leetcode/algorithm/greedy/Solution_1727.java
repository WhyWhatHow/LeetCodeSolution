package leetcode.algorithm.greedy;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1727 {

    public static void main(String[] args) {
        Solution_1727 sol = new Solution_1727();//

        System.out.println("==================");
    }

    // 思路: 依次枚举底边为i时, 统计矩形的高度.hs[i]
    // 有题目值, matrix 可以重拍列,所以可以将 hs sort后, 获得矩形的最大值.
    public int largestSubmatrix(int[][] matrix) {
        int[] hs = new int[matrix[0].length];
        for (int[] ints : matrix) {
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] == 1) hs[i]++;
                else hs[i] = 0;
            }
        }
        Arrays.sort(hs);
        int res = 0;
//        int min
//        hs[i] 升序, 然后也就是所, 对于i而言 它的右手边的值>=hs[i]
        for (int i = 0; i < hs.length; i++) {
            res = Math.max(res, hs[i] * (hs.length - i));
        }
        return res;
    }

}
