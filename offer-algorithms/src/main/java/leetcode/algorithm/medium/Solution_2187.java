package leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2187 {

    public static void main(String[] args) {
        Solution_2187 sol = new Solution_2187();
        System.out.println(sol.minimumTime(new int[]{
//                        1, 2, 3, 5
//                        5, 10, 10
//                        10000
                        69318,51095
                },
                42888
//                10000000
//                9
//                15
        ));
        System.out.println("==================");

    }


    /**
     * x time used , sum(trips) <= totalTrips
     *
     * @param time
     * @param totalTrips
     * @return
     */
    public long minimumTime(int[] time, int totalTrips) {
        if (time.length == 1) return (long) time[0] * totalTrips;
        Arrays.sort(time);
        long r = (long)time[0] * totalTrips;
        long l = 0;
        long mid = 0;
        long res = r;
        while (l <= r) { //[l,r]
            mid = l + (r - l) / 2;
            long midVal = getTotalTrips(time, mid);
            if (midVal < totalTrips) {
                l = mid + 1;
            } else {
                res = mid;
                r = mid - 1;
            }
        }
        return res;

    }

    private long getTotalTrips(int[] time, long n) {
        long res = 0;
        for (int i : time) {
            res += n / i;
        }
        return res;
    }
}


