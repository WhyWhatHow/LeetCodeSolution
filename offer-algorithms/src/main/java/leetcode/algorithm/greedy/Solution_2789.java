package leetcode.algorithm.greedy;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_2789 {

    public static void main(String[] args) {
        Solution_2789 sol = new Solution_2789();
        System.out.println(sol.maxArrayValue(new int[]{
//                2, 3, 7, 9, 3
//                5,3,3
                56, 67, 18, 81, 95, 41, 39, 56, 63, 70, 56, 31, 84, 46, 28, 38, 27, 56, 13, 10, 58, 16, 85, 21, 63, 8
        }));
        System.out.println("==================");
    }

    /**
     * condition : nums[i]<=nums[i+1]
     * nums[i+1] = nums[i]+nums[i+1]
     *
     * @param nums
     * @return
     */
    public long maxArrayValue(int[] nums) {
//        int sum = 0 ;// 数据溢出
        long sum = 0;
        int i;

        // init i  && sum
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                break;
            }
        }

        sum = nums[i + 1];
        for (; i >= 0; i--) {
            if (nums[i] <= sum) {
                sum = nums[i] + sum;
            } else {
                sum = nums[i];
            }
        }

        return sum;
    }

}


