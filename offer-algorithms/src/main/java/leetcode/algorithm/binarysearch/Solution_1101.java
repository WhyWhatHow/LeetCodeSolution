package leetcode.algorithm.binarysearch;

import java.util.ArrayList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1101 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(3);
        Solution_1101 sol = new Solution_1101();
        System.out.println("==================");
    }
    public int shipWithinDays(int[] weights, int days) {
        int right = 0;
        for (int i : weights) {
            right += i;
        }
        return search(weights, days, 1, right);
    }

    int search(int[] nums, int limit, int left, int right) {
        int res = 0;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (check(mid, nums, limit)) {
                res = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return res;
    }

    boolean check(int tar, int[] nums, int limit) {
        int cnt = 1;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if(tar<nums[i]) return false;
            if (tmp + nums[i] <= tar) {
                tmp += nums[i];
            } else {
                tmp = nums[i];
                cnt++;
            }
            if (cnt > limit)
                return false;
        }
        return true;
    }


}
