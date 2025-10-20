package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2011 {

    public static void main(String[] args) {
        Solution_2011 sol = new Solution_2011();
        System.out.println("==================");
    }

    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String s : operations) {
            switch (s) {
                case "X++", "++X" -> res++;
                case "X--", "--X" -> res--;
//                case "++X", "X++":
//                    res++;
//                    break;
//                case "X--", "--X":
//                    res--;
//                    break;
            }
        }
        return res;
    }

}


