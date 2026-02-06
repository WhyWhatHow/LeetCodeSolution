package leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3634 {

    public static void main(String[] args) {
        Solution_3634 sol = new Solution_3634();//
        System.out.println(sol.minRemoval(
                new int[]{2, 1, 5},
                2
        ));
        System.out.println("==================");
    }

    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, r = l;

        int res = n;
        while (l <= r && l < n && r < n) {
            long tar = 1l * nums[l] * k;
            while (r < n && Long.compare(nums[r], tar) <= 0) {
                r++;
            }
            res = Math.min(res, n - r +l);// 去掉左侧元素, 去掉右侧元素.
            l++;
        }
        return res;
    }

}
