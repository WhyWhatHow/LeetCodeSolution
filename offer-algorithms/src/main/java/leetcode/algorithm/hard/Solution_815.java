package leetcode.algorithm.hard;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_815 {

    public static void main(String[] args) {
        Solution_815 sol = new Solution_815();
        System.out.println(sol.numBusesToDestination(new int[][]{
                        {1, 2, 7}, {3, 6, 7}
                },
                1, 6
        ));
        System.out.println("==================");
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] vis = new boolean[routes.length];

        // add first element. 
        for (int i = 0; i < routes.length; i++) {
            for (int el : routes[i]) {
                if (el == source) {
                    q.add(new int[]{i, 1});
                    vis[i] = true;
                    break;
                }
            }
        }
        boolean checked = false;

        while (!q.isEmpty()) {
            int[] polled = q.poll();
            int val = polled[1];
            int idx = polled[0];
            for (int tar : routes[idx]) {
                if (tar == target) {
                    return val;
                }
            }
            for (int tar : routes[idx]) {
                for (int i = 0; i < routes.length; i++) {
                    if (vis[i]) continue;
                    for (int e : routes[i]) {
                        if (tar == e) {
                            q.add(new int[]{i, val + 1});
                            vis[i] = true;
                            break;
                        }
                    }
                }
            }

        }
        return -1;
    }


}


