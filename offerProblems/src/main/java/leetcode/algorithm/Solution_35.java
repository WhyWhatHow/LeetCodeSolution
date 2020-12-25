package leetcode.algorithm;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_35 {
    // 返回下标
    int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = -1, ans = -1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public int searchInsert(int[] nums, int target) {
        int loc= binarySearch(nums, target);
        int i = Arrays.binarySearch(nums, target);

        if(loc!=-1 && nums[loc]==target)
            return loc;
        else return loc+1;
    }

    public static void main(String[] args) {
        Solution_35 sol = new Solution_35();
        int[] nums = new int[]{1,3,5,6};
        int i = sol.searchInsert(nums, 5);
        System.out.println("==================");
    }
}


