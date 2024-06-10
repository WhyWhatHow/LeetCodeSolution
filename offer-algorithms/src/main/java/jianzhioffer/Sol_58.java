package jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_58 {

    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int length = s.length();
        String substring1 = s.substring(0, n);
        String substring = s.substring(n, s.length());
        return substring + substring1;

    }

    public static void main(String[] args) {
        Sol_58 sol = new Sol_58();
//        String s = sol.reverseLeftWords("abc", 2);
//        System.out.println(s);
        String s = sol.reverseWords("  hello world  ");
        System.out.println(s);
        System.out.println("==============");
    }

    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        String[] s1 = s.split(" ");
        StringBuilder builder = new StringBuilder();
        int last = 0;
        List<String> list = new ArrayList<>();
        for (String s2 : s1) {
            if (!s2.isEmpty()) {
                list.add(s2);
            }
        }// 去掉 "" 空串
        for (int i = list.size() - 1; i >= 0; i--) {

            builder.append(list.get(i));
            if (i != 0) {
                builder.append(" ");
            }
        }

        return builder.toString();
    }
}
