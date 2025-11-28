package leetcode.algorithm.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2872 {

    public static void main(String[] args) {
        Solution_2872 sol = new Solution_2872();
        System.out.println("---" + sol.maxKDivisibleComponents(
//                7,
//                8,
                9,
                new int[][]
//                        {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}},
//                        {{0, 4}, {4, 1}, {0, 3}, {1, 2}, {0, 5}, {5, 7}, {1, 6}},
                        {{1, 5}, {5, 2}, {1, 8}, {2, 0}, {2, 6}, {1, 7}, {6, 4}, {7, 3}},
                new int[]
//                        {3, 0, 6, 1, 5, 2, 1},
//                        {2, 6, 2, 2, 2, 0, 0, 0},
                        {8, 8, 12, 12, 8, 8, 8, 8, 4},
//                3
//                7
                4
        ));
        System.out.println("==================");
    }

    // 统计入度,按照入度,从低到高进行排序.
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        // count every node  in_degree
        int[] deg = new int[n];
        if (k == 1 || edges.length == 0) return n;
//        boolean[] vis = new boolean[n];
        ArrayList<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());

        for (int[] e : edges) {
            deg[e[0]]++;
            deg[e[1]]++;
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        // add leave node to queue
        var q = new ArrayDeque<Integer>();
        for (int i = 0; i < deg.length; i++) {
            if (deg[i] == 1) q.add(i);
        }

        // init vs
        long[] vs = new long[n];
        for (int i = 0; i < vs.length; i++) {
            vs[i] = values[i];
        }
        int res = 0;
        while (!q.isEmpty()) {
            Integer i = q.poll();
            deg[i]--;
            if (vs[i] % k == 0) {
                vs[i] = 0;
                res++;
            }
            for (Integer next : g[i]) {
                if (deg[next] == 0) continue; // handled node.
                deg[next]--;
                vs[next] += vs[i];
//                values[next] += values[i];
                if (deg[next] == 1) //add leave node to queue
                    q.add(next);
            }
        }
        return res;


    }


}


