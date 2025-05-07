package leetcode.algorithm.pq;

import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3342 {

    public static void main(String[] args) {
        Solution_3342 sol = new Solution_3342();
        System.out.println(sol.minTimeToReach(new int[][]{
                {1, 5, 57},
                {100, 22, 51}
        }));
        System.out.println("==================");
    }

    int[] d = new int[]{1, 0, -1, 0, 1};

    public int minTimeToReach(int[][] g) {
        int res = Integer.MAX_VALUE;
        int n = g.length;
        int m = g[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        }); // int[]{x,y,cnt,time }
        q.add(new int[]{0, 0, 0, 0});

        boolean[][] vis = new boolean[g.length][g[0].length];
        while (!q.isEmpty()) {
            int[] a = q.poll();
            int x = a[0], y = a[1], cnt = a[2];
            if (x == n - 1 && y == m - 1) {
                res = Math.min(res, a[2]);
                break;
            }
            if (vis[x][y]) continue;
            vis[x][y] = true;
            for (int i = 1; i < d.length; i++) {
                int dx = d[i - 1] + x;
                int dy = d[i] + y;
                if (!check(dx, dy, g) || vis[dx][dy]) continue;
                int val = cnt < g[dx][dy] ? g[dx][dy] : cnt;
                val = (a[3] & 1) == 0 ? val + 1 : val + 2;
                q.add(new int[]{dx, dy, val, a[3] + 1});
            }
        }
        return res;
    }

    private boolean check(int dx, int dy, int[][] g) {
        int n = g.length;
        int m = g[0].length;
        if (dx < 0 || dy < 0 || dx >= n || dy >= m) return false;
        return true;
    }

}


