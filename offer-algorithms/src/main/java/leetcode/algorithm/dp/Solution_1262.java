package leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1262 {

    public static void main(String[] args) {
        Solution_1262 sol = new Solution_1262();
//        [1,2,3,4,4]
        System.out.println(sol.maxSumDivThree(new int[]
                {1, 2, 3, 4, 4}
        ));
        System.out.println("==================");
    }

    int[][] f; //f[i][3] means [0,i]range maxSum % 3 ==j 的 maxValue;

    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        f = new int[n + 1][3];
        // init
        for (int i = 0; i < f.length; i++) {
            Arrays.fill(f[i], -1);
        }

        // dfs
        dfs(nums, n - 1, 0);
        return f[n - 1][0];
    }

    //set f[i][j] means [0,i) 范围内其和%3的值为j的最大值.
    // f[i][j] = max ( f[i-1][j],   // 不选择nums[i]
    //                f[i-1][j+nums[i]%3]+nums[i]) // 选择nums[i]
    private int dfs(int[] nums, int i, int j) {
//        if (i < 0) return 0;
        if (i < 0) return j == 0 ? 0 : Integer.MIN_VALUE;

        if (f[i][j] != -1) return f[i][j];
        int res = Math.max(dfs(nums, i - 1, j),
                dfs(nums, i - 1, (j + nums[i]) % 3) + nums[i]);
        f[i][j] = res;
        return res;
    }

}


