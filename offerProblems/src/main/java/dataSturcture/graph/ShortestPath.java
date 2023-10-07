package dataSturcture.graph;

import leetcode.algorithm.dsa.Edge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: 最短路径
 * @author: WhyWhatHow
 * @create: 2023-10-07 10:51
 **/
public class ShortestPath {

    public static void main(String[] args) {
        int[][] graph = {
                {0, 5, Integer.MAX_VALUE, 10},
                {Integer.MAX_VALUE, 0, 3, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 1},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };

        int[][] shortestPaths = floyd(graph);

        // 打印最短路径矩阵
        for (int i = 0; i < shortestPaths.length; i++) {
            for (int j = 0; j < shortestPaths.length; j++) {
                System.out.print(shortestPaths[i][j] + " ");
            }
            System.out.println();
        }

        // dijkstra ...///////////////
        System.out.println("///////////////////////////////////////////////////////////");
        int[][] graph2 = {
                {Integer.MAX_VALUE,5,Integer.MAX_VALUE,10},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,3,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,1},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE}
        };
        System.out.println(dijkstraEdge(graph2, 4, 0));
    }

    /**
     * 最短路径 floyd 算法 if exist node k, that dist[i][j] < dist[i][k]+dist[k][j] ,then dist[i][j]= dist[i][k]+dist[k][j]
     *
     * @param grid
     * @return
     */
    static int[][] floyd(int[][] grid) {
        int[][] dist = new int[grid.length][grid[0].length];
        // init dist array

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                }
                dist[i][j] = grid[i][j];


            }
        }
        for (int k = 0; k < dist.length; k++) {
            for (int i = 0; i < dist.length; i++) {
                for (int j = i + 1; j < dist[0].length; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        return dist;
    }

    public static int[] dijkstraEdge(int[][] grid, int n, int start) {
        int[] dist = new int[n + 1]; //
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // init graph
        ArrayList<Edge>[] graph = initGraph(grid, n);

        // init pq
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        pq.add(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge poll = pq.poll();
            int to = poll.to;
            int val = poll.val;
            if (dist[to] < val) continue;

            for (int i = 0; i < graph[to].size(); i++) {
                Edge edge = graph[to].get(i);
                int temp = edge.val + dist[to];
                if (temp < dist[edge.to]) {
                    dist[edge.to] = temp;
                    pq.add(new Edge(edge.to, temp));
                }
            }
        }
        return dist;
    }

    private static ArrayList<Edge>[] initGraph(int[][] grid, int n) {

        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == Integer.MAX_VALUE)
                    continue;
                graph[i].add(new Edge(j, grid[i][j]));
            }
        }
        return graph;
    }

}
