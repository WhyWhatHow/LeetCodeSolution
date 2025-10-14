package leetcode.algorithm.easy;

import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3349 {

    public static void main(String[] args) {
        Solution_3349 sol = new Solution_3349();
        System.out.println(sol.hasIncreasingSubarrays(List.of(
//                -15, 19
                        7, 8, 9, 2, 4, 3
                ),
//                1
                3
        ));

        System.out.println("==================");
    }

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        for (int i = 0; i < nums.size(); i++) {
            if (check(nums, i, k) && check(nums, i + k, k)) return true;
        }
        return false;
    }

    private boolean check(List<Integer> nums, int i, int k) {
        int n = nums.size();
        if (i + k > n) return false;
        for (int j = i + 1; j < i + k; j++) {
            if (nums.get(j) <= nums.get(j - 1)) {
                return false;
            }
        }
        return true;
    }

}


