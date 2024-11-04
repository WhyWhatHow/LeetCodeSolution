package leetcode.algorithm.medium;

import java.util.HashSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_633 {

    public static void main(String[] args) {
        Solution_633 sol = new Solution_633();
        System.out.println(Math.sqrt((int) Math.pow(2, 31) - 1));
//        System.out.println(sol.judgeSquareSum(4));
        System.out.println(sol.judgeSquareSum(2147482647));
        System.out.println("==================");
    }

    /**
     * two pointers
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        long l = 0;
        long r = (long) Math.sqrt(c);
        while (l <= r) {
            long tmp = l * l + r * r;
            if (tmp == c) return true;
            else if (tmp < c) {
                l++;
            } else r--;
        }
        return false;
    }

    /**
     * 打表
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSumTable(int c) {
        if (c == 1) return true;
        int mid = c / 2;
//        int[] arr = new int[mid];
        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i <= mid; i++) {
            long val = (long) i * i;
            if (val > c) {
                break;
            }
            set.add(val);
        }
        for (Long i : set) {
            long val = c - i;
            if (set.contains(val)) return true;
        }
        return false;
    }

}


