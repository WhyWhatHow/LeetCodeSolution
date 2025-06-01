package leetcode.algorithm.bfs;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_909 {

    public static void main(String[] args) {
        Solution_909 sol = new Solution_909();
        System.out.println(sol.snakesAndLadders(new int[][]{
//                {-1, -1, -1, -1, -1, -1},
//                {-1, -1, -1, -1, -1, -1},
//                {-1, -1, -1, -1, -1, -1},
//                {-1, 35, -1, -1, 13, -1},
//                {-1, -1, -1, -1, -1, -1},
//                {-1, 15, -1, -1, -1, -1}
                ///////////////////////////////
                {-1, -1, -1, 30, -1, 144, 124, 135, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, 167, 93, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, 77, -1, -1, 90, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 122, -1},
                {-1, -1, -1, 23, -1, -1, -1, -1, -1, 155, -1, -1, -1},
                {-1, -1, 140, 29, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, 115, -1, -1, -1, 109, -1, -1, 5},
                {-1, 57, -1, 99, 121, -1, -1, 132, -1, -1, -1, -1, -1},
                {-1, 48, -1, -1, -1, 68, -1, -1, -1, -1, 31, -1, -1},
                {-1, 163, 147, -1, 77, -1, -1, 114, -1, -1, 80, -1, -1},
                {-1, -1, -1, -1, -1, 57, 28, -1, -1, 129, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, 87, -1, -1, -1}
        }));

        System.out.println("==================");
    }


    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int max = n * n;
        boolean[] vis = new boolean[max + 1];
        HashMap<Integer, int[]> map = buildGraph(n);// key : id , value : {x,y}
        LinkedList<int[]> q = new LinkedList<>();// { id,cnt}
        q.offer(new int[]{1, 0}); // 改用队列的入队方式
        vis[1] = true;

        while (!q.isEmpty()) {
            int[] a = q.poll();
            int cur = a[0], cnt = a[1];
            if (cur == max) return cnt;

            int up = Math.min(max, cur + 6);


            for (int i = cur + 1; i <= up; i++) {

                int next = i;
                int x = map.get(i)[0], y = map.get(i)[1];
                if (board[x][y] != -1) {
                    next = board[x][y];
                }
                if(vis[next]) continue; //  跳过加入节点.

                q.add(new int[]{next, cnt + 1});
                vis[next] = true;

            }
        }

        return -1;
    }

    private HashMap<Integer, int[]> buildGraph(int n) {
        int[][] g = new int[n][n];
        boolean yes = false;
        int cnt = 1;
        HashMap<Integer, int[]> map = new HashMap();
        for (int i = n - 1; i >= 0; i--) {
            if (!yes) {
                for (int j = 0; j < n; j++) {
                    g[i][j] = cnt++;
                    map.put(g[i][j], new int[]{i, j});
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    g[i][j] = cnt++;
                    map.put(g[i][j], new int[]{i, j});
                }
            }
            yes = !yes;
        }
        return map;
    }


}


