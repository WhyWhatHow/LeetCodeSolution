package leetcode.algorithm.medium;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3583 {

    public static void main(String[] args) {
        Solution_3583 sol = new Solution_3583();
        System.out.println("==================");
    }

    public int specialTriplets(int[] nums) {
        var map = new HashMap<Integer, Integer>(); // key : nums[i], val: cnt
        int n = nums.length;
        int[] pres = new int[n];
        int[] posts = new int[n];
        for (int i = 0; i < n; i++) {
            int key = nums[i] * 2;
            if (map.containsKey(key)) pres[i] += map.get(key);
            map.compute(nums[i], (k, v) -> v == null ? 1 : v + 1);
        }
        map.clear();
        long res = 0;
        int mod = 1000_000_007;
        for (int i = n - 1; i >= 0; i--) {
            int key = nums[i] * 2;
            posts[i] += map.getOrDefault(key, 0);
            res += (long) pres[i] * posts[i];
            res %= mod;
            map.compute(nums[i], (k, v) -> v == null ? 1 : v + 1);
        }
        return (int) res;

    }

}


