package leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2294 {

    public static void main(String[] args) {
        Solution_2294 sol = new Solution_2294();
        System.out.println(sol.partitionArray(new int[]{
                3, 6, 1, 2, 5
        }, 2));

        System.out.println("==================");
    }

    public int partitionArray(int[] nums, int k) {

        int res = 0;
        Arrays.sort(nums);
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > min + k) {
                res++;
                min = nums[i];
            }
        }
        return ++res;

    }

}


