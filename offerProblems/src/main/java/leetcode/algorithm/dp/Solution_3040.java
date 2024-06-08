package leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #binary Indexed Array
 * @author: WhyWhatHow
 **/

public class Solution_3040 {

    public static void main(String[] args) {
        Solution_3040 sol = new Solution_3040();
        System.out.println(sol.maxOperations(new int[]{
                3, 2, 1, 2, 3, 4
        }));
        ;
        System.out.println("==================");
    }


    public int maxOperationsDP(int[] nums) {
        if (nums.length < 2) return 0;
        int n = nums.length;
        int ans = -1;

        // [start,end)
        ans = Math.max(ans, handle(2, n, nums[0] + nums[1], nums));
        ans = Math.max(ans, handle(1, n - 1, nums[0] + nums[n - 1], nums));
        ans = Math.max(ans, handle(0, n - 2, nums[n - 1] + nums[n - 2], nums));

        return ans;
    }

    /**
     * // [start,end)
     * dp[i][j] ==>[i,j] == target的最大值
     * a: dp[i][j] = dp[i+2][j] + 1  // nums[i]+nums[i+1] == target
     * b: dp[i][j] = dp[i][j-2] + 1  // nums[j]+nums[j-1] == target // j-1<0 ?
     * c: dp[i][j] = dp[i+1][j-1] +1 // nums[i]+nums[j] == target
     * dp[i][j] = max (a,b,c)
     * if j-1 <0  dp[i][j] don't exit
     * so dp[i][j]-> dp[i][j+1]
     */
    int handle(int start, int end, int target, int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];

        for (int i = end - 1; i >= start; i--) {

            for (int j = i + 1; j < end; j++) {
                if (nums[i] + nums[j] == target) {
                    dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j] + 1);
                }
                if (nums[i] + nums[i + 1] == target) {
                    dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i + 2][j + 1] + 1);
                }
                if (nums[j] + nums[j - 1] == target) {
                    dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i][j - 1] + 1);
                }
            }
        }
        return dp[start][end] + 1;
    }

    public int maxOperations(int[] nums) {
        int ans = 0;
        int n = nums.length;
        mem = new int[n + 1][n + 1];
        ans = Math.max(ans, helper(2, n - 1, nums[0] + nums[1], nums));
        ans = Math.max(ans, helper(1, n - 2, nums[0] + nums[n - 1], nums));
        ans = Math.max(ans, helper(0, n - 3, nums[n - 1] + nums[n - 2], nums));

        return ans;
    }

    // [start,end]
    private int helper(int start, int end, int target, int[] nums) {

        for (int[] ints : mem) {
            Arrays.fill(ints, -1);
        }
        return dfs(start, end, target, nums);
    }

    int[][] mem;

    /**
     * dfs(i,j) --> [i,j] 内的 ==target 的最大值
     *
     * @param start
     * @param end
     * @param target
     * @param nums
     * @return
     */
    private int dfs(int start, int end, int target, int[] nums) {
        if (start >= end) return 0;
        if (mem[start][end] != -1) return mem[start][end];
        int res = 0;
        if (nums[start] + nums[start + 1] == target)
            res = Math.max(res, dfs(start + 2, end, target, nums) + 1);
        if (nums[start] + nums[end] == target) {
            res = Math.max(res, dfs(start + 1, end - 1, target, nums) + 1);
        }
        if (nums[end - 1] + nums[end] == target) {
            res = Math.max(res, dfs(start, end - 2, target, nums) + 1);
        }
        mem[start][end] = res;
        return res;
    }

}


