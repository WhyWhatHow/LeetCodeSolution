package leetcode.algorithm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_210 {

    public static void main(String[] args) {
        Solution_210 sol = new Solution_210();

        System.out.println("==================");
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        int[] in = new int[numCourses];

        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // init graph
        for (int[] arr : prerequisites) {
            in[arr[0]]++;
            graph[arr[1]].add(arr[0]);
        }

        int cnt = 0;
        // init queue
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            Integer cur = q.poll();
            ans[cnt++] = cur;
            for (Integer to : graph[cur]) {
                in[to]--;
                if (in[to] == 0)
                    q.add(to);
            }
        }

        return check(in)?ans:new int[]{};

    }

    boolean check(int[] in) {
        for (int i : in) {
            if (i != 0) return false;
        }
        return true;
    }
}


