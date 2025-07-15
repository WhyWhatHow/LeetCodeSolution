package leetcode.algorithm.easy;

import java.util.Set;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3136 {

    public static void main(String[] args) {
        Solution_3136 sol = new Solution_3136();

        System.out.println("==================");
    }

    public boolean isValid(String word) {
        char[] cs = word.toLowerCase().toCharArray();
        boolean y = false, yy = false;
        int cnt = 0;
        Set<Character> s = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> ss = Set.of('$', '@', '#');
        for (char c : cs) {
            if (ss.contains(c)) return false;
            if (c >= 'a' && c <= 'z') {
                if (s.contains(c)) y = true;
                else yy = true;

            }
            cnt++;
        }
        return y && yy && cnt >= 3;
    }
}


