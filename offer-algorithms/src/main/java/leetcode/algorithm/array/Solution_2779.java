package leetcode.algorithm.window;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #binary Indexed Array
 * @author: WhyWhatHow
 **/

public class Solution_2779 {

    public static void main(String[] args) {
        Solution_2779 sol = new Solution_2779();
        System.out.println(sol.maximumBeauty(new int[]{4, 6, 1, 2}, 2));
        System.out.println("==================");
    }

    public int maximumBeauty(int[] nums, int k) {
        int res = 0;
        Arrays.sort(nums);
        int l = 0, r = 0;
        k = 2 * k;
        for (; r < nums.length; r++) {
            while (nums[r] - nums[l] > k) {
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}


