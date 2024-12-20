package leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3138 {

    public static void main(String[] args) {
        Solution_3138 sol = new Solution_3138();
        String[] ss = new String[]{"abba"
                , "abbaab"
                , "cdef"
                , "abbaab"
                , "aaa"};
        for (String s : ss) {
            System.out.println(s+" : "+sol.minAnagramLength(s));
        }
        System.out.println("==================");
    }


    public int minAnagramLength(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0 && check(i, cs)) return i;
        }
        return n;

    }

    int[] c = new int[26];
    int[] cc = new int[26];

    //subStr len = k
    private boolean check(int k, char[] cs) {
        for (int i = 0; i <= cs.length - k; i += k) {
            if (i == 0) fill(cs, i, i + k, c);
            else {
                fill(cs, i, i + k, cc);
                if (!Arrays.equals(c, cc)) return false;
            }
        }
        return true;
    }

    private void fill(char[] cs, int l, int r, int[] c) {
        Arrays.fill(c, 0);
        for (int i = l; i < r; i++) {
            c[cs[i] - 'a']++;
        }
    }


}


