package leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_2452 {

    public static void main(String[] args) {
        Solution_2452 sol = new Solution_2452();//
//        System.out.println(1^1);
//        System.out.println(1^1^1);
        System.out.println(sol.twoEditWords(
                new String[]{"word", "note", "ants", "wood"},
                new String[]{"wood", "joke", "moat"}
        ));
        System.out.println("==================");
    }


    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> list = new ArrayList<>();
        for (String s : queries) {
            for (String d : dictionary) {
                if (s.length() == d.length() && getDiff(s, d) <= 2) {
                    list.add(s);
                    break;
                }
            }
        }
        return list;
    }

    private int getDiff(String s, String d) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != d.charAt(i)) cnt++;
        }
        return cnt;
    }



}
