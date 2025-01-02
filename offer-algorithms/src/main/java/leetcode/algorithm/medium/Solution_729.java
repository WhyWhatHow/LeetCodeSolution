package leetcode.algorithm.medium;

import java.util.TreeSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_729 {

    public static void main(String[] args) {
        Solution_729 sol = new Solution_729();
        MyCalendar c = new MyCalendar();
        int[][] booking = new int[][]{
                {47, 50},
                {33, 41},
                {39, 45},
                {33, 42},
                {25, 32},
                {26, 35},
                {19, 25},
                {3, 8},
                {8, 13},
                {18, 27}
        };
        for (int[] ints : booking) {
            System.out.println(c.book(ints[0],ints[1]));;
        }
        System.out.println("==================");
    }


}


class MyCalendar {
    TreeSet<int[]> set = new TreeSet<>((a, b) -> {
        if (a[0] != b[0]) return a[0] - b[0];
        else return a[1] - b[1];
    });

    public MyCalendar() {
    }

    public boolean book(int startTime, int endTime) {
        int[] a = new int[]{startTime, endTime};
        if (set.isEmpty()) {
            return set.add(a);
        }
        int[] floor = set.floor(a);
        int[] ceiling = set.ceiling(a);
        if (floor != null &&startTime < floor[1] || ceiling!=null && endTime > ceiling[0]) return false;
        return set.add(a);

    }
}
