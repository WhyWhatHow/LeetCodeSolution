package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1848 {

    public static void main(String[] args) {
        Solution_1848 sol = new Solution_1848();//

        System.out.println("==================");
    }

    public int getMinDistance(int[] nums, int target, int start) {
        // go left
        int res = nums.length;
        for (int i = start; i >= 0; i--) {
            if (nums[i] == target) res = Math.min(res, start - i);
        }
        //go right
        for (int i = start; i < nums.length; i++) {
            if (nums[i] == target) res = Math.min(res, i - start);
        }
        return res;

    }

}
