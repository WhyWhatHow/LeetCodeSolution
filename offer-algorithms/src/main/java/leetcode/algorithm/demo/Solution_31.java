package leetcode.algorithm.demo;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_31 {

    public static void main(String[] args) {
        Solution_31 sol = new Solution_31();
        System.out.println("==================");
    }

    public void nextPermutation(int[] nums) {
        boolean  change = false ;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i - 1] < nums[i]) {
                Arrays.sort(nums,i, nums.length);
                for (int j = i; j < nums.length; j++) {
                    if (nums[i-1]<nums[j]) {
                        int temp = nums[i-1];
                        nums[i-1] = nums[j];
                        nums[j] =temp;
                        change = true;
                        break;
                    }
                }
                if (change) break;
            }
            if(!change) Arrays.sort(nums);
        }
    }
}


