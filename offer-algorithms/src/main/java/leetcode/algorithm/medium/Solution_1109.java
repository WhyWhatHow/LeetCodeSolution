package leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #差分 #medium
 * @author: WhyWhatHow
 **/

public class Solution_1109 {

    public static void main(String[] args) {
        Solution_1109 sol = new Solution_1109();
        System.out.println("==================");
    }


    // 差分数组
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n+1];
        for (int[] booking : bookings) {
            res[booking[0] - 1] += booking[2];
            res[booking[1]] -= booking[2];
        }
        for (int i = 1; i < res.length; i++) {
            res[i] += res[i - 1];
        }
        return Arrays.copyOf(res,n);

    }

}


