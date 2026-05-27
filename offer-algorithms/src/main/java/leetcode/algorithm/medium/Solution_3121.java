package leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3121 {

    public static void main(String[] args) {


        Solution_3121 sol = new Solution_3121();//
        System.out.println(sol.numberOfSpecialChars(
//                "AbBCab"
                "cCceDC"
        ));

        System.out.println("==================");
    }

    public int numberOfSpecialChars(String word) {
        char[] cs = word.toCharArray();
        int[] ls = new int[2222]; // 记录最后一个小写字母出现的位置.
        boolean[] v = new boolean[2222];
        Arrays.fill(ls, Integer.MAX_VALUE);
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] >= 'a') ls[cs[i]] = i;
        }

        int res = 0;

        for (int i = 0; i < cs.length; i++) {
            if (!v[cs[i]] && cs[i] <= 'Z') {
                var c = Character.toLowerCase(cs[i]);
                if (!v[c] && ls[c] < i) {
                    res++;
                    v[c] = true;
                } else {
                    ls[c] = Integer.MAX_VALUE;
                }
            }
        }

        return res;
    }


}
