package leetcode.algorithm.hard;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2972 {

    public static void main(String[] args) {
        Solution_2972 sol = new Solution_2972();
        System.out.println(sol.incremovableSubarrayCount(new int[]{
                8, 7, 6, 6
//                1, 2, 3, 4
        }));
        System.out.println("==================");
    }

    /**
     * [0,left]'s num is strictly increasing.
     * [0, left][...] -> [0,left]
     * remove array: [left+1, n-1], left,n-1],[left-1,n-1], .... [0,n-1]
     * all =left+2;
     * [0,left] [...] [right,n-1] -> [0,left(<-)]+[n-1]]
     * remove (left, n-1)
     * remove (left, n-2)
     *
     * @param as
     * @return
     */
    public long incremovableSubarrayCount(int[] nums) {
        int left = 0;
        while (left < nums.length - 1 && nums[left] < nums[left + 1]) left++;

        if (left == nums.length - 1) return (long) nums.length * (nums.length + 1) / 2;

        long ans = left + 2; //  remove (left,n]  last elements .

        // remove (left, right)'s element.
        for (int right = nums.length - 1; right == nums.length - 1 || nums[right] < nums[right + 1]; right--) {
            while (left >= 0 && nums[left] >= nums[right]) {
                left--;
            }

                ans += left + 2;
        }
//        while (right > 0 && nums[right] > nums[right - 1]) right--;

        return ans;
    }

    /**
     * [start, end ]
     *
     * @param nums
     * @param start
     * @param end
     * @param target
     * @return
     */
    int search(int[] nums, int start, int end, int target) {
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (target <= nums[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

}


