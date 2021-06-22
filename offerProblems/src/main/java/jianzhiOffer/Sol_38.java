package jianzhiOffer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_38 {
    char[] chars;

    /**
     * 求字符串的全排列
     * 解题思路:
     *
     * @param s
     * @return
     */
    public String[] permutation(String s) {
        List<String> resList = new LinkedList<>();
        if (s == null || s.length() == 0 || s.equals("")) {
            return resList.toArray(new String[resList.size()]);
        }
        chars = s.toCharArray();
        dfs(0, resList);
        return resList.toArray(new String[resList.size()]);
    }

    private void dfs(int i, List<String> resList) {
        if (i == chars.length - 1) {
            resList.add(String.valueOf(chars));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int j = i; j < chars.length; j++) {
            if (set.contains(chars[j])) {
                continue;
            }
            set.add(chars[j]);
            swap(j, i);
            dfs(i + 1, resList);
            swap(j, i);
        }
    }

    private void swap(int j, int i) {
        char temp = chars[j];
        chars[j] = chars[i];
        chars[i] = temp;
    }

    public static void main(String[] args) {
        Sol_38 sol = new Sol_38();
        String[] abcs = sol.permutation("abc");
        System.out.println(abcs);

        System.out.println("=======");
    }
}
