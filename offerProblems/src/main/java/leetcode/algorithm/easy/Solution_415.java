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
        boolean up = false;
        while (i >= 0 && j >= 0) {
            int val = ns[i--] - zero + nss[j--] - zero;
            val = up ? val + 1 : val;
            if (val >= 10) {
                val -= 10;
                up = true;
            } else {
                up = false;
            }
            builder.append(val);

        }

        while (i >= 0) {
            int val = ns[i--] - zero;
            val = up ? val + 1 : val;
            if (val >= 10) {
                val -= 10;
                up = true;
            } else {
                up = false;
            }
            builder.append(val);
        }
        while (j >= 0) {
            int val = nss[j--] - zero;
            val = up ? val + 1 : val;
            if (val >= 10) {
                val -= 10;
                up = true;
            } else {
                up = false;
            }
            builder.append(val);
        }
        if (up) builder.append(1);
        return builder.reverse().toString();
    }

}


