package leetcode.algorithm.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_684 {

    public static void main(String[] args) {
        Solution_684 sol = new Solution_684();
        boolean[][] a = new boolean[1001][1001];
        System.out.println(sol.findRedundantConnection(new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 4},
                {1, 5}
        }));
        System.out.println(a);
        System.out.println("==================");
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] in = new int[n + 1];
        HashSet<Integer>[] g = new HashSet[n + 1];
        Arrays.setAll(g, i -> new HashSet<>());
        for (int[] e : edges) {
            int from = e[0], to = e[1];
            in[from]++;
            in[to]++;
            g[from].add(to);
            g[to].add(from);
        }

        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 1; i < in.length; i++) {
            if (in[i] == 1) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (Integer i : g[poll]) {
                in[i]--;
                if (in[i] == 1) q.add(i);
            }
        }

        // remain node is circle node
        int from, to;
        for (int i = edges.length - 1; i >= 0; i--) {
            from = edges[i][0];
            to = edges[i][1];
            if (in[from] > 1 && in[to] > 1) return edges[i];
        }
        return null;
    }


}


