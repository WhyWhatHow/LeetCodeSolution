package leetcode.algorithm.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_594 {

    public static void main(String[] args) {
        Solution_594 sol = new Solution_594();
        System.out.println(sol.findLHS(new int[]{
                1, 1, 1, 1
        }));
        System.out.println("==================");
    }

        public int findLHS(int[] nums) {
            Arrays.sort(nums);
            int res = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.compute(nums[i], (k, v) -> k == null ? 1 : v + 1);
            }
            for (int i = 0; i < nums.length; i++) {
                Integer val = map.getOrDefault(nums[i] + 1, 0);
                if(val == 0) continue;
                res = Math.max(res, val+map.get(nums[i]));
            }
            return res;
        }
}


