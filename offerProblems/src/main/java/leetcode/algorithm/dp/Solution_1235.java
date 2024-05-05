package leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_1235 {

    public static void main(String[] args) {
        Solution_1235 sol = new Solution_1235();

        System.out.println(sol.jobScheduling(new int[]{
//                1, 2, 3, 4, 6
                1,1,1
        }, new int[]{
//                3, 5, 10, 6, 9
                2,3,4
        }, new int[]{
//                20, 20, 100, 70, 60
                5,6,4
        }));
        System.out.println("==================");
    }

    /**
     * dp[i] ==> 前i个job 的最大profit
     * dp[0] = 0
     * if : startTime[i]< endTime[i-1] ==>  dp[i] =dp[i-1]
     * else : dp[i] = dp[k]+profit[i-1]
     * ==> dp[i+1] = max(dp[i],dp[k]+profit[i]);
     *
     * @param startTime
     * @param endTime
     * @param profit
     * @return
     */
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        // init jobs
        int[][] jobs = new int[profit.length][];
        for (int i = 0; i < jobs.length; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> {
            return a[1] - b[1];
        });

//        dp[i] ==  前i个job的 maxProfit
        int[] dp = new int[profit.length + 1];
        dp[0] = 0;

        //  dp[i] =dp[i-1];
        // dp[i] = dp[j]+ profit[i]
        for (int i = 0; i < dp.length - 1; i++) {
            int k = search(jobs, i + 1); // [)
            dp[i + 1] = Math.max(dp[i], dp[k] + jobs[i][2]);
        }

        return dp[dp.length - 1];
    }

    //[0,end)
    private int search(int[][] jobs, int end) {
        int target = jobs[end - 1][0]; // end-1的开始时间
        int left = 0, right = end - 1;
        int mid;
//        int res = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (jobs[mid][1] <= target) {
//                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


}


