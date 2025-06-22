package leetcode.algorithm.easy;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2138 {

    public static void main(String[] args) {
        Solution_2138 sol = new Solution_2138();
        System.out.println(sol.divideString("abcdefghij", 3, 'x'));

        System.out.println("==================");
    }


    public String[] divideString(String s, int k, char fill) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int size = (n + k - 1) / k;
        String[] rs = new String[size];
        int cnt = 0;
        int end = -1;
        for (int i = 0; i < cs.length; i += k) {
            if (i + k <= cs.length)
                rs[cnt] = String.valueOf(cs, i, k);
            else {
                end = i;
                break;
            }
            cnt++;
        }
        char[] tcs = handleLastString(k, fill, end, cs);
        rs[cnt] = String.valueOf(tcs);

        return rs;

    }

    private char[] handleLastString(int k, char fill, int end, char[] cs) {
        char[] tcs = new char[k];
        Arrays.fill(tcs, fill);
        int j = 0;
        for (int i = end; i < cs.length; i++) {
            tcs[j++] = cs[i];
        }
        return tcs;
    }
}


