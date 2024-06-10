package leetcode.algorithm.pq;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_215 {

    public static void main(String[] args) {
        Solution_215 sol = new Solution_215();
        System.out.println("==================");
        System.out.println(sol.findKthLargest(new int[]{
                        3,2,1,5,6,4
                },
                2));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int res = 0;
        for (int num : nums) {
            pq.add(num);
        }
        while (!pq.isEmpty()) {
            Integer poll = pq.poll();
            k--;
            if (k == 0) {
                res = poll;
                break;
            }
        }
        return res;
    }
}


