package dataSturcture.graph;

/**
 * @program: LeetCodeSolution
 * @description: 最短路径
 * @author: WhyWhatHow
 * @create: 2023-10-07 10:51
 **/
public class ShortestPath {
    class Node {
        int from, to, val;

        public Node(int from, int to, int val) {
            this.from = from;
            this.to = to;
            this.val = val;
        }
    }

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
    }

    /**
     * 最短路径 floyd 算法 if exist node k, that dist[i][j] < dist[i][k]+dist[k][j] ,then dist[i][j]= dist[i][k]+dist[k][j]
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

}
