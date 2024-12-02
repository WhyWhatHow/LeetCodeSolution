package leetcode.algorithm.dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #hard #dp
 * @author: WhyWhatHow
 **/

public class Solution_51 {

    public static void main(String[] args) {
        Solution_51 sol = new Solution_51();
        List<List<String>> lists = sol.solveNQueens(4);
        System.out.println("==================");
    }

    List<List<String>> resList = new LinkedList<>();

    char DOT = '.';
    char QUEEN = 'Q';

    public List<List<String>> solveNQueens(int n) {
        char[][] g = new char[n][n];
        for (int i = 0; i < g.length; i++) {
            Arrays.fill(g[i], DOT);
        }
        int[] rows = new int[n]; // 每一行对应的列号 , 默认-1
        int[] cols = new int[n]; // 每一列对应的行号 , 默认-1
        Arrays.fill(rows, -1);
        Arrays.fill(cols, -1);
        dfs(g, 0, rows, cols);
        return resList;
    }

    private void dfs(char[][] g, int cur, int[] rows, int[] cols) {
        if (cur == g.length) {
            // append to list
            List<String> list = new LinkedList<String>();
            for (int i = 0; i < g.length; i++) {
                list.add(String.valueOf(g[i]));
            }
            resList.add(list);
            return;
        }

        for (int i = 0; i < g[cur].length; i++) {

            // check row && col
            if (g[cur][i] == DOT && rows[cur] == -1 && cols[i] == -1) {
                // check diagonal
                if (check(g, cur, i)) continue;
                g[cur][i] = QUEEN;
                rows[cur] = i;
                cols[i] = cur;
                dfs(g, cur + 1, rows, cols);
                rows[cur] = -1;
                cols[i] = -1;
                g[cur][i] = DOT;

            }
        }

    }

    int[] d = new int[]{-1, 1, 1, -1, -1}; // 对角线 移动

    /**
     * 检查对角线是否有 queen
     *
     * @param g
     * @param x
     * @param y
     * @return
     */
    private boolean check(char[][] g, int x, int y) {
        int n = g.length;
        for (int i = 1; i < d.length; i++) {
            int dx = x;
            int dy = y;
            while (true) {
                dx += d[i - 1];
                dy += d[i];
                if (dx < 0 || dy < 0 || dx == n || dy == n) break;
                if (g[dx][dy] == QUEEN) return true;
            }
        }
        return false;
    }


}


