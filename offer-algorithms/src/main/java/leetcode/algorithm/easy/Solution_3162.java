package leetcode.algorithm.easy;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3162 {

    public static void main(String[] args) {
        Solution_3162 sol = new Solution_3162();
        System.out.println("==================");
    }

    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] *= k;
        }
        int res = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                if (i < j) break;
                if (i % j == 0) res++;
            }
        }
        return res ;
    }

}


