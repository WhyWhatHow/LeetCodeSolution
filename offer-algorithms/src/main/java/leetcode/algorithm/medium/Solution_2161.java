package leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_2161 {

    public static void main(String[] args) {


        Solution_2161 sol = new Solution_2161();//
        System.out.println("==================");
    }

    public int[] pivotArray(int[] nums, int pivot) {
        int[] rs = new int[nums.length];
        Arrays.fill(rs, pivot);
        int l = 0, r = nums.length - 1;
        for (int num : nums) {
            if (num < pivot) rs[l++] = num;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > pivot) rs[r--] = nums[i];
        }
        return rs;
    }


}
