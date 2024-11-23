package leetcode.algorithm.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3243 {

    public static void main(String[] args) {
        Solution_3243 sol = new Solution_3243();
        System.out.println(sol.shortestDistanceAfterQueries(
//                6
                5
                , new int[][]{
//                        {1, 4}, {0, 2}
                        {2, 4}, {0, 2}, {0, 4}
                }));
        ;
        System.out.println("==================");
    }

    /**
     * f[i]  means [0,i] shortestDistance
     * f[0] = 0
     *
     * @param n
     * @param queries
     * @return
     */
//    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
//        int[] next = new int[n];
//        int res = n - 1;
//        int k = 0;
//        int[] ans = new int[queries.length];
//        for (int[] q : queries) {
//            int u = q[0], v = q[1];
//            if (next[u] < v) next[u] = v;
//            int tmp = 0;
//            // count [0,u]
//        }
//        return ans;
//    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        ArrayList<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<Integer>());
        for (int i = 1; i < n; i++) {
            g[i - 1].add(i);
        }
        int k = 0;
        int[] vis = new int[n]; // 标记节点的访问次数
        int[] res = new int[queries.length];
        for (int[] a : queries) {
            int u = a[0], v = a[1];
            g[u].add(v);
            res[k++] = bfs(g, n, vis, k + 1);
        }
        return res;
    }

    private int bfs(ArrayList<Integer>[] g, int n, int[] vis, int k) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(0);
        int cnt = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            for (int i = 0; i < size; i++) {

                Integer cur = q.poll();
                for (Integer j : g[cur]) {
                    if (j == n - 1) return cnt;
                    if (vis[j] == k) continue;
                    vis[j]++;
                    q.add(j);
                }
            }
        }

        return -1;
    }
}


