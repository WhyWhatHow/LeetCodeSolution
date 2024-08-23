package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3146 {

    public static void main(String[] args) {
        Solution_3146 sol = new Solution_3146();
        System.out.println("==================");
    }

    public int findPermutationDifference(String s, String t) {

        int res = 0 ;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int idx = t.indexOf(String.valueOf(chars[i]));
            res += Math.abs(idx-i);
        }
        return res;
    }

}


