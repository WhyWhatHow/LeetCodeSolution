package leetcode.algorithm.window;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2411 {

    public static void main(String[] args) {
        Solution_2411 sol = new Solution_2411();
        System.out.println(sol.smallestSubarrays(new int[]{
                1, 0, 2, 1, 3
        }));
        System.out.println("==================");
    }


    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] f = new int[31];
        Arrays.fill(f, -1);

        for (int i = nums.length - 1; i >= 0; i--) {
            int max = 1;

            for (int j = 0; j < f.length; j++) {
                if (getBitAt(nums[i], j) == 1) { // 返回第j位对应的值.
                    f[j] = i;
                }
                if (f[j] != -1) {
                    max = Math.max(max, f[j] - i + 1);
                }
            }
            ans[i] = max;
        }
        return ans;
    }

    // 返回 第i位对应的bit值.(从右往左数)
    // example: 11,-> 1011.   num=11,i=4,-> 1
    private int getBitAt(int num, int i) {
        return (num >> i) & 1;
    }

}


