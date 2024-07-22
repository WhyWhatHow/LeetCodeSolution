package leetcode.algorithm.bfs;

import java.net.UnknownHostException;
import java.util.LinkedList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2101 {

    public static void main(String[] args) throws UnknownHostException {
        Solution_2101 sol = new Solution_2101();
        System.out.println(sol.maximumDetonation(new int[][]{
//                {1, 2, 3},
//                {2, 3, 1},
//                {3, 4, 2},
//                {4, 5, 3},
//                {5, 6, 4}
                /////////////////////////////
//                {1,1,100000},{100000,100000,1}
                //////////////////
//                {54, 95, 4},
//                {99, 46, 3},
//                {29, 21, 3},
//                {96, 72, 8},
//                {49, 43, 3},
//                {11, 20, 3},
//                {2, 57, 1},
//                {69, 51, 7},
//                {97, 1, 10},
//                {85, 45, 2},
//                {38, 47, 1},
//                {83, 75, 3},
//                {65, 59, 3},
//                {33, 4, 1},
//                {32, 10, 2},
//                {20, 97, 8},
//                {35, 37, 3}
                ////////////////
//                {2, 1, 3}, {6, 1, 4}
                ////////////////
                {656, 619, 56},
                {189, 402, 178},
                {513, 373, 276},
                {900, 510, 14},
                {188, 173, 129},
                {512, 178, 251},
                {145, 685, 47},
                {504, 355, 500},
                {554, 131, 214},
                {596, 1, 98},
                {358, 230, 197},
                {88, 758, 155},
                {72, 340, 419},
                {818, 708, 222}
        }));
        System.out.println("==================");
    }

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        int[][] g = new int[n][n];
        // init graph
        for (int i = 0; i < bombs.length; i++) {
            for (int j = 0; j < bombs.length; j++) {
                if (check(i, j, bombs)) {
                    g[i][j] = 1;
                }
            }
        }
        int res = 0;

        for (int i = 0; i < n; i++) {
            res = Math.max(res, bfs(i, g) );
        }


        return res;
    }

    private int bfs(int start, int[][] g) {
        boolean[] vis = new boolean[g.length];
        LinkedList<Integer> q = new LinkedList<>(); // int[] 1st: idx, 2nd: cnt ;
        q.add(start);
        vis[start] = true;
        int res = 1;
        while (!q.isEmpty()) {
            int idx = q.pop();

            for (int j = 0; j < g[idx].length; j++) {
                if (g[idx][j] == 1 && !vis[j]) {
                    vis[j] = true;
                    q.add(j);
                    res++;
                }
            }
        }
        return res;
    }

//    /**
//     * int[] 可以用来统计层数, 但是不要用于统计加入q的数量, 会存在数据漏算的情况.
//     * 通过边相邻的节点 , 没有考虑自己这个节点
//     *
//     * @param q
//     * @param g
//     * @return 连接的节点数量.
//     */
//    private int bfs(LinkedList<int[]> q, int[][] g, boolean[] vis) {
//        int res = 0;
//        while (!q.isEmpty()) {
//            int[] ints = q.pop();
//            int idx = ints[0];
//            int cnt = ints[1];
//
//            res = cnt;
//            for (int j = 0; j < g[idx].length; j++) {
//                if (g[idx][j] == 1 && !vis[j]) {
//                    vis[j] = true;
////                    System.out.println(j);
//                    q.add(new int[]{j, ++cnt});
//                }
//            }
//        }
//        return res;
//    }

    /**
     * i's bombs and j's bombs is connected or not.
     *
     * @param i
     * @param j
     * @param bombs
     * @return
     */
    private boolean check(int i, int j, int[][] bombs) {
        long r = bombs[i][2];
        long x = bombs[i][0] - bombs[j][0];
        long y = bombs[i][1] - bombs[j][1];
        long distance = x * x + y * y;
        if (distance > (r * r)) return false;
        return true;
    }

}


