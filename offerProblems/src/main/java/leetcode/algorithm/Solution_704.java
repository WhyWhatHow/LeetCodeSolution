package leetcode.algorithm;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_704 {
    public int search(int[] nums, int target) {
        int idx = Arrays.binarySearch(nums, target);
        return idx < 0 ? -1 : idx;
    }

    public static void main(String[] args) {
        Solution_704 sol = new Solution_704();
        int search = sol.search(new int[]{-1, 0, 3, 5, 9, 12}, 2);
        System.out.println(search);
        System.out.println("==================");
    }
}


