package leetcode.algorithm.hard;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2552 {

    public static void main(String[] args) {
        Solution_2552 sol = new Solution_2552();
        System.out.println(2 % 1);
        System.out.println("==================");
    }


    public long countQuadruplets(int[] nums) {
        int n = nums.length;
        int[][] great = new int[n][n + 1];
        int[][] less = new int[n][n + 1];

        for (int k = n - 2; k >= 2; k--) {
            for (int x = 1; x <= n; x++) {
                if (x >= nums[k + 1]) {
                    great[k][x] = great[k + 1][x];
                } else
                    great[k][x] = great[k + 1][x] + 1;
            }
        }

        for (int j = 1; j < n - 2; j++) {
            for (int x = 1; x <= n; x++) {
                less[j][x] = less[j - 1][x];
                if (x > nums[j - 1])
                    less[j][x]++;
            }
        }
        long ans = 0;
        for (int j = 1; j < n - 1; j++) {
            for (int k = 2; k < n - 2; k++) {
                if (nums[j] > nums[k]) {
                    ans += less[j][nums[k]] * great[k][nums[j]];
                }
            }
        }
        return ans;
    }
}


