package leetcode.algorithm;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_645 {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        Arrays.sort(nums);
        int[] vis = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            vis[nums[i]]++;
        }
        for (int i = 1; i < vis.length; i++) {
            if (vis[i] == 0) {
                ans[1] = i;
            }
            if (vis[i] == 2) {
                ans[0] = i;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        Solution_645 sol = new Solution_645();
        sol.findErrorNums(new int[]{
                3, 2, 3, 4, 6, 5
        });
        System.out.println("==================");
    }
}


