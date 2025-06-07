package leetcode.algorithm.greedy;

import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3170 {

    public static void main(String[] args) {
        Solution_3170 sol = new Solution_3170();
//        System.out.println((char) Math.max('a', '*'));
        System.out.println(sol.clearStars(
//                "d*o*"
                "d*d*"
        ));
        System.out.println("==================");
    }

    public String clearStars(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (cs[a] != cs[b])
                return cs[a] - cs[b];
            else return b - a;
        });
        boolean[] vis = new boolean[n];

        for (int i = 0; i < cs.length; i++) {
            if (cs[i] != '*') pq.add(i);
            else {
                vis[i] = true;
                vis[pq.poll()] = true;
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cs.length; i++) {
            if (!vis[i]) {
                sb.append(cs[i]);
            }
        }
        return sb.toString();
    }

}


