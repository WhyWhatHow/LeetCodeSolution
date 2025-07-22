package leetcode.algorithm.window;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1695 {

    public static void main(String[] args) {
        Solution_1695 sol = new Solution_1695();
        System.out.println(sol.maximumUniqueSubarray(new int[]{
                5,2,1,2,5,2,1,2,5
        }));
        System.out.println("==================");
    }

    public int maximumUniqueSubarray(int[] nums) {
        int res = 0;
        int sum = 0;
        int n = nums.length;
        int l = 0, r = l;
        HashMap<Integer, Integer> map = new HashMap<>();// key : num, val: count
        while (r < n) {
            // find repeat_num, move l
            while (map.getOrDefault(nums[r], 0) == 1) {
                sum -= nums[l];
                map.compute(nums[l], (k, v) -> v - 1);
                l++;
            }
            sum += nums[r];
            map.compute(nums[r], (k, v) -> v == null ? 1 : v + 1);
            res = Math.max(res, sum);
            r++;
        }
        return res;
    }

}


