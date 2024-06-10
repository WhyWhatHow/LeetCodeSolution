package leetcode.algorithm.dp;



/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_264 {

    public static void main(String[] args) {
        Solution_264 sol = new Solution_264();
        System.out.println("==================");
        System.out.println(sol.nthUglyNumber(11));


    }

    // dp
    public int nthUglyNumber(int n) {
        int a = 2, b = 3, c = 5;
        int[] dp = new int[n];
        dp[0] = 1;
        int aa = 0, bb = 0, cc = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(a * dp[aa], b * dp[bb]), c * dp[cc]);
            if (a * dp[aa] == dp[i]) aa++;
            if (b * dp[bb] == dp[i]) bb++;
            if (c * dp[cc] == dp[i]) cc++;
        }
        return dp[n - 1];
    }
}



