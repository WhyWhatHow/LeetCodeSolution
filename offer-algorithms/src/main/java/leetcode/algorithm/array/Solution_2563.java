package leetcode.algorithm.array;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2563 {

    public static void main(String[] args) {
        Solution_2563 sol = new Solution_2563();
        System.out.println(sol.countFairPairs(new int[]{
                        0, 1, 7, 4, 4, 5
                }, 3, 6
        ));
        System.out.println("==================");
    }

    /**
     * lower <=nums[i] +nums[j] <= upper
     *
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        return count(nums, upper) - count(nums, lower - 1);
    }

    // count(i) means in nums array, nums[i]+nums[j] <= target 的数量.
    // set if nums[j] >nums[i]
    // set sum = nums[j] +nums[i] , sum > target , j-- ;
    private long count(int[] nums, int target) {
        long res = 0;
        int i = 0, j = nums.length-1;
        while (i < j) {
            long sum = nums[i] + nums[j];
            if (sum > target) {
                j--;
            } else {
                res += j - i; // [i,j] has j-i+1 num, so has j-i pair
                i++;
            }
        }
        return res;
    }


}


