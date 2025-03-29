package leetcode.algorithm.graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2360 {

    public static void main(String[] args) {
        Solution_2360 sol = new Solution_2360();
        System.out.println("==================");
    }

    public int longestCycle(int[] edges) {
        int res = -1;
        int n = edges.length;
        // count indegree of node
        int[] ins = new int[n];
        for (int i : edges) {
            if (i != -1) ins[i]++;
        }


        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (ins[i] == 0) q.add(i);

        }

        // 拓扑序
        while (!q.isEmpty()) {
            Integer cur = q.remove();
            int to = edges[cur];
            if (to != -1 && --ins[to] == 0) {
                q.add(to);
            }
        }


        boolean[] vis = new boolean[n]; // every node in circle.
        for (int i = 0; i < n; i++) {
            if (ins[i] > 0 && !vis[i]) {
                // 环上一点, 如何统计呢?
                int step = 0;
                while (i != -1 && !vis[i]) {
                    vis[i] = true;
                    step++;
                    i = edges[i];
                }
                res = Math.max(res, step);
            }
        }

        return res;
    }

}


