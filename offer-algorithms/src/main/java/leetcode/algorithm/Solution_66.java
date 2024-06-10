package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_66 {
    public int[] plusOne(int[] digits) {
        // 标记进位
        boolean check[] = new boolean[digits.length + 1];
        // 加一
        digits[digits.length - 1]++;
        if (digits[digits.length - 1] >= 10) {
            check[digits.length - 1] = true;
            digits[digits.length - 1] -= 10;
        }
        //处理进位
        for (int i = digits.length - 2; i >= 0; i--) {
            if (check[i + 1]) {
                digits[i]++;
                if (digits[i] >= 10) {
                    check[i] = true;
                    digits[i] -= 10;
                }
            }
        }
        // 处理首位
        if (check[0] == true) {
            int res[] = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = digits[i];
            }
            return res;
        }
        return digits;

    }

    public static void main(String[] args) {
        Solution_66 sol = new Solution_66();
        int[] ints = sol.plusOne(new int[]{9, 9});
        int[] ints1 = sol.plusOne(new int[]{5, 5, 9});
        int[] ints2 = sol.plusOne(new int[]{9});
        int[] ints3 = sol.plusOne(new int[]{5});
        System.out.println("==================");
    }
}


