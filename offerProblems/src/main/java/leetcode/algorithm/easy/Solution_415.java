package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_415 {

    public static void main(String[] args) {
        Solution_415 sol = new Solution_415();

        System.out.println("==================");
    }

    /**
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        char[] ns = num1.toCharArray();
        char[] nss = num2.toCharArray();
        int i = ns.length - 1;
        int j = nss.length - 1;
        char zero = '0';
        int carry = 0; // 进位标记
        int val = 0;
        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? ns[i--] - zero : 0;
            int b = j >= 0 ? nss[j--] - zero : 0;
            val = a + b + carry;
            if (val >= 10) {
                val -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            builder.append(val);
        }
        if (carry > 0) builder.append(carry);
        return builder.reverse().toString();
    }

}


