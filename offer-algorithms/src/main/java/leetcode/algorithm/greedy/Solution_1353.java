package leetcode.algorithm.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1353 {

    public static void main(String[] args) {
        Solution_1353 sol = new Solution_1353();
        System.out.println(sol.maxEvents(new int[][]{
//                {1, 3}, {1, 3}, {1, 3}, {3, 4}
                {1, 2}, {1, 2}, {2, 3}, {3, 4}
        }));
        System.out.println("==================");
    }

    /**
     * 解题思路: 考虑在第i天,要如何参见会议, 统计所有在第I天的会议,排除掉已经过了时间的, 选择结束最早可以参加的会议.
     *
     * @param events
     * @return
     */
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> {
            return a[0] - b[0];
        });

        int n = events.length;
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // {}
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int d = 0;
        int i = 0;
        int res = 0;
        while (d++<= 1000_00) {
            while (i < n && events[i][0] <= d && events[i][1] >= d) {
                pq.add(events[i][1]);
                i++;
            }
            while (!pq.isEmpty() && pq.peek() < d) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
        }
        return res;
    }

}


