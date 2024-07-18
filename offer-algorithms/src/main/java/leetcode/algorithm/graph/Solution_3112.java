package leetcode.algorithm.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3112 {

    public static void main(String[] args) {
        Solution_3112 sol = new Solution_3112();
        System.out.println(sol.minimumTime(
//                3
//                10
                7
                , new int[][]{
//                        {0, 1, 2},
//                        {1, 2, 1},
//                        {0, 2, 4}
///////////////////////////////////////////////////////
//                        {5, 4, 3},
//                        {7, 4, 8},
//                        {2, 0, 8},
//                        {0, 5, 3},
//                        {4, 0, 8},
//                        {0, 0, 1},
//                        {6, 6, 4}
                        ////////////////
                        {1, 2, 10},
                        {5, 1, 7},
                        {2, 4, 8},
                        {4, 0, 5},
                        {4, 1, 8},
                        {4, 4, 6}
                }, new int[]{
//                        1, 1, 5
//                        13, 15, 10, 19, 11, 14, 17, 8, 13, 17
                        9, 7, 17, 15, 5, 17, 17
                }));
        ;
        System.out.println("==================");
    }

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        LinkedList<int[]>[] g = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<int[]>();
        }
        // init graph
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], v = edge[2];
            if (x != y) {
                g[x].add(new int[]{y, v});
                g[y].add(new int[]{x, v});
            }
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] polled = pq.poll();
            int from = polled[0];
            int fromVal = polled[1];
            if (fromVal > dist[from] || fromVal >= disappear[from]) continue;

            for (int[] ints : g[from]) {
                int to = ints[0];
                int toVal = ints[1];
                int distance = fromVal + toVal;
                if (distance >= disappear[to]) continue;

                if (dist[to] > distance) {
                    dist[to] = fromVal + toVal;
                    pq.add(new int[]{to, fromVal + toVal});
                }
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < disappear.length; i++) {
            if (dist[i] < disappear[i]) {
                ans[i] = dist[i];
            } else {
                ans[i] = -1;
            }
        }
        return ans;
    }

}
