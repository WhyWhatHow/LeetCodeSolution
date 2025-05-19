package leetcode.algorithm.easy;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3024 {

    public static void main(String[] args) {
        Solution_3024 sol = new Solution_3024();
        System.out.println("==================");
    }

    public String triangleType(int[] nums) {

        if (nums[0] == nums[1] && nums[1] == nums[2]) return "equilateral";
        Arrays.sort(nums);
        if (nums[0] + nums[1] <= nums[2]) return "none";
        if (nums[1] == nums[0] || nums[1] == nums[2]) return "isosceles";
        return "scalene";
    }

}


