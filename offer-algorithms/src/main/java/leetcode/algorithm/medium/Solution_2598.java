package leetcode.algorithm.medium;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2598 {

    public static void main(String[] args) {
        Solution_2598 sol = new Solution_2598();
        System.out.println(sol.findSmallestInteger(new int[]{
//                1, -10
//                1,-10,7,13,6,8
//                3, 0, 3, 2, 4, 2, 1, 1, 0, 4
                3,2,3,1,0,1,4,2,3,1,4,1,3
        }, 5));
        System.out.println("==================");
    }

    public int findSmallestInteger(int[] nums, int value) {
//        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i] % value;
            if (t < 0) t += value;
            map.compute(t, (k, v) -> v == null ? 1 : v + 1);
            max = Math.max(max, t);
        }

        for (int i = 0; i <= nums.length; i++) {
            int t = i % value;
            Integer val = map.getOrDefault(t, -1);
            if (val <= 0) {
                return i;
            } else {
                map.compute(t, (k, v) -> v == null ? -1 : v - 1);
            }
        }
        return nums.length;

    }
}


