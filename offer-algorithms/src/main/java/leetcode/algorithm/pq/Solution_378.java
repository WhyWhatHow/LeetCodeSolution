package leetcode.algorithm.pq;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_378 {

    public static void main(String[] args) {
        Solution_378 sol = new Solution_378();
        System.out.println(sol.kthSmallest(new int[][]{
                {1, 5, 9}, {10, 11, 13}, {12, 13, 15}
        }, 3));
        System.out.println("==================");
    }


    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int cnt = 0;
        int n = matrix.length;
        int res = 0;
        for (int[] rs : matrix) {
            for (int r : rs) {
                pq.add(r);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();

    }

}


