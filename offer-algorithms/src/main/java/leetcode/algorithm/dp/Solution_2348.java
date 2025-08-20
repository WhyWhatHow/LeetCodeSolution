package leetcode.algorithm.dp;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2348 {

    public static void main(String[] args) {
        Solution_2348 sol = new Solution_2348();
        System.out.println(sol.zeroFilledSubarray(new int[]{0, 0, 0, 2, 0, 0}));
        System.out.println("==================");
    }

    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        long[] f = new long[n + 1];     // f[i] means that we have 0000, count number is i , the number of subarray.
        f[0] = 0;
        for (int i = 1; i < f.length; i++) {
            f[i] = f[i - 1] + i;
        }
        long res = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cnt++;
            } else {
                res += f[cnt];
                cnt = 0;
            }
        }
        if (cnt > 0) res += f[cnt];
        return res;
    }
}


