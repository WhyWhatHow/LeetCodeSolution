package leetcode.algorithm.greedy;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2434 {

    public static void main(String[] args) {
        Solution_2434 sol = new Solution_2434();
        System.out.println(sol.robotWithString(
//                "bac"
                "vzhofnpo"
        ));
        System.out.println("==================");
    }

    public String robotWithString(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;

        char[] ss = new char[n];  // 后缀数组, 维护从[i,n) 范围的最小值.
        ss[n - 1] = cs[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            ss[i] = (char) Math.min(ss[i + 1], cs[i]);
        }

        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cs.length; i++) {
            if (cs[i] > ss[i]) {
                st.push(cs[i]);
            } else {
                sb.append(cs[i]);
                int j = i + 1;
                while (!st.isEmpty() && j < n && st.peek() <= ss[j]) {
                    if (st.peek() == ss[j]) j++;
                    sb.append(st.pop());
                }
            }
        }

        while (!st.isEmpty()) sb.append(st.pop());

        return sb.toString();
    }


    // pq 做很蠢.
    public String robotWithStringByStupid(String s) {
        char[] cs = s.toCharArray();
        Stack<Character> st = new Stack<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (cs[a] != cs[b])
                return cs[a] - cs[b];
            else
                return a - b;
        });
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cs.length; i++) {
            pq.add(i);
        }

//        while (!pq.isEmpty()) System.out.println(pq.peek()+"L:"+cs[pq.poll()]);

        for (int i = 0; i < cs.length; i++) {

            if (!pq.isEmpty() && cs[i] > cs[pq.peek()]) {
                st.push(cs[i]);
            } else {
                // cs[i]<= cs[pq.peek()]
                pq.poll();
                sb.append(cs[i]);

                while (!pq.isEmpty() && pq.peek() < i) {
                    pq.poll();
                }

                while (!st.isEmpty() && !pq.isEmpty() && st.peek() <= cs[pq.peek()]) {
                    if (st.peek() == cs[pq.peek()] && pq.peek() < i) pq.poll();
                    sb.append(st.pop());
                }
            }
        }

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.toString();
    }
}


