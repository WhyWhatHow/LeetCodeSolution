package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_543 {

    public static void main(String[] args) {
        Solution_543 sol = new Solution_543();
        System.out.println("==================");
    }

    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i += 2 * k) {
            reverse(cs, i, Math.min(i + k, cs.length) - 1); // if i+k > cs.length ; means only left m number of char and m < k
        }
        return String.valueOf(cs);
    }

    private char[] reverse(char[] cs, int left, int right) {
        while (left < right) {
            char c = cs[left];
            cs[left] = cs[right];
            cs[right] = c;
            left++;
            right--;
        }
        return cs;
    }

}
