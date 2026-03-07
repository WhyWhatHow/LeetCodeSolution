package leetcode.algorithm.binarysearch;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_154 {

    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) { // [mid+1,r ] 没有最小值
                r = mid;
            } else if (nums[mid] > nums[r]) { // [l,mid]之间没有最小值.换句话说, 最小值一定出现在区间[mid+1,r] 中.
                l = mid + 1;
            } else {
                r--;
            }
        }
        return nums[l];
    }
}


