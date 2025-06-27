package leetcode.algorithm.hard;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2014 {

    public static void main(String[] args) {
        Solution_2014 sol = new Solution_2014();
        System.out.println(sol.longestSubsequenceRepeatedK("letsleetcode", 2));

        System.out.println("==================");
    }

    public String longestSubsequenceRepeatedK(String s, int k) {
        Queue<String> q = new ArrayDeque<>();
        q.add("");
        String res = "";
        while (!q.isEmpty()) {
            String cur = q.poll();

            for (char c = 'a'; c <= 'z'; c++) {
                String ss = cur + c;
                if (getsubStringRepeat(ss, s, k) >= k) {
                    q.add(ss);
                    res = res.length() > ss.length() ? res : ss;
                }
            }
        }
        return res;
    }

    private int getsubStringRepeat(String ss, String s, int k) {
        if (ss.length() == 0) return s.length();
        char[] cs = s.toCharArray();
        int cnt = 0;
        char[] css = ss.toCharArray();
        int i = 0; // 标记 ss的初始位置.
        for (int j = 0; j < cs.length; j++) {
            if (css[i] == cs[j]) {
                i++;
                if (i == css.length) {
                    cnt++;
                    if (cnt >= k) return k;
                    i = 0;
                }
            }
        }

        return cnt;

    }

}


