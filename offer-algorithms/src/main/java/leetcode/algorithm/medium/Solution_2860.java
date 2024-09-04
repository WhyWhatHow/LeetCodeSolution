package leetcode.algorithm.medium;

import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2860 {

    public static void main(String[] args) {
        Solution_2860 sol = new Solution_2860();
        System.out.println(sol.countWays(
                Arrays.asList(
                        1, 1, 0, 1
                )
        ));
        System.out.println("==================");

    }

    public int countWays(List<Integer> nums) {
        nums.sort(Integer::compareTo);
        int res = 0;
        int n = nums.size();
        if (n > nums.get(n - 1)) res++; // every one was selected
        if (0 < nums.get(0)) res++; // no one was selected
        for (int i = 1; i < n; i++) { // i = selected student's num :
            // nums = i , is selected
            if (nums.get(i) > i && nums.get(i - 1) < i) res++;
        }
        return res;
    }


}


