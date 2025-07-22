package leetcode.algorithm.greedy;

import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1717 {

    public static void main(String[] args) {
        Solution_1717 sol = new Solution_1717();
        System.out.println(sol.maximumGain(
//                "cdbcbbaaabab", 4, 5

        ));
        System.out.println("==================");
    }

    public int maximumGain(String s, int x, int y) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int res = 0;
        boolean[] vis = new boolean[n];
        if (x > y) {
            res += doHandle(cs, x, vis, 'a', 'b');
            res += doHandle(cs, y, vis, 'b', 'a');
        } else {

            res += doHandle(cs, y, vis, 'b', 'a');

            res += doHandle(cs, x, vis, 'a', 'b');
        }
        return res;
    }

    private int doHandle(char[] cs, int y, boolean[] vis, char first, char second) {
        int res = 0;
        int n = cs.length;
        Stack<Integer> st = new Stack<>();
        // ab
        for (int i = 0; i < cs.length; i++) {
            if (vis[i]) continue;
            while (i < n && !st.isEmpty() && cs[st.peek()] == first && cs[i] == second) {
//                System.out.println("handle:" + st.peek() + ":" + first + second);
                vis[i] = true;
                vis[st.pop()] = true;
                res += y;
                while (i < n && vis[i])
                    i++;
            }
            st.push(i);
        }
        return res;
    }


}


