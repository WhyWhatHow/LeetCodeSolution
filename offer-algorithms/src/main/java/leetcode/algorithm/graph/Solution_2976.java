package leetcode.algorithm.graph;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_2976 {

    public static void main(String[] args) {
        Solution_2976 sol = new Solution_2976();//
        System.out.println("==================");
    }

    /**
     * original[i]-> changed[i]  做单向图,权重cost[i] , 多源最短路径 .
     */
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        char[] cs = source.toCharArray();
        char[] ts = target.toCharArray();
        char a = 'a';
        long inf = Long.MAX_VALUE / 2;

        // init g
        long[][] g = new long[26][26];
        for (int i = 0; i < g.length; i++) {
            Arrays.fill(g[i], inf);
            g[i][i] = 0;
        }
        int n = cost.length;
        for (int i = 0; i < n; i++) {
            int o = original[i] - a;
            int c = changed[i] - a;
            g[o][c] = Math.min(g[o][c], cost[i]);
        }

        var dist = floyd(g);
//        floyd(g);
        // a->b 的最短路.

        long res = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == ts[i]) continue;
            else {
                int from = cs[i] - a;
                int to = ts[i] - a;
                if (dist[from][to] == inf) return -1;
                else res += dist[from][to];
            }
        }
        return res;
    }

    // a->b 之间, 存在c 使得 a->c->b 的cost < a->b的cost 更新即可.
//    private void floyd(long[][] g) {
//        int n = g.length;
//        for (int k = 0; k < n; k++) {
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
//                }
//            }
//        }
//    }
    // a->b 之间, 存在c 使得 a->c->b 的cost < a->b的cost 更新即可.
    private long[][] floyd(long[][] g) {

        int n = g.length;
        long[][] dist = g.clone();

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        return dist;
    }


}


