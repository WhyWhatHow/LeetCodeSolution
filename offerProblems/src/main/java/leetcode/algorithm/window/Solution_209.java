package leetcode.algorithm.window;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_209 {

    public static void main(String[] args) {
        Solution_209 sol = new Solution_209();
        System.out.println(sol.minSubArrayLen(
//                7
                11
                , new int[]{
//                        2, 3, 1, 2, 4, 3
                        1, 1, 1, 1, 1, 1, 1, 1
                }));
        ;
        System.out.println("==================");
    }

    /**
     * 滑动窗口简单模拟
     * hint:
     *  1. 单个元素>=target
     *  2. nums.sum < target
     *  3. 其他: 存在子数组实现-> 滑动窗口实现.
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        //  排除单个元素行为
        for (int num : nums) {
            if (target <= num) {
                return 1;
            }
        }


        int res = nums.length;
        int start = 0, end = 0;
        int sum = nums[start];
        boolean supported = false;


        while (end < nums.length - 1) {
            sum += nums[++end];
            // update cnt
            while (target <= sum) {
                supported = true;
                res = Math.min(end - start + 1, res);
                sum -= nums[start++];
            }
        }

        return supported ? res : 0;
    }

}


