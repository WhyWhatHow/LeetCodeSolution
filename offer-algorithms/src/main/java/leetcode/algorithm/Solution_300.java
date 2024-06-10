package leetcode.algorithm;

import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_300 {
    /**
     * dp[i] = max(dp[0-i-1],1)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];//dp[i] 0-i 的最长子序列
        int maxVal = 0;

        int maxLeft = Integer.MIN_VALUE;

        return dp[nums.length - 1];
    }

    public int lengthOfLISStack(int[] nums) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        if (nums.length == 0) {
            return 0;
        }
        stack.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            Integer peek = stack.peek();
            if (peek > nums[i]) {
                stack.pop();
            }
            stack.push(nums[i]);
        }
        return stack.size();

    }

    public static void main(String[] args) {
        Solution_300 sol = new Solution_300();
        int i = sol.lengthOfLISStack(new int[]{
//                10,9,2,5,3,7,101,18
                4, 10, 4, 3, 8, 9
        });
        System.out.println(i);
        System.out.println("==================");
    }
}


