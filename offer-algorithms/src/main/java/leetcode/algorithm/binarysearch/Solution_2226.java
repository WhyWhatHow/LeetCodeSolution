package leetcode.algorithm.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2226 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(3);
        Solution_2226 sol = new Solution_2226();
        System.out.println("==================");
    }

    public int maximumCandies(int[] candies, long k) {
        Arrays.sort(candies);
        int right = candies[candies.length - 1];
        return search(candies, k, 0, right);
    }

    /**
     * @param nums
     * @param k     // 需要的堆数
     * @param left  // 最少可以分配的数量
     * @param right // 最多可以分配的数量
     * @return
     */
    private int search(int[] nums, long k, int left, int right) {
        int mid;
        int res = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (check(mid, nums, k)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    private boolean check(int target, int[] nums, long k) {
        long cnt = 0;
        if(target ==0) return true;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < target) break;
            cnt += nums[i] / target;
            if(cnt>=k) return true;
        }
        return false ;
    }

}
