package leetcode.algorithm.easy;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2974 {

    public static void main(String[] args) {
        Solution_2974 sol = new Solution_2974();
        System.out.println(sol.numberGame(new int[]{
                5, 4, 2, 3
        }));
        ;
        System.out.println("==================");
    }

    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i += 2) {
            // even
            a[i + 1] = nums[i];
            //odd
            a[i] = nums[i + 1];

        }
        return a;
    }

}


