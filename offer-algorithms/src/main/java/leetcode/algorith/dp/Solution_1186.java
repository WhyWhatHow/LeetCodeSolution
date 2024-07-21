package leetcode.algorith.dp;

import java.net.UnknownHostException;

/**
 * @program: LeetCodeSolution
 * @description: #dp #redo
 * @author: WhyWhatHow
 **/

public class Solution_1186 {

    public static void main(String[] args) throws UnknownHostException {
        Solution_1186 sol = new Solution_1186();
        System.out.println(sol.maximumSum(new int[]{
//                1, -2, 0, 3
                -40
        }));
        ;
        System.out.println("==================");
    }

    /**
     * #dp
     * dp[i][j] ==> [...,i] range's max sum, and j == 0, means in range [0,i]  no del,  j==1 , means in range[0,i]  del one element .
     * dp[0][0] = a[0] , dp[0][1] =0;
     * dp[i][0] = max(dp[i-1][0], 0 )+arr[i];
     * dp[i][1] = max(dp[i-1][1]+arr[i], dp[i-1][0])
     *
     * @param arr
     * @return
     */
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][2];
        dp[0][0] = arr[0];
        int res = dp[0][0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], 0) + arr[i];
            dp[i][1] = Math.max(dp[i - 1][1] + arr[i], dp[i - 1][0]);
            int temp = Math.max(dp[i][0], dp[i][1]);
            res = Math.max(res, temp);
        }

        return res;

    }

}


