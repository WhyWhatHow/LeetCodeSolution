package leetcode.algorithm.demo;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_1071 {

    public static void main(String[] args) {
        Solution_1071 sol = new Solution_1071();
        System.out.println("==================");
        String s = sol.gcdOfStrings("ABABAB", "ABAB");
        System.out.println(s);
        String s1 = sol.gcdOfStrings("ABCABC", "BC");
        System.out.println(s1);
        String s2 = sol.gcdOfStrings("abcdef", "abc");
        System.out.println(s2);
    }

    // tauxxtauxx
    public String gcdOfStrings(String str1, String str2) {
        // 1. find substring of str1 || str2
        if (str1.length() < str2.length()) {
            String temp = str2;
            str2 = str1;
            str1 = temp;
        }


        int len = gcd(str1.length(), str2.length());
        String res = str1.substring(0, len);
        int repeat = str1.length() / len;
        int repeat2 = str2.length() / len;
//        String ss = new StringBuilder().repeat(res, repeat).toString();
//        if (ss.equals(str1)) {
//
//        }
//        String sss = new StringBuilder().repeat(res, repeat2).toString();
//        if (sss.equals(str2)) {
//
//        }
        return "";
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int getSubStringLength(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        int ans = 0;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;

    }

    boolean check(String template, String str) {
        if (template.length() > str.length()) return false;
        int i = 0, j = 0;
        while (i < str.length()) {
            if (j == template.length()) j = 0;
            if (template.charAt(j++) != str.charAt(i++)) {
                return false;
            }
        }
        return true;
    }
}


