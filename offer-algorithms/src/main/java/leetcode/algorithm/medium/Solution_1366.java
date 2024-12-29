package leetcode.algorithm.medium;

import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1366 {

    public static void main(String[] args) {
        Solution_1366 sol = new Solution_1366();
        String[] ss = new String[]{
//                "ABC", "ACB", "ABC", "ACB", "ACB"
                "AXYB", "AYXB", "AXYB", "AYXB"
        };
        System.out.println(sol.rankTeams(ss));
        ;
        System.out.println("==================");
    }


    public String rankTeams(String[] votes) {
        int len = votes[0].length();
        int[][] nums = new int[26][len + 1];
        boolean[] vis = new boolean[26];

        for (String s : votes) {
            for (int i = 0; i < len; i++) {
                int idx = s.charAt(i) - 'A';
                vis[idx] = true;
                nums[idx][i]++;
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            for (int i = 0; i < len; i++) {
                if (a.nums[i] != b.nums[i]) {
                    return b.nums[i] - a.nums[i];
                }
            }
            return a.c-b.c;
        });
        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) {
                char c = (char) (i + 'A');
                pq.add(new Node(c, nums[i]));
            }
        }


        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            sb.append(pq.poll().c);
        }

        return sb.toString();

    }

    private class Node {
        Character c;
        int[] nums;

        public Node(char c, int[] a) {
            nums = a;
            this.c = c;
        }
    }
}


