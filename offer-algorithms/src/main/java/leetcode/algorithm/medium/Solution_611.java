package leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_611 {

    public static void main(String[] args) {
        Solution_611 sol = new Solution_611();
        System.out.println(sol.triangleNumber(new int[]{2, 2, 3, 4}));
        System.out.println("==================");
    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int max = nums[i] + nums[j];
                int k = search(nums, j, max);
                if (k == -1) continue;
                cnt += k - j;
            }
        }
        return cnt;
    }

    private int search(int[] nums, int l, int tar) {
        int r = nums.length - 1;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < tar) {
                res = mid;
                l = mid + 1;
            } else
                r = mid - 1;
        }
        return res;
    }

}


