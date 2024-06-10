package leetcode.algorithm.dp;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_983 {

    public static void main(String[] args) {
        Solution_983 sol = new Solution_983();
        int i = sol.mincostTickets(new int[]{
//                1, 4, 6, 7, 8, 20
                6,8,9,18,20,21,23,25
        }, new int[]{
//                2, 7, 15
                2,10,41
        });
        System.out.println(i);
        System.out.println("==================");
    }

    /**
     * dp[curDay] -> ith day min cost
     * if dp[curDay] not in days{} , dp[curDay] = dp[curDay-1]
     * else dp[curDay] = min{dp[curDay-1]+cost[0],dp[curDay-7]+cost[1],dp[curDay-30]+cost[2]}
     *
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {
        int maxDay = days[days.length - 1];
        int minDay = days[0];
        int[] dp = new int[maxDay + 31];
        int idx = 0;
        for (int i = minDay; i <= maxDay; i++) {
            if (i == days[idx]) { // travel day
//                getIDayMinCosts(costs, i, dp);
//                dp[i] = Math.min(
//                        Math.min(dp[i - 1] + costs[0], dp[Math.max(0, i - 7)] + costs[1]),
//                        dp[Math.max(0, i - 30)] + costs[2]
//                );
                int x = dp[i - 1] + costs[0];
                int y = dp[i < 7 ? 0 : i - 7] + costs[1];
                int z = dp[i < 30 ? 0 : i - 30] + costs[2];
                dp[i] = Math.min(x, Math.min(y, z));
                idx++;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[maxDay];
    }

    private void getIDayMinCosts(int[] costs, int curDay, int[] dp) {
        if (1 <= curDay) {
            dp[curDay] = Math.min(dp[curDay - 1] + costs[0], dp[curDay]);
        }
        if (7 <= curDay) {
            dp[curDay] = Math.min(dp[curDay - 7] + costs[1], dp[curDay]);
        }
        if (30 <= curDay) {
            dp[curDay] = Math.min(dp[curDay - 30] + costs[2], dp[curDay]);
        }

    }
}


