package leetcode.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3650 {

    public static void main(String[] args) {
        Solution_3650 sol = new Solution_3650();//
        System.out.println(sol.minCost(
                4,
                new int[][]{{0, 1, 3}, {3, 1, 1}, {2, 3, 4}, {0, 2, 2}}
        ));
        System.out.println("==================");
    }

    public int minCost(int n, int[][] edges) {
        ArrayList<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<int[]>());
        // init graph
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            g[u].add(new int[]{v, w});
            g[v].add(new int[]{u, 2 * w}); // 每个 点翻转次数
        }

        int[] ds = new int[n];
        Arrays.fill(ds, Integer.MAX_VALUE);
        ds[0] = 0;
        var pq = new PriorityQueue<int[]>((a, b) -> {
            return a[1] - b[1];
        });
        pq.add(new int[]{0, 0});
        boolean[] vis = new boolean[n];
        while (!pq.isEmpty()) {
            int[] ps = pq.poll();
            int i = ps[0], v = ps[1];
            if (vis[i]) continue;
            vis[i] = true;
            for (int[] a : g[i]) {
                int to = a[0], w = a[1];
                if (!vis[to] && ds[to] > w + v) {
                    ds[to] = w + v;
                    pq.add(new int[]{to, w + v});
                }
            }
        }

        return ds[n - 1] == Integer.MAX_VALUE ? -1 : ds[n - 1];
    }

}


