package leetcode.algorithm.demo;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_556 {

    public static void main(String[] args) {
        Solution_556 sol = new Solution_556();
        System.out.println("==================");
        System.out.println(sol.nextGreaterElement(123458887));
        System.out.println(sol.nextGreaterElement(21));
        System.out.println(sol.nextGreaterElement(230241));
        System.out.println(sol.nextGreaterElement(3476));
    }

    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        boolean change = false;
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] > chars[i - 1]) {
                Arrays.sort(chars, i, chars.length);
                for (int j = i; j < chars.length; j++) {
                    if (chars[i - 1] < chars[j]) {
                        char temp = chars[j];
                        chars[j] = chars[i - 1];
                        chars[i - 1] = temp;
                        change = true;
                        break;
                    }
                }
                if (change) break;
            }
        }
        String ss = String.valueOf(chars);
        long res = Long.valueOf(ss);
        res = res > Integer.MAX_VALUE ? -1 : res;
        res = res > n ? res : -1;
        return (int) res;
    }
}


