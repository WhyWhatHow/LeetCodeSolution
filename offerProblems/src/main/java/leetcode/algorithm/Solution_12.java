package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_12 {
    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        int[] keys = new int[]{1000,900, 500,400, 100,90, 50, 40, 10, 9, 5,4, 1};
        String[] vals = new String[]{"M","CM", "D","CD", "C","XC", "L","XL", "X","IX", "V","IV", "I"};
        for (int i = 0; i < keys.length; i++) {
            while (num >= keys[i]) {
                num -= keys[i];
                builder.append(vals[i]);
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        Solution_12 sol = new Solution_12();
        String s = sol.intToRoman(1994);
        System.out.println(s);
        System.out.println("==================");
    }
}


