package leetcode.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_743 {

    public static void main(String[] args) {

        Solution_743 sol = new Solution_743();
        System.out.println("==================");
        System.out.println(sol.networkDelayTime(new int[][]{
                {2, 1, 1},
                {3, 4, 1},
                {2, 3, 1}
        }, 4, 2));
    }

    public int networkDelayTime(int[][] times, int n, int start) {
        int res = -1;

//        int[][] dist = floyd(times, n, start);
//        boolean check = true;
//        for (int i = 1; i < dist[start].length; i++) {
//            if (i != start) {
//                res = Math.max(res, dist[start][i]);
//                if (dist[start][i] == Integer.MAX_VALUE) {
//                    check = false;
//                    break;
//                }
//            }
//        }
//
//        int[] dist = dijkstraGraph(times, n, start);
        int[] dist = dijkstraEdge(times, n, start);
        boolean check = true;

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                check = false;
                break;
            }
            res = Math.max(res, dist[i]);
        }
        return check ? res : -1;
    }

    int[] dijkstraEdge(int[][] times, int n, int start) {
        // init distance
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // init graph
        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            graph[time[0]].add(new Edge(time[1], time[2]));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge poll = pq.poll();
            int idx = poll.to;
            int distance = poll.val;
            if (dist[idx] < distance) continue;
            for (int i = 0; i < graph[idx].size(); i++) {
                Edge edge = graph[idx].get(i);
                int temp = distance + edge.val;
                if (temp < dist[edge.to]) {
                    dist[edge.to] = temp;
                    pq.add(new Edge(edge.to, temp));
                }
            }
        }
        return dist;
    }

    int[] dijkstraGraph(int[][] times, int n, int start) {
        // init distance
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // init graph
        int[][] graph = new int[n + 1][n + 1];
        for (int[] ints : graph) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        for (int[] time : times) {
            graph[time[0]][time[1]] = time[2];
        }

        // init pq  next edge started point and now distance.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int position = poll[0];
            int distance = poll[1];

            if (distance > dist[position]) continue;

            for (int i = 1; i < n + 1; i++) {
                if (graph[position][i] == Integer.MAX_VALUE) continue;

                int temp = graph[position][i] + distance;
                if (temp < dist[i]) {
                    dist[i] = temp;
                    pq.add(new int[]{i, dist[i]});
                }
            }
        }

        return dist;
    }

    private int[][] floyd(int[][] times, int n, int start) {
        int res = -1;
        int[][] dist = new int[n + 1][n + 1];

        // init
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < times.length; i++) {
            dist[times[i][0]][times[i][1]] = times[i][2];
        }

        // floyd
        for (int k = 1; k < dist.length; k++) {
            for (int i = 1; i < dist.length; i++) {
                for (int j = 1; j < dist.length; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        return dist;
    }


}

class Edge {
    int to;
    int val;

    public Edge(int to, int val) {
        this.to = to;
        this.val = val;
    }

}

