package leetcode.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2359 {

    public static void main(String[] args) {
        Solution_2359 sol = new Solution_2359();
        System.out.println(sol.closestMeetingNode(new int[]{
//                2, 2, 3, -1
                4,4,8,-1,9,8,4,4,1,1
        },
//                0, 1
                5,6
        ));
        System.out.println("==================");
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        List<Integer>[] g = genGraph(edges);
        int[] d = handle(g, node1);

        int[] dd = handle(g, node2);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            else return a[0] - b[0];
        });// {idx, d[i]+dd[i]}
        for (int i = 0; i < d.length; i++) {
            if (dd[i] == -1 || d[i] == -1) continue;

            pq.add(new int[]{i, Math.max(d[i],dd[i])});

        }
        return pq.isEmpty() ? -1 : pq.poll()[0];
    }

    private int[] handle(List<Integer>[] g, int start) {
        int n = g.length;
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[start] = 0;

        ArrayList<int[]> q = new ArrayList<>();
        q.add(new int[]{start, 0});
        boolean[] vis = new boolean[n];

        while (!q.isEmpty()) {
            int[] a = q.removeFirst();
            vis[a[0]] = true;
            dist[a[0]] = a[1];
            for (Integer i : g[a[0]]) {
                if (vis[i]) continue;
                q.add(new int[]{i, a[1] + 1});
            }
        }
        return dist;

    }

    private List<Integer>[] genGraph(int[] edges) {
        List<Integer>[] g = new ArrayList[edges.length];
        int n = edges.length;
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] == -1) continue;
            g[i].add(edges[i]);
        }
        return g;
    }


}


