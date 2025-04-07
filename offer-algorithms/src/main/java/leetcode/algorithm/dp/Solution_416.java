package leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #dp #01backpack.
 * @author: WhyWhatHow
 **/

public class Solution_416 {

    public static void main(String[] args) {
        Solution_416 sol = new Solution_416();
        System.out.println("==================");
    }


    int[][] f;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum & 1) == 1) return false;
        sum /= 2;
        f = new int[nums.length][sum + 1];
        for (int i = 0; i < f.length; i++) {
            Arrays.fill(f[i], -1);
        }
        return dfs(nums.length - 1, sum, nums);
    }

    /**
     * dfs(i,j) means in nums range [0,i], target  == j if or not .
     */
    private boolean dfs(int i, int j, int[] nums) {
        if (i < 0) return j == 0;
        if (f[i][j] != -1) return f[i][j] == 1;
        // use nums[i]
        boolean res = false;
        if (j >=nums[i])
            res = res | dfs(i - 1, j - nums[i], nums);
        // not use nums[i]
        res = res | dfs(i - 1, j, nums);
        f[i][j] = res == true ? 1 : 0;
        return res;
    }

}


