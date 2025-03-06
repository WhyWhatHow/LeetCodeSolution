package leetcode.algorithm.hash;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2588 {

    public static void main(String[] args) {
        Solution_2588 sol = new Solution_2588();
        System.out.println("==================");
    }

    public long beautifulSubarrays(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(); // key : XSum(nums[0-i]), value :count
        map.put(0, 1);
        int sum = 0;
        long cnt = 0;

        for (int num : nums) {
            sum = sum ^ num;
            cnt += map.getOrDefault(sum, 0);
            map.compute(sum, (k, v) -> v == null ? 1 : v + 1);
        }

        return cnt;
    }

}


