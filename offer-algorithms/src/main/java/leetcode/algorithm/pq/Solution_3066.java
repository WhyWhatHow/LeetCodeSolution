package leetcode.algorithm.pq;

import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3066 {

    public static void main(String[] args) {
        Solution_3066 sol = new Solution_3066();
        System.out.println(sol.minOperations(new int[]{1000000000, 999999999, 1000000000, 999999999, 1000000000, 999999999}, 1000000000));
        System.out.println("==================");
    }

    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i : nums) pq.add((long) i);
        int cnt = 0;
        while (!pq.isEmpty() && pq.size() >= 2) {

            long x = pq.poll();
            if (x >= k) break;
            long y = pq.poll();
            pq.add(x * 2 + y);
            cnt++;
        }

        return cnt;
    }
}
