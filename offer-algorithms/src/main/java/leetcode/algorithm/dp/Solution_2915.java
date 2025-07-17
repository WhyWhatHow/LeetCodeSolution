package leetcode.algorithm.dp;

import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2915 {

    public static void main(String[] args) {
        Solution_2915 sol = new Solution_2915();
        System.out.println(sol.lengthOfLongestSubsequence(List.of(
//                1, 2, 3, 4, 5
//                1, 2
                        1, 3, 3, 8
                ),
//                 9 ,
                7
        ));
        System.out.println("==================");
    }


    /**
     * f[i][j] means [0,i) range , sum=j, max_count.
     * f[i][j] = max (f[i-1][j], f[i-1][j-nums[i]] + 1)
     * f[0][0] = 0 ;
     *
     * @param nums
     * @param target
     * @return
     */
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        Integer[] as = new Integer[n];
        nums.toArray(as);

        int[][] f = new int[n + 1][1001];
        for (int i = 0; i < f.length; i++) {
            Arrays.fill(f[i], -1);
        }
        dfs(n, target, as, f);
        return f[n][target] <= 0 ? -1 : f[n][target];
    }

    // 翻会[0,i) range , sum =target 的最大值.
    // f[i][t] [0,i) ,sum =t ,max_length;
    // f[i][t] = max (f[i-1][t] , f[i-1][t-nums[i-1]]+1);
    private int dfs(int i, int target, Integer[] nums, int[][] f) {
        if (i <= 0)
            return target == 0 ? 0 : -1001; // target>0 , 表示为处理完.

        if (f[i][target] != -1) return f[i][target];

        // not use i
        int res = dfs(i - 1, target, nums, f);
        int cur = nums[i - 1];

        // use i
        if (target >= cur) {
            res = Math.max(res, dfs(i - 1, target - cur, nums, f) + 1);
        }

        return f[i][target] = res;
    }
}

