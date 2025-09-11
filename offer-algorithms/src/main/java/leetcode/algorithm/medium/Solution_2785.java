package leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.Set;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2785 {

    public static void main(String[] args) {
        Solution_2785 sol = new Solution_2785();
        System.out.println('a' > 'A');
        System.out.println("==================");
    }

    public String sortVowels(String s) {
        Set<Character> set = Set.of('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U');
        char[] cs = s.toCharArray();
        var q = new ArrayList<Character>();
        for (char c : cs) {
            if (set.contains(c)) q.add(c);
        }
        q.sort(Character::compareTo);
        for (int i = 0; i < cs.length; i++) {
            if (set.contains(cs[i])) {
                cs[i] = q.removeFirst();
            }
        }
        return String.valueOf(cs);
    }
}


