package leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #hard #dp
 * @author: WhyWhatHow
 **/

public class Solution_52 {

    public static void main(String[] args) {
        Solution_52 sol = new Solution_52();
        for (int i = 1; i < 10; i++) {
            System.out.println(sol.totalNQueens(i));
        }
        System.out.println(sol.totalNQueens(2));
        ;
        System.out.println("==================");
    }

    int res;

    public int totalNQueens(int n) {
        int[][] g = new int[n][n];
        int[] rows = new int[n];// queen's col in a row
        int[] cols = new int[n]; // queen's row number in a col
        Arrays.fill(rows, -1);
        Arrays.fill(cols, -1);
        res = 0;
        dfs(g, 0, rows, cols);
        return res;
    }

    private void dfs(int[][] g, int curRow, int[] rows, int[] cols) {
        if (curRow == rows.length) {
            res++;
            return;
        }
        // check  对角线检测.
//        if (!check(g, curRow, rows)) return;

        for (int i = 0; i < g[curRow].length; i++) {
            if (g[curRow][i] == 0 && rows[curRow] == -1 && cols[i] == -1) {
                if (check(g, curRow, i)) continue;
                rows[curRow] = i;
                g[curRow][i] = 1;
                cols[i] = curRow;
                dfs(g, curRow + 1, rows, cols);
                rows[curRow] = -1;
                g[curRow][i] = 0;
                cols[i] = -1;
            }
        }
    }

    int[] dir = new int[]{-1, 1, 1, -1, -1};

    /**
     * 判断对角线是否有queens, 有, 返回true ,没有false.
     *
     * @param g
     * @param curRow
     * @param curCol
     * @return
     */
    private boolean check(int[][] g, int curRow, int curCol) {
        int n = g.length;
        for (int i = 1; i < dir.length; i++) {
            int dx = curRow;
            int dy = curCol;
            while (true) {
                dx += dir[i - 1];
                dy += dir[i];
                if (dx < 0 || dx == n || dy < 0 || dy == n) break;
                if (g[dx][dy] == 1) return true;
            }
        }
        return false;
    }

}


