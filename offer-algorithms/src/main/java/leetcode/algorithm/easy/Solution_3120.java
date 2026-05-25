package leetcode.algorithm.easy;

import java.util.HashSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3120 {

    public static void main(String[] args) {
//        System.out.println('a'-'A');
//        System.out.println('z'-'Z');
        Solution_3120 sol = new Solution_3120();//
        System.out.println(sol.numberOfSpecialChars(
                "aaAbcBC"
        ));
        System.out.println("==================");
    }

    public int numberOfSpecialChars(String word) {
        char[] cs = word.toCharArray();
        var set = new HashSet<Character>();
        int res = 0;
        for (char c : cs) {
            if (c >= 'a') set.add(c);
        }
        for (char c : cs) {
            if (c <= 'Z') {
                var nc = Character.toLowerCase(c);
                if (set.contains(nc)) {
                    res++;
                    set.remove(nc);
                }
            }
        }
        return res;
    }


}
