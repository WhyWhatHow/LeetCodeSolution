package leetcode.algorithm.greedy;

import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2131 {

    public static void main(String[] args) {
        Solution_2131 sol = new Solution_2131();
        System.out.println(sol.longestPalindrome(new String[]{
//                "cc", "cc", "lc", "cl", "bb"
//                "aa", "bb", "cc"
                "dd", "aa", "bb", "dd", "aa", "dd", "bb", "dd", "aa", "cc", "bb", "cc", "dd", "cc"
        }));
        System.out.println("==================");
    }

    public int longestPalindrome(String[] words) {
        int res = 0;
        int[][] a = new int[26][26];
        char c = 'a';
        for (String s : words) {
            int x = s.charAt(0) - c;
            int y = s.charAt(1) - c;
            a[x][y]++;
        }
        boolean yes = false;
        PriorityQueue<Integer> pq = new PriorityQueue<>((aa, b) -> b - aa);
        for (int i = 0; i < a.length; i++) {
            if ((a[i][i] & 1) == 0) res += a[i][i] * 2;// 偶数
            else { //odd
                pq.add(a[i][i]);
            }
            for (int j = i + 1; j < a.length; j++) {
                res += Math.min(a[i][j], a[j][i]) * 4;
            }
        }
        while (!pq.isEmpty()) {
            Integer poll = pq.poll();
            if (!yes) {
                yes = true;
            } else
                poll--;
            res += poll * 2;
        }
        return res;
    }

}


