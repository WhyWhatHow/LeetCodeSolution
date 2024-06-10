package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_7 {
    public int reverse(int x) {
        Integer temp = new Integer(x);
        char[] chars = temp.toString().toCharArray();
        boolean check = false;
        StringBuilder builder = new StringBuilder();
        if (chars[0] == '-') {
            builder.append('-');
            check = true;
        }
        for (int i = chars.length - 1; i >= 0; i--) {
            if (i != 0) {
                builder.append(chars[i]);
            } else {
                if (check) {
                    break;
                }
                builder.append(chars[i]);
            }
        }
        String s = builder.toString();
        Long res = new Long(s);
        if (Math.abs(res) > Integer.MAX_VALUE) {
            return 0 ;
        }
        // 9646324351
        // 2147483647
        return Math.toIntExact(res);


    }

    public static void main(String[] args) {
        Solution_7 sol = new Solution_7();
        long reverse = sol.reverse(1534236469);
        System.out.println(reverse);
        System.out.println("==================");
    }
}


