package leetcode.algorithm.medium;

import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_871 {

    public static void main(String[] args) {
        Solution_871 sol = new Solution_871();
        System.out.println(sol.minRefuelStops(
//                100, 10,
                100, 25,
                new int[][]{
//                {10, 60}, {20, 30}, {30, 30}, {60, 40}
                        {25, 25}, {50, 25}, {75, 25}
                }));
        System.out.println("==================");
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {

//        int curFuel = startFuel;
        int cur = startFuel;
        int cnt = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int[] s : stations) {
            if (cur >= s[0]) { //  arrive gas station
//                curFuel -= s[0];
                pq.add(s[1]);
            } else { // not arrive s[0]
                while (!pq.isEmpty() && cur < target) {
                    int poll = pq.poll();
                    cur += poll;
                    cnt++;
                    if (cur >= s[0]) {
                        pq.add(s[1]);
                        break;
                    }
                }
            }
            if (cur >= target) {
                break;
            }
        }

        while (!pq.isEmpty() && cur < target) {
            cur += pq.poll();
            cnt++;
        }

        return cur >= target ? cnt : -1;
    }
}


