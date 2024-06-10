package leetcode.algorithm.demo;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_123 {

    public static void main(String[] args) {
        Solution_123 sol = new Solution_123();
        System.out.println("==================");
        System.out.println(sol.maxProfit(new int[]{
                7, 1, 5, 3, 6, 4
//                1,2,3,4,5
//                7, 6, 5, 4, 3, 2, 1
        }));
        ;

    }

    public int maxProfit(int[] prices) {
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < prices.length; i++) {
            int left = i, right = left + 1;
            while (left < right && right < prices.length) {
                if (prices[left] > prices[right]) break;
                right++;
                left++;
            }
            if (prices[i] < prices[left]) {
                int temp = prices[left] - prices[i];
                pq.add(temp);
                right = left;
            }
            i = left;
        }
        int cnt = 0;
        while (!pq.isEmpty()) {
            res+=pq.poll();
            cnt++;
            if (cnt == 2) {
                break;
            }
        }
        return res;
    }
}


