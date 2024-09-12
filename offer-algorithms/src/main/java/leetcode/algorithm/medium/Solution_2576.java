package leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2576 {

    public static void main(String[] args) {
        Solution_2576 sol = new Solution_2576();
        System.out.println(sol.maxNumOfMarkedIndices(new int[]{42, 83, 48, 10, 24, 55, 9, 100, 10, 17, 17, 99, 51, 32, 16, 98, 99, 31, 28, 68, 71, 14, 64, 29, 15, 40}));
        System.out.println("==================");
    }

    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int cnt = 0;
        int n = nums.length;
        int r = n - 1;
        int l = n / 2 - 1;
        int br = l;
        boolean[] vis = new boolean[n];
        while (l >= 0) {
            while (l >= 0 && nums[l] * 2 > nums[r]) l--;
            if (l < 0) break;
            cnt += 2;
            l--;
            r--;
        }
        return cnt;
    }


}


