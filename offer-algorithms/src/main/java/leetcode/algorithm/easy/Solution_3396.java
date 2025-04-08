package leetcode.algorithm.easy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3396 {

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        System.out.println(set.remove(3));
        Solution_3396 sol = new Solution_3396();
        System.out.println(sol.minimumOperations(new int[]{
                1, 2, 3, 4, 2, 3, 3, 5, 7
        }));
        System.out.println("==================");
    }

    public int minimumOperations(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            Integer val = map.compute(i, (k, v) -> v == null ? 1 : v + 1);
            if (val > 1) set.add(i);
        }

        if (set.isEmpty()) return 0;

        int ops = 0;
        for (int i = 0; i < nums.length; i += 3) {
            for (int j = i; j < i + 3 && j < nums.length; j++) {
                Integer val = map.compute(nums[j], (k, v) -> v - 1);
                if (val == 1) {
                    set.remove(nums[j]);
                }
            }
            ops++;
            if(set.isEmpty()) break;
        }
        return ops;

    }
}


