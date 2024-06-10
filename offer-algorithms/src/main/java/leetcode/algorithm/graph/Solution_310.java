package leetcode.algorithm.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_310 {

    public static void main(String[] args) {
        Solution_310 sol = new Solution_310();

        System.out.println("==================");
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ansList = new LinkedList<>();
        if (edges.length == 1) {
            ansList.add(edges[0][0]);
            ansList.add(edges[0][1]);
            return ansList;
        }
        // init graph and node ins
        int[] ins = new int[n];
        List<Integer>[] graph = new LinkedList[n];
        Arrays.setAll(graph, g -> new LinkedList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            graph[x].add(y);
            graph[y].add(x);
            ins[x]++;
            ins[y]++;
        }

        int remains = n;

        // init queue
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < ins.length; i++) {
            if (ins[i] == 1) q.add(i);
        }

        //
        while (remains > 2) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer poll = q.poll();
                remains--;
                for (Integer to : graph[poll]) {
                    ins[to]--;
                    if (ins[to] == 1)
                        q.add(to);
                }
            }
        }
        while (!q.isEmpty()){
            ansList.add(q.pop());
        }
        return ansList;
    }

}


