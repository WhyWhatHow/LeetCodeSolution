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
        System.out.println(sol.minAnagramLength(
//                "abba"
//                "cdef"
//                "abbaab"
                "aaa"
        ));
        System.out.println("==================");
    }

    /**
     * s="aabbabab"  解题思路, 先中间分开, aabb, abab , 判断两者子串是否相等.
     *
     * @param s
     * @return
     */
    public int minAnagramLength(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        int res = n;
        for (int i = 2; i <= n; i++) {
            if (n % i != 0) continue;
            if (check(n / i, cs)) res = n / i;
        }
        return res;


    }

    // 以 [0,k] 构建子串, 判断其是否相等.
    private boolean check(int k, char[] cs) {
        int n = cs.length;
        int m = 26;
        int[] c = new int[m];
        int[] cc = new int[m];

        // int[] 26 ,
        for (int i = 0; i <= n - k; i += k) {
            if (i == 0) {
                fillCountsArray(cs, i, i + k, c);
            } else {
                fillCountsArray(cs, i, i + k, cc);
                if (!checkArray(c, cc)) return false;
            }
        }
        return true;
    }

    private boolean checkArray(int[] c, int[] cc) {
        for (int i = 0; i < c.length; i++) {
            if (c[i] != cc[i]) return false;
        }
        return true;
    }

    // l-r
    private void fillCountsArray(char[] cs, int l, int r, int[] c) {
        Arrays.fill(c, 0);
        for (int i = l; i < r; i++) {
            c[cs[i] - 'a']++;
        }
    }


}


