package leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1877 {

    public static void main(String[] args) {
        Solution_1877 sol = new Solution_1877();
        System.out.println("==================");
    }

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n / 2; i++) {
            res = Math.max(res, nums[i] + nums[n - 1 - i]);
        }
        return res;
    }

}


