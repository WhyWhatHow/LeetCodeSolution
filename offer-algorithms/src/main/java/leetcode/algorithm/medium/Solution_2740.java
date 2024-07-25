package leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2740 {

    public static void main(String[] args) {
        Solution_2740 sol = new Solution_2740();
        System.out.println("==================");
    }

    /***
     * 大值-> nums2
     * 小值 -> nums1
     * @param nums
     * @return
     */
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int[] arr = new int[nums.length];
        int min  = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            arr[i] = nums[i + 1] - nums[i];
            min = Math.min(min, arr[i]);
        }
        return min ;
    }
}


