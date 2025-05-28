package leetcode.algorithm.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3372 {

    public static void main(String[] args) {
        Solution_3372 sol = new Solution_3372();
        System.out.println(sol.maxTargetNodes(new int[][]{
                {0, 1},
                {0, 2},
                {2, 3},
                {2, 4}
        }, new int[][]{
                {0, 1},
                {0, 2},
                {0, 3},
                {2, 7},
                {1, 4},
                {4, 5},
                {4, 6}
        }, 2));
        System.out.println("==================");
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length;
        int m = edges2.length;
        int[] ans = new int[n + 1];

        if (k == 0) {
            Arrays.fill(ans, 1);
            return ans;
        }

        List<Integer>[] g = genGraph(edges1);
        List<Integer>[] gg = genGraph(edges2);

        for (int i = 0; i <= n; i++) {
            ans[i] += bfs(i, g, k);
        }
        int max = 0;
        for (int i = 0; i <= m; i++) {
            max = Math.max(max, bfs(i, gg, k - 1));
        }

        for (int i = 0; i < ans.length; i++) {
            ans[i] += max;
        }

        return ans;

    }

    private int bfs(int start, List<Integer>[] g, int k) {
        if (k == 0) return 1;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[g.length];
        q.add(start);
        int cnt = 1;
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer cur = q.poll();
                vis[cur] = true;
                for (Integer j : g[cur]) {
                    if (!vis[j]) {
                        q.add(j);
                        cnt++;
                    }

                }
            }
            level++;
            if (level == k) break;
        }
        return cnt;
    }

    private List<Integer>[] genGraph(int[][] es) {
        int n = es.length;
        List<Integer>[] g = new ArrayList[n + 1];
        Arrays.setAll(g, i -> new ArrayList<Integer>());
        for (int[] e : es) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        return g;
    }
}


