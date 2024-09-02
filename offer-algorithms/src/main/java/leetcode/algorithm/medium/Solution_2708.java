package leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2708 {

    public static void main(String[] args) {
        Solution_2708 sol = new Solution_2708();
        System.out.println("==================");
    }

    public long maxStrength(int[] nums) {
        if(nums.length == 1) return nums[0];
        long res = 1;
        int[] ns = new int[nums.length];
        int cnt = 0;
        boolean checked = false;
        for (int num : nums) {
            if (num > 0) {
                checked = true;
                res *= num;
            }
            if (num < 0)
                ns[cnt++] = num;
        }
        Arrays.sort(ns);
        for (int i = 0; i < ns.length; i += 2) {
            if (i + 1 >= ns.length) break;
            if (ns[i] == 0 || ns[i + 1] == 0) break;
            res *= ns[i];
            res *= ns[i + 1];
            checked = true;
        }
        return checked ? res:0;
    }


}


