package jianzhiOffer;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_50 {
    public char firstUniqChar(String s) {
        if (s == null || s.isEmpty()) {
            return ' ';
        }
        char res = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c, 0)+1);
        }
        for (char c : s.toCharArray()) {
            if (map.get(c)>1) {
                continue;
            }else {
                res =c;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Sol_50 sol = new Sol_50();
        char leetcode = sol.firstUniqChar("leetcode");
        System.out.println(leetcode);
        System.out.println("=======");
    }
}
