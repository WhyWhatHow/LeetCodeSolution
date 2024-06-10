package leetcode.algorithm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_207 {

    public static void main(String[] args) {
        Solution_207 sol = new Solution_207();

        System.out.println("==================");
//        System.out.println(sol.canFinish(2, new int[][]{
//                {0,1}
//        }));
        System.out.println(sol.canFinish(2, new int[][]{
                {0, 1},
                {1, 0}
        }));
        ;
    }

    // bfs
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        // init graph
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] arr : prerequisites) {
            in[arr[0]]++;
            graph[arr[1]].add(arr[0]);
        }

        // init queue
        LinkedList<Integer> q = new LinkedList();
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                q.add(i);
            }
        }
        if (q.isEmpty()) return false;
        while (!q.isEmpty()) {
            Integer cur = q.poll();

            for (Integer to : graph[cur]) {
                in[to]--;
                if (in[to] == 0)
                    q.add(to);
            }
        }
        return allZero(in);
    }

    private boolean allZero(int[] in) {
        for (int i : in) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

}


