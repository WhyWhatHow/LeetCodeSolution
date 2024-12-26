package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3083 {

    public static void main(String[] args) {
        Solution_3083 sol = new Solution_3083();
        System.out.println("==================");
    }

    public boolean isSubstringPresent(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder(s);
        String ss = sb.reverse().toString();
        for (int i = 1; i < chars.length; i++) {
            String str = String.valueOf(chars, i - 1, 2);
            if (ss.contains(str)) {
                 return true;
            }
        }
        return false ;
    }

}


