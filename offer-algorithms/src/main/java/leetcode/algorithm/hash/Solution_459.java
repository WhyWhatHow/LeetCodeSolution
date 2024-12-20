package leetcode.algorithm.hash;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_459 {

    public static void main(String[] args) {
        Solution_459 sol = new Solution_459();
        System.out.println(sol.repeatedSubstringPattern(
//                "ababba"
                "abaababaab"
        ));
        System.out.println("==================");
    }

    public boolean repeatedSubstringPattern(String s) {
        String ss = s + s;
        return ss.substring(1, ss.length() - 1).contains(s);
    }
}


