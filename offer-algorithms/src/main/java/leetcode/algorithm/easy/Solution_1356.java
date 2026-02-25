package leetcode.algorithm.easy;

import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1356 {

    public static void main(String[] args) {
        Solution_1356 sol = new Solution_1356();//
        System.out.println("==================");
    }

    public int[] sortByBits(int[] arr) {
        var pq = new PriorityQueue<Integer>((a, b) -> {
            if (Integer.bitCount(a) != Integer.bitCount(b)) {
                return Integer.bitCount(a) - Integer.bitCount(b);
            } else
                return a - b;
        });
        for (int i : arr) {
            pq.add(i);
        }
        int i = 0;
        while (!pq.isEmpty()) {
            arr[i++] = pq.poll();
        }
        return arr;
    }

}
