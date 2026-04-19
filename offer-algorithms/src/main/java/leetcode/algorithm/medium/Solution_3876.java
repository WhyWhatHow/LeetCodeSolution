package leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3876 {

    public static void main(String[] args) {
        Solution_3876 sol = new Solution_3876();//

        System.out.println("==================");
    }


    public boolean uniformArray(int[] nums) {
        Arrays.sort(nums);
        int ocnt = 0;
        int ecnt = 0;
        for (int num : nums) {
            if ((num & 1) == 1) ocnt++;
            else ecnt++;
        }
        if (ocnt == 0 || ecnt == 0) return true;
        if ((nums[0] & 1) == 0) {
            return ocnt > 0 ? false : true;
        } else {
            // odd
            for (int i = 1; i < nums.length; i++) {
                if ((nums[i] & 1) == 0 && nums[i] - nums[0] < 1) return false;
            }
            return true;
        }

    }
}
