package leetcode.algorithm.graph;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #hard
 * @author: WhyWhatHow
 **/

public class Solution_2959 {

    public static void main(String[] args) {
        Solution_2959 sol = new Solution_2959();
//        System.out.println(1 << 4);
        System.out.println(sol.numberOfSets(
//                3, 5,
                3, 12,
                new int[][]{
//                        {0, 1, 2},
//                        {1, 2, 10},
//                        {0, 2, 10}
                        ////
                        {1, 0, 11},
                        {1, 0, 16},
                        {0, 2, 13}
                }));
        ;
        System.out.println("==================");
    }

    /**
     * floyd + bit
     * #impotant : bit ->` position s >>i & 1 ==0 ` :use this to check
     * @param n
     * @param maxDistance
     * @param roads
     * @return
     */
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        // init graph
        int[][] g = new int[n][n];
//        int max = Integer.MAX_VALUE / 2;
        for (int[] ints : g) {
            Arrays.fill(ints, max);
        }
        for (int[] road : roads) {
            int u = road[0], v = road[1], w = Math.min(road[2], g[u][v]); // w should be the min value.
            g[u][v] = w;
            g[v][u] = w;
        }

        int res = 1; //  result
        int all = 1 << n;
        // s =1 , only chose s.bit==1. val;
        for (int s = 1; s < all; s++) {

            int[][] gg = new int[n][n];

            // init gg : new graph that only contains the node you chose.
            for (int i = 0; i < g.length; i++) {
                if (((s >> i) & 1) == 1) { // check this point chosen or not
                    for (int j = 0; j < g.length; j++) {
                        if ((s >> j & 1) == 1) {
                            gg[i][j] = g[i][j];
                        } else {
                            gg[i][j] = max;
                        }
                    }
                } else {
                    Arrays.fill(gg[i], max);
                }
            }

            // floyd
            gg = floyd(s, n, gg);
            // check
            boolean check = check(maxDistance, s, gg);
            res += check ? 1 : 0;
        }


        return res;
    }

    int max = Integer.MAX_VALUE / 2;

    private boolean check(int maxDistance, int s, int[][] gg) {
        for (int i = 0; i < gg.length; i++) {
            if ((s >> i & 1) == 0) continue;
            for (int j = 0; j < gg.length; j++) {
                if ((s >> j & 1) == 0) continue;
                if (i != j && gg[i][j] > maxDistance) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] floyd(int s, int n, int[][] gg) {
        for (int k = 0; k < n; k++) {
            if ((s >> k & 1) == 0) continue;
            for (int i = 0; i < n; i++) {
                if ((s >> i & 1) == 0) continue;
                for (int j = 0; j < n; j++) {
                    if ((s >> j & 1) == 0) continue;
                    if (i != j) {
                        gg[i][j] = Math.min(gg[i][j], gg[i][k] + gg[k][j]);
                    }
                }
            }
        }
        return gg;
    }


//    public int numberOfSetsOffical(int n, int maxDistance, int[][] roads) {
//        int[][] g = new int[n][n];
//        for (int[] row : g) {
//            Arrays.fill(row, Integer.MAX_VALUE / 2); // 防止加法溢出
//        }
//        for (int[] e : roads) {
//            int x = e[0];
//            int y = e[1];
//            int wt = e[2];
//            g[x][y] = Math.min(g[x][y], wt);
//            g[y][x] = Math.min(g[y][x], wt);
//        }
//
//        int ans = 0;
//        int[][] f = new int[n][n];
//        next:
//        for (int s = 0; s < (1 << n); s++) {
//            for (int i = 0; i < n; i++) {
//                if ((s >> i & 1) == 1) {
//                    System.arraycopy(g[i], 0, f[i], 0, n);
//                }
//            }
//
//            // Floyd 算法（只考虑在 s 中的节点）
//            for (int k = 0; k < n; k++) {
//                if ((s >> k & 1) == 0) continue;
//                for (int i = 0; i < n; i++) {
//                    if ((s >> i & 1) == 0) continue;
//                    for (int j = 0; j < n; j++) {
//                        f[i][j] = Math.min(f[i][j], f[i][k] + f[k][j]);
//                    }
//                }
//            }
//
//            // 判断保留的节点之间的最短路是否均不超过 maxDistance
//            for (int i = 0; i < n; i++) {
//                if ((s >> i & 1) == 0) continue;
//                for (int j = 0; j < i; j++) {
//                    if ((s >> j & 1) == 1 && f[i][j] > maxDistance) {
//                        continue next;
//                    }
//                }
//            }
//            ans++;
//        }
//        return ans;
//    }
}


