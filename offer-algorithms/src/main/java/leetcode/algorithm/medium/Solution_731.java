package leetcode.algorithm.medium;

import java.util.TreeMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_731 {

    public static void main(String[] args) {
//        Solution_731 sol = new Solution_731();
        MyCalendarTwo cl = new MyCalendarTwo();
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
//                {10, 20},
//                {50, 60},
//                {10, 40},
//                {5, 15},
//                {5, 10},
//                {25, 55}
                //////////////////////////
                {24, 40},
                {43, 50},
                {27, 43},
                {5, 21},
                {30, 40},
                {14, 29},
                {3, 19},
                {3, 14},
                {25, 39},
                {6, 19}
        };
        for (int[] ints : arr) {
            System.out.println(cl.book(ints[0], ints[1]));
        }
        System.out.println("==================");
    }


}

class MyCalendarTwo {

    TreeMap<Integer, Integer> map = new TreeMap<>();

    public MyCalendarTwo() {
    }

    /**
     * 差分思路: startTime时刻 +1,  endTime 时刻-1, cnt[start]=+1 , cnt[end]= -1,
     * 用sum 统计最高的booking 数量.
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public boolean book(int startTime, int endTime) {
        System.out.print(startTime + " : " + endTime + " : ");
        map.compute(startTime, (k, v) -> v == null ? 1 : v + 1);
        map.compute(endTime, (k, v) -> v == null ? -1 : v - 1);
        int sum = 0;
        for (Integer i : map.keySet()) {
            sum += map.get(i);
            if (sum > 2) {
                map.compute(startTime, (k, v) -> v - 1);
                map.compute(endTime, (k, v) -> v + 1);
                return false;
            }
        }
        return true;
    }
}

