package leetcode.algorithm.hash;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2364 {

    public static void main(String[] args) {
        Solution_2364 sol = new Solution_2364();
        System.out.println(sol.countBadPairs(new int[]{
//                4,1,3,3
                1, 2, 3, 4, 5
        }));
        System.out.println("==================");
    }


    /**
     * j-i == nums[j]-nums[i] ==> nums[j]-j == nums[i]-i
     */
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += i;
        }
        HashMap<Integer, Integer> map = new HashMap<>(); // nums[i]-i, cnt
        for (int i = 0; i < n; i++) {
            map.compute(nums[i] - i, (k, v) -> v == null ? 1 : v + 1);
        }
        long cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i] - i;
            int val = map.compute(key, (k, v) -> v - 1);
            if (val <= 0) continue;
            cnt += val;
        }
        return res - cnt;

    }

}


