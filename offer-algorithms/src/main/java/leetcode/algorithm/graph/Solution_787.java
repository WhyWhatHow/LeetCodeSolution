package leetcode.algorithm.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_787 {

    public static void main(String[] args) {
        Solution_787 sol = new Solution_787();

        System.out.println("==================");
        System.out.println(sol.findCheapestPrice(4, new int[][]{
                //                [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]]
//                {0, 1, 100},
//                {1, 2, 100},
//                {1, 3, 600},
//                {2, 3, 200}
/////////////////////////////////////////////////////////////
                //                0,1,1],[0,2,5],[1,2,1],[2,3,1
                {0, 1, 1},
                {0, 2, 5},
                {1, 2, 1},
                {2, 3, 1}
        }, 0, 3, 1));
//        System.out.println(sol.findCheapestPrice(5, new int[][]{
////                4,1,1],[1,2,3],[0,3,2],[0,4,10],[3,1,1],[1,4,3]
//                {4, 1, 1},
//                {1, 2, 3},
//                {0, 3, 2},
//                {0, 4, 10},
//                {3, 1, 1},
//                {1, 4, 3}
//        }, 2, 1, 1));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int res = -1;
        ArrayList<Edge>[] graph = initGraph(flights, n);

        int[][] dist = new int[n][2];
        for (int i = 0; i < dist.length; i++) {
            dist[i][0] = Integer.MAX_VALUE;
//            dist[i][1] = Integer.MAX_VALUE;
        }
        dist[src][0] = 0;
        dist[src][1] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        pq.add(new Edge(src, 0, 0));
        while (!pq.isEmpty()) {
            Edge poll = pq.poll();
            int to = poll.to;
            int val = poll.val;
            int cnt = poll.cnt;

            if (to == dst) break;

            if (cnt == k + 1) continue;

            for (int i = 0; i < graph[to].size(); i++) {
                Edge edge = graph[to].get(i);
                int temp = edge.val + val;
                if (dist[edge.to][0] > temp) {
                    dist[edge.to][0] = temp;
                    dist[edge.to][1] = cnt + 1;
//                        dist[edge.to][1] = cnt + 1;
                }
                if (temp > dist[edge.to][0] && (cnt + 1) > dist[edge.to][1]) continue;
                pq.add(new Edge(edge.to, temp, cnt + 1));

            }

        }
        if (dist[dst][0] != Integer.MAX_VALUE) return dist[dst][0];

        return res;
    }

    private ArrayList<Edge>[] initGraph(int[][] flights, int n) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            graph[flight[0]].add(new Edge(flight[1], flight[2]));
        }
        return graph;
    }

    class Edge {
        int to;
        int val;
        int cnt;

        public Edge(int to, int val, int cnt) {
            this.to = to;
            this.val = val;
            this.cnt = cnt;
        }

        public Edge(int to, int val) {
            this.to = to;
            this.val = val;
        }
    }
}


