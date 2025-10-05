package leetcode.algorithm.pq;

import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_778 {

    public static void main(String[] args) {
        Solution_778 sol = new Solution_778();
        System.out.println(sol.swimInWater(new int[][]{
                {10, 12, 4, 6}, {9, 11, 3, 5}, {1, 7, 13, 8}, {2, 0, 15, 14}
        }));
        System.out.println("==================");
    }


    // 最短路
    int[] dir = new int[]{0, 1, 1, 0, 0, -1, -1, 0};

    public int swimInWater(int[][] grid) {

        int n = grid.length;
        boolean[][] v = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // int[]=>{cost, x, y}
        pq.add(new int[]{grid[0][0], 0, 0});
//        v[0][0]

//        int res = grid[0][0];

        int res = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            int[] polled = pq.poll();
            int cur = polled[0], x = polled[1], y = polled[2];
            if (x == n - 1 && y == n - 1) {
                res = Math.min(res, cur);
//                break;
            }
            v[x][y] = true;
            for (int i = 0; i < dir.length; i += 2) {
                int xx = dir[i] + x;
                int yy = dir[i + 1] + y;
                if (xx < 0 || yy < 0 || xx >= n || yy >= n || v[xx][yy]) continue;
                int tmp = grid[xx][yy] <= cur ? cur : grid[xx][yy] ;
                pq.add(new int[]{tmp, xx, yy});
            }
        }
        return res;
    }
}


