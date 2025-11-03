package leetcode.algorithm.greedy;

import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1578 {

    public static void main(String[] args) {
        Solution_1578 sol = new Solution_1578();
        System.out.println(sol.minCost(
                "aaabbbabbbb",
                new int[]{
                        3,5,10,7,5,3,5,5,4,8,1
        }));
        System.out.println("==================");
    }

    public int minCost(String colors, int[] neededTime) {
        int res = 0;
        int n = neededTime.length;
        char[] cs = colors.toCharArray();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        char tar = cs[0];
        pq.add(neededTime[0]);
        for (int i = 1; i < n; i++) {
            if (tar == cs[i]) {
                pq.add(neededTime[i]);
            } else {
                while (pq.size() > 1) {
                    res += pq.poll();
                }
                pq.clear();
                tar = cs[i];
                pq.add(neededTime[i]);
            }
        }
        while (pq.size()>1){
            res+=pq.poll();
        }
        return res;
    }
}


