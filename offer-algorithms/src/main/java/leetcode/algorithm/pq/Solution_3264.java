package leetcode.algorithm.pq;

import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3264 {

    public static void main(String[] args) {
        Solution_3264 sol = new Solution_3264();
        System.out.println("==================");
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
        });
        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[]{nums[i], i});
        }
        for (int i = 0; i < k; i++) {
            int[] a = pq.poll();
            int val = a[0] * multiplier;
            nums[a[1]] = val;
            pq.add(new int[]{val, a[1]});
        }
        while (!pq.isEmpty()) {
            int[] polled = pq.poll();
            int i = polled[1];
            int val = polled[0];
            nums[i] = val;
        }
        return nums;
    }
}


