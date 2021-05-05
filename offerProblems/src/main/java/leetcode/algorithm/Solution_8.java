package leetcode.algorithm;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_8 {

    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        boolean check = false;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ' ') {
                if (builder.length() > 0) {
                    break;
                } else {
                    continue;
                }
            } else if ((c == '+' || c == '-') && !check && builder.length() == 0) {
                builder.append(c);
                check = true;
            } else if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
                builder.append(c);
            } else {
                break;
            }
        }
        String temp = builder.toString();
        try {
            Double res
                    = new Double(temp);
//            Long res = new Long(temp);
            if (Integer.MIN_VALUE > res) {
                return Integer.MIN_VALUE;
            }
            if (Integer.MAX_VALUE < res) {
                return Integer.MAX_VALUE;
            }
            return new Integer(temp);

        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution_8 sol = new Solution_8();
        String[] arr = new String[]{
                "123-",
                "-13+8",
                "-5-",
                "9223372036854775807",
                "20000000000000000000",
                "   +0 123",
                "3.14159",
                "   -42",
                "4193 with words",
                "words and 987",
                "-91283472332"};
        for (String s : arr) {
            int i = sol.myAtoi(s);
            System.out.println(i);
            System.out.println("==================");

        }
    }
}


