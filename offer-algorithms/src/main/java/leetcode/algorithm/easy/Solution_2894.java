package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2894 {

    public static void main(String[] args) {
        Solution_2894 sol = new Solution_2894();
        System.out.println("==================");
    }

    public int differenceOfSums(int n, int m) {
        int nn = 0;
        int mm = 0;
        for (int i = 1; i <= n; i++) {
            if (m % i != 0) {
                nn += i;
            } else {
                mm += i;
            }
        }
        return nn - mm;
    }
}


