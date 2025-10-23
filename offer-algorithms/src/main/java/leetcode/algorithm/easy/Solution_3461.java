package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3461 {

    public static void main(String[] args) {
        Solution_3461 sol = new Solution_3461();
        System.out.println(sol.hasSameDigits("44472"));
        System.out.println("==================");
    }

    char zero = '0';

    public boolean hasSameDigits(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        while (n > 2) {
            for (int i = 1; i < n; i++) {
                cs[i - 1] = (char) (((cs[i] + cs[i - 1] - zero - zero) % 10)+zero);
            }
            n--;
        }
        return cs[0] == cs[1];
    }

}


