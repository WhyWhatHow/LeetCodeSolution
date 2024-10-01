package leetcode.algorithm.dp;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_983 {

    public static void main(String[] args) {
        Solution_983 sol = new Solution_983();
        int i = sol.mincostTicketsByDfs(new int[]{
//                1, 4, 6, 7, 8, 20
                6, 8, 9, 18, 20, 21, 23, 25
        }, new int[]{
//                2, 7, 15
                2, 10, 41
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

    public int mincostTicketsByDfs(int[] days, int[] costs) {
        boolean[] vis = new boolean[days[days.length - 1]+1];
        for (int day : days) {
            vis[day] = true ;
        }
        return dfs(days[days.length - 1], costs,vis);
    }

    HashMap<Integer,Integer> map =new HashMap<>();
    /**
     * dfs(i) , 表示第i 天的最低花费
     * f[i] = min {
     * f[i-1]+ costs[0],
     * f[i-7] +costs[1],
     * f[i-30] +costs[30]
     * }
     *
     * @return
     */
    int dfs(int i, int[] costs, boolean[] vis) {
        if (i <= 0) return 0;
        // i  not in days
        if(!vis[i]){
//            vis[i] = true ;
            return dfs(i-1, costs,vis);
        }
        if(map.containsKey(i))return map.get(i);
        //  i in days
        int res = dfs(i - 1, costs,vis) + costs[0];
        res = Math.min(res, dfs(i - 7, costs,vis) + costs[1]);
        res = Math.min(res, dfs(i - 30, costs,vis) + costs[2]);
        map.put(i,res);
        return res;
    }
}

