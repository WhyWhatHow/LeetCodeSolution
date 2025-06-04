package leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3403 {

    public static void main(String[] args) {
        Solution_3403 sol = new Solution_3403();
        System.out.println(sol.answerString("gggg", 2));

        System.out.println("==================");
    }

    // 把word 分割成k个子串.
    // if len(word) == n,  最大子串的长度是 n-(k-1);
    public String answerString(String word, int k) {

        if (k == 1) return word;

        char[] cs = word.toCharArray();
        char maxC = 'a';
        for (char c : cs) {
            if (maxC < c) maxC = c;
        }

        List<Integer> list = new ArrayList<>(); //
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == maxC) {
                list.add(i);
            }
        }
        int n = word.length();
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            return b.compareTo(a);
        });
        for (Integer i : list) {
            if (i >= (k - 1)) {
                pq.add(word.substring(i,n));
            } else {
                pq.add(word.substring(i, n - k + 1 + i));
            }
        }
        return pq.peek();

    }

}


