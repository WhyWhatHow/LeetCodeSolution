package leetcode.algorithm.pq;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2042 {

    public static void main(String[] args) {
        Solution_2042 sol = new Solution_2042();
        System.out.println(sol.mostBooked(
//                2,
//new int[][]{{18,19},{3,12},{17,19},{2,13},{7,10}}
//                4,
//                new int[][]{{18, 19}, {3, 12}, {17, 19}, {2, 13}, {7, 10}}
//                3,
//                new int[][]{{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}}

                4,
                new int[][]{{48,49},{22,30},{13,31},{31,46},{37,46},{32,36},{25,36},{49,50},{24,34},{6,41}}

        ));
//        System.out.println(sol.mostBooked(
//                2,
//                new int[][]{{0, 10}, {1, 5}, {2, 7}, {3, 4}}
//        ));
        System.out.println("==================");
    }

    /**
     * pq: 将会议按照开始时间排序.
     *
     * @param n
     * @param meetings
     * @return
     */
    public int mostBooked(int n, int[][] meetings) {
        int[] cs = new int[n]; // 每一个meeting room 一共开始了多少个会议.
        int[] ends = new int[n]; // 每一个meeting room 的结束时间.

        // init pq
        var pq = new PriorityQueue<int[]>((a, b) -> { // { 是否以占用(0表示为占用,1表示在占用), room_id, endTime }
            if (a[0] != b[0]) return a[0] - b[0];
            else if (a[2] != b[2]) return a[2] - b[2];
            else return a[1] - b[1];
        });
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{0, i, 0});
        }

        // init meetingsPq
        var mpq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        for (int[] meeting : meetings) {
            mpq.add(meeting);
        }

        // calculate
        while (!mpq.isEmpty()) {
            int[] polled = mpq.poll();
            int st = polled[0], end = polled[1];

            // 将[st,end) < st ,置空
            var q = new ArrayList<Integer>();
            while (!pq.isEmpty() && pq.peek()[2] <= st) {
                int[] ints = pq.poll();
                q.add(ints[1]);
            }
            for (Integer i : q) {
                pq.add(new int[]{0, i, 0});
            }

            int[] a = pq.poll();
            int rid = a[1], curTime = a[2];
            int time = st > curTime ? end : curTime + end - st;
            cs[rid]++;
            pq.add(new int[]{1, rid, time});
        }

        int max = -1;
        int res = -1;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] > max) {
                max = cs[i];
                res = i;
            }
        }
        return res;

    }

}


