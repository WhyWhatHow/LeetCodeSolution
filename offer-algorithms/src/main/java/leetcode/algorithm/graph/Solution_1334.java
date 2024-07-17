package leetcode.algorithm.graph;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1334 {

    public static void main(String[] args) {
        Solution_1334 sol = new Solution_1334();
        System.out.println(sol.findTheCity(
                4,
                new int[][]{
                        {0, 1, 3},
                        {1, 2, 1},
                        {1, 3, 4},
                        {2, 3, 1}
                },
                4
        ));
        System.out.println("==================");
    }

    int max = Integer.MAX_VALUE / 2;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] g = new int[n][n];
        for (int[] ints : g) {
            Arrays.fill(ints, max);
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], v = Math.min(edge[2], g[x][y]);
            g[x][y] = v;
            g[y][x] = v;
        }

        // floyd
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                    }
                }
            }
        }

        int[] citys = new int[n];
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g.length; j++) {
                if (g[i][j] <= distanceThreshold) {
                    citys[i]++;
                }
            }
        }

        // find min
        int min = max;
        for (int city : citys) {
            min = Math.min(min, city);
        }
        int res = -1;
        for (int i = 0; i < citys.length; i++) {
            if (min == citys[i]) {
                res = i;
            }
        }
        return res;
    }


}


