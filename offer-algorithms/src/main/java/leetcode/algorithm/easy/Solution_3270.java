package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3270 {

    public static void main(String[] args) {
        Solution_3270 sol = new Solution_3270();
        System.out.println(String.format("%04d", 21));
        System.out.println(String.valueOf(21));
        System.out.println("==================");
    }

    public int generateKey(int num1, int num2, int num3) {
        String format = "%04d";
        String s1 = String.format(format, num1);
        String s2 = String.format(format, num2);
        String s3 = String.format(format, num3);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(min(s1, s2, s3, i));
        }
        return Integer.valueOf(sb.toString());
    }

    private char min(String s1, String s2, String s3, int i) {
        int min = Math.min(s3.charAt(i), Math.min(s1.charAt(i), s2.charAt(i)));
        return (char) min;
    }
}
