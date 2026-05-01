package leetcode.algorithm.dp;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_396 {

    public static void main(String[] args) {
        Solution_396 sol = new Solution_396();//
//        System.out.println(sol.maxRotateFunction(
//
//        );

        System.out.println("==================");
    }

    /**
     * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
     * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
     * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
     * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
     * f(0) = 0a0  + 1 a1 + 2a2 + 3a3
     * f(1) = 3a0 +  0 a1 + 1a2 + 2a3
     * f(2) = 2a0 +  3 a1 + 0a2 + 1a3
     * f(1) - f(0) = 3a0 -(a1+a2+a3)
     * f(2) - f(1) = 3a1 -(a0+a2+a3)
     * let sum = sum(a0+...+a3)
     * f(i) = f(i-1) + (n-1)*a(i-1) - (sum -a(i-1))
     *
     * @return
     */
    public int maxRotateFunction(int[] nums) {
        int res = 0;
        int sum = 0;
        int n = nums.length;
        int cnt = 0;

        // f0
        for (int i = 0; i < nums.length; i++) {
            res += cnt * nums[i];
            sum += nums[i];
            cnt++;
        }

        int f = res;
        for (int i = 1; i < n; i++) {
            f = f + (n - 1) * nums[i - 1] - (sum - nums[i - 1]);
            res = Math.max(res, f);
        }
        return res;
    }


}
