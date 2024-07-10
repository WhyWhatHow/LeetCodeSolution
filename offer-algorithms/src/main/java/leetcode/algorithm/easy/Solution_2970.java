package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2970 {

    public static void main(String[] args) {
        Solution_2970 sol = new Solution_2970();
        System.out.println(sol.incremovableSubarrayCount(new int[]{
//                1,2,3,4
//                6,5,7,8
//                8, 7, 6, 6
                9,9,4
        }));
        ;
        System.out.println("==================");
    }

    /**
     * subArr 连续,
     *
     * @param nums
     * @return
     */
    public int incremovableSubarrayCount(int[] nums) {
        int res = 0;
        int left = 0, right = 0;

        for (; left < nums.length; left++) {
            for (right = left; right < nums.length; right++) {
                if (check(nums, left, right)) {
                    System.out.println("left: " + left + " right:" + right);
                    res++;
                }
            }
        }
        return res;
    }

    // [left,right]
    private boolean check(int[] nums, int left, int right) {
        boolean res = true;
        // 0- left-1
        for (int i = 1; i < left; i++) {
            if (nums[i] <= nums[i - 1]) {
                res = false;
                break;
            }
        }
        if (!res) return res;
        int lval = left < 1 ? 0 : nums[left - 1];
        for (int i = right + 1; i < nums.length; i++) {
            if (lval < nums[i]) {
                lval = nums[i];
            } else {
                res = false;
                break;
            }
        }
        return res;
    }


}


