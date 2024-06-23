package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_520 {

    public static void main(String[] args) {
        Solution_520 sol = new Solution_520();
        System.out.println("==================");
    }

    public boolean detectCapitalUse(String word) {
        String upper = word.toUpperCase();
        String lowerCase = word.toLowerCase();
        String sub = word.substring(1);
        String subLow = sub.toLowerCase();
        if (upper.equals(word)) return true;
        else if (lowerCase.equals(word)) return true;
        else if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z' && sub.equals(subLow)) return true;
        else return false;

    }

}


