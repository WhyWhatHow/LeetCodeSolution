package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_540 {

    public static void main(String[] args) {
        Solution_540 sol = new Solution_540();
        System.out.println("==================");
    }

    public int singleNonDuplicate(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}


