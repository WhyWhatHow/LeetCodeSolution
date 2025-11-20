package leetcode.algorithm.greedy;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_757 {

    public static void main(String[] args) {
        Solution_757 sol = new Solution_757();
        System.out.println(sol.intersectionSizeTwo(new int[][]
//                {{1, 3}, {3, 7}, {8, 9}}
//                [[1,3],[1,4],[2,5],[3,5]]
//                        {{1, 3}, {1, 4}, {2, 5}, {3, 5}}
                        {{2, 10}, {3, 7}, {3, 15}, {4, 11}, {6, 12}, {6, 16}, {7, 8}, {7, 11}, {7, 15}, {11, 12}}
        ));
        ;
        System.out.println("==================");
    }

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            else return b[0] - a[0];
        });
        int st = -1;
        int end = -1;
        int res = 0;
        for (int i = 0; i < intervals.length; i++) {
            int a = intervals[i][0], b = intervals[i][1];
            if (end < a) {
                res += 2;
                end = b;
                st = b - 1;
            } else if (end <= b && end >= a) {
                if (st <= b && st >= a) {
                    continue;
                } else {
                    res++;
                    st = end ;
                    end = b;
                }
            }
        }
        return res;
    }

}


