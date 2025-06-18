package leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2966 {

    public static void main(String[] args) {
        Solution_2966 sol = new Solution_2966();

        System.out.println("==================");
    }

    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] rs = new int[n / 3][3];
        int cnt = 0;
        // check
        for (int i = 0; i < nums.length; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[][]{};
            }
            for (int j = 0; j < 3; j++) {
                rs[cnt][j] = nums[i + j];
            }
            cnt++;
        }
        return rs;

    }
}


