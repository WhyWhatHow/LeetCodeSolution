package leetcode.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_1928 {

    public static void main(String[] args) {
        Solution_1928 sol = new Solution_1928();

        System.out.println("==================");
        System.out.println(sol.minCost(30, new int[][]{
                {0, 1, 10},
                {1, 2, 10},
                {2, 5, 10},
                {0, 3, 1},
                {3, 4, 10},
                {4, 5, 15},

        }, new int[]{5, 1, 2, 20, 20, 3}));
    }

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int[] cost = new int[passingFees.length];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = passingFees[0];
        int[] times = new int[cost.length];
        Arrays.fill(times, Integer.MAX_VALUE);
        times[0] = 0;

        // init graph
        List<int[]>[] graph = new ArrayList[cost.length];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }

        // init pq
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, passingFees[0]});// toCity, time, fee
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int cur = poll[0];
            int curTime = poll[1];
            int curCost = poll[2];

            for (int i = 0; i < graph[cur].size(); i++) {
                int[] arr = graph[cur].get(i);
                int next = arr[0];
                int nextTime = arr[1] + curTime;
                int nextCost = passingFees[next] + curCost;

                if (nextTime > maxTime) continue; //over time

                if (nextCost < cost[next]) { // less cost
                    cost[next] = nextCost;
                    times[next] = nextTime;
                    pq.add(new int[]{next, nextTime, nextCost});
                }

                if (nextTime < times[next]) {
                    times[next] = nextTime;
                    pq.add(new int[]{next, nextTime, nextCost});
                }

            }

        }
        return cost[cost.length - 1] == Integer.MAX_VALUE ? -1 : cost[cost.length - 1];
    }

    public int minCost2(int maxTime, int[][] edges, int[] passingFees) {

        int[] cost = new int[passingFees.length];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = passingFees[0];

        int[] times = new int[passingFees.length];
        Arrays.fill(times, Integer.MAX_VALUE);
        times[0] = 0;

        // a,b,time
        ArrayList<Edge>[] graph = initGraph(edges, cost.length);

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> (a.other - b.other));
        pq.add(new Edge(0, 0, passingFees[0]));
        // need passingFees is less

        while (!pq.isEmpty()) {
            Edge poll = pq.poll();
            int cur = poll.to;
            int curTime = poll.val;
            int curCost = poll.other; //

            if (cur == cost.length - 1) return curCost;

            for (int i = 0; i < graph[cur].size(); i++) {
                Edge nextEdge = graph[cur].get(i);
                int next = nextEdge.to;
                int nextCost = curCost + passingFees[next];
                int nextTime = nextEdge.val + curTime;

                if (nextTime > maxTime) continue; // over time

                if (cost[next] > nextCost) { // cost less
                    cost[next] = nextCost;
                    times[next] = nextTime;
                    pq.add(new Edge(next, nextTime, nextCost));
                } else if (times[next] > nextTime) { //time less
                    times[next] = nextTime;
                    pq.add(new Edge(next, nextTime, nextCost));
                }
            }
        }
        return cost[passingFees.length - 1] == Integer.MAX_VALUE ? -1 : cost[cost.length - 1];
    }

    private ArrayList<Edge>[] initGraph(int[][] edges, int n) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new Edge(edge[1], edge[2]));
            graph[edge[1]].add(new Edge(edge[0], edge[2]));
        }
        return graph;
    }

    class Edge {
        int to;
        int val;
        int other;

        public Edge(int to, int val, int other) {
            this.to = to;
            this.val = val;
            this.other = other;
        }

        public Edge(int to, int val) {
            this.to = to;
            this.val = val;
        }
    }
}


