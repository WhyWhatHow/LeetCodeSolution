package leetcode.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2065 {

    public static void main(String[] args) {
        Solution_2065 sol = new Solution_2065();
        System.out.println(sol.maximalPathQuality(new int[]{
//                        0, 32, 10, 43
                        5, 10, 15, 20
                }, new int[][]{
//                        {0, 1, 10}, {1, 2, 15}, {0, 3, 10}
                        {0, 1, 10}, {1, 2, 10}, {0, 3, 10}
                },
//                49
                30
        ));
        System.out.println("==================");
    }


    /**
     * @param values
     * @param edges
     * @param maxTime
     * @return
     */
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        //init
        ArrayList<int[]>[] g = new ArrayList[n]; // int[]{to,time }
        Arrays.setAll(g, k -> new ArrayList<int[]>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], time = edge[2];
            g[u].add(new int[]{v, time});
            g[v].add(new int[]{u, time});
        }

        int curTime = 0;
        int[] vis = new int[n];
        vis[0]++;
        curVal = values[0];
        res = curVal;
        dfs(g, maxTime, values, vis, 0, curTime);

        return res;
    }

    int curVal;
    int res;

    private void dfs(ArrayList<int[]>[] g, int maxTime, int[] values, int[] vis, int start, int curTime) {

        if (curTime > maxTime) return;


        for (int[] ints : g[start]) {
            int to = ints[0];
            int time = ints[1];


            if ((curTime + time) <= maxTime) {
                if (vis[to] == 0)
                    curVal += values[to];
                vis[to]++;
                curTime += time;
                dfs(g, maxTime, values, vis, to, curTime);
                vis[to]--;
                curTime -= time;
                if (vis[to] == 0)
                    curVal -= values[to];
            }
        }
        if (curTime <= maxTime && start == 0 && vis[start] > 1) {
            res = Math.max(res, curVal);
        }
    }
}


