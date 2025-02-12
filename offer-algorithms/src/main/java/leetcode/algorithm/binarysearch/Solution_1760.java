package leetcode.algorithm.binarysearch;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1760 {

    public static void main(String[] args) {
        Solution_1760 sol = new Solution_1760();
        System.out.println(sol.minimumSize(new int[]{
                9,3,5
        }, 2));
        System.out.println("==================");
    }


    public int minimumSize(int[] nums, int maxOperations) {
        Arrays.sort(nums);
        int right = nums[nums.length - 1];
        return search(nums, maxOperations, 1, right);
    }
    //[l,r]
    private int search(int[] nums, int maxOperations, int left, int right) {
        int mid = left + (right - left) / 2;
        int res = -1;
        while (left <= right) {
            mid = left+ (right-left)/2;
            if (check(nums, maxOperations, mid)) {
                res = mid;
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    private boolean check(int[] nums, int maxOperations, int mid) {
        int cnt = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            cnt += (nums[i] - 1) / mid;
            if (cnt > maxOperations) return false;
        }
        return true;

    }
}
