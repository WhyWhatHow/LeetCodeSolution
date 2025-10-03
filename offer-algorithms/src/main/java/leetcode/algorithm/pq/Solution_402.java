package leetcode.algorithm.pq;

import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_402 {

    public static void main(String[] args) {
        Solution_402 sol = new Solution_402();
        System.out.println(sol.trapRainWater(new int[][]{
                {1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}
        }));
        System.out.println("==================");
    }

    // 水桶理论, 最短的木块决定水量.
    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length;
        int m = heightMap[0].length;
        boolean[][] v = new boolean[n][m];
        // int[] =>{height, x,y}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // add the wall
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    pq.add(new int[]{heightMap[i][j], i, j});
                    v[i][j] = true;
                }
            }
        }

        int res = 0;
        int[] dir = new int[]{0, 1, 0, -1, 0}; //
        while (!pq.isEmpty()) {
            int[] polled = pq.poll();
            int min = polled[0], i = polled[1], j = polled[2];
            for (int k = 1; k < dir.length; k++) {
                int x = i + dir[k - 1];
                int y = j + dir[k];
                if (x < 0 || y < 0 || x >= n || y >= m || v[x][y]) continue;  // 跳过边界条件
                // check  if h[x][y] can save water.
                res += Math.max(0, min - heightMap[x][y]);

                // make h[x][y] -> unable to change.
                v[x][y] = true;
                // add to pq
                // 将当前点加入优先队列，高度为当前点与之前最低高度的较大值
                // 这样可以保证从外围向内围逐渐计算储水量时，始终以包围当前点的最低边界为准
                pq.add(new int[]{Math.max(min, heightMap[x][y]), x, y});
            }
        }
        return res;

    }
}


