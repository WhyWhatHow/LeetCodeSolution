package leetcode.algorithm.pq;

import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2931 {

    public static void main(String[] args) {
        Solution_2931 sol = new Solution_2931();
        System.out.println("==================");
    }

    /**
     * 维护一个 pq, 每一次弹出最小值,然后在他的队列中添加一个元素.
     *
     * @param values
     * @return
     */
    public long maxSpending(int[][] values) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> { // a[] {val, x, y}
            return a[0] - b[0];
        });
        int n = values[0].length;
        for (int i = 0; i < values.length; i++) {
            pq.add(new int[]{values[i][n - 1], i, n - 1});
        }

        long res = 0;
        int cnt = 1;
        while (!pq.isEmpty()) {
            int[] polled = pq.poll();
            int val = polled[0], x = polled[1], y = polled[2] - 1;
            res += (long)val * cnt;
            cnt++;
            if (y >= 0) {
                pq.add(new int[]{values[x][y], x, y});
            }
        }
        return res ;
    }

}


