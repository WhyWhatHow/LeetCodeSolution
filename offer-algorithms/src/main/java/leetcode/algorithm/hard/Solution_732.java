package leetcode.algorithm.hard;

import java.util.TreeMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_732 {

    public static void main(String[] args) {
        Solution_732 sol = new Solution_732();
        MyCalendarThree cl = new MyCalendarThree();
        int[][] arr = new int[][]{
//                {47, 50},
//                {33, 41},
//                {39, 45},
//                {33, 42},
//                {25, 32},
//                {26, 35},
//                {19, 25},
//                {3, 8},
//                {8, 13},
//                {18, 27}
///////////////////////////////////
                {10, 20},
                {50, 60},
                {10, 40},
                {5, 15},
                {5, 10},
                {25, 55}
                //////////////////////////
//                {24, 40},
//                {43, 50},
//                {27, 43},
//                {5, 21},
//                {30, 40},
//                {14, 29},
//                {3, 19},
//                {3, 14},
//                {25, 39},
//                {6, 19}
        };
        for (int[] ints : arr) {
            System.out.println(cl.book(ints[0], ints[1]));
        }
        System.out.println("==================");
    }


}

class MyCalendarThree {

    TreeMap<Integer, Integer> map = new TreeMap<>();

    public MyCalendarThree() {
    }

    public int book(int startTime, int endTime) {

        int ans = 0;
        map.compute(startTime, (k, v) -> v == null ? 1 : v + 1);
        map.compute(endTime, (k, v) -> v == null ? -1 : v - 1);

        int maxBooking = 0;
        for (Integer v : map.values()) {
            maxBooking += v;
            ans = Math.max(ans, maxBooking);
        }
        return ans;
    }
}


