package leetcode.algorithm.binarysearch;

import java.util.ArrayDeque;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1970 {

    public static void main(String[] args) {
        Solution_1970 sol = new Solution_1970();
        System.out.println(sol.latestDayToCross(

                2,
                2,
                new int[][]{{1, 1}, {2, 1}, {1, 2}, {2, 2}}

        ));
        System.out.println("==================");
    }

    /**
     * hint: 题目中并没有要求要求一天只可以走一步, 那么我们可以在第k天实现动0->row的行为.
     * 枚举用户可以通过的天数,[0,len(cells)],
     *  假设用户可以在第k天通过, 那么也就是说, 用户可以在第k-1 前通过.第k+1 天是无法确定的.
     *  用户通过的天数具有单调性, --> binarysearch
     * 那么这个问题就变成了 通过binarysearch 枚举第k 天,然后 用bfs 判断 第k天是否解决这个问题.
     *
     * @param row
     * @param col
     * @param cells
     * @return
     */
    public int latestDayToCross(int row, int col, int[][] cells) {
        int dn = cells.length;// 总共的天数
        int l = 0, r = dn - 1;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(mid, genGraph(cells, mid, row, col))) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;

    }

    int[] dir = new int[]{0, 1, 0, -1, 0};

    // 判断 是否可以在第k天前到达最后一行.
    private boolean check(int k, int[][] g) {
        ArrayDeque<int[]> q = new ArrayDeque<>(); // int[] =>{x,y ,curday}
        int row = g.length;
        int col = g[0].length;
        for (int i = 0; i < g[0].length; i++) {
            if (g[0][i] == 0) q.add(new int[]{0, i});
        }
        while (!q.isEmpty()) {
            int[] a = q.poll();
            int x = a[0], y = a[1];
            if (x == row - 1) return true;

            for (int i = 1; i < dir.length; i++) {
                int xx = x + dir[i - 1];
                int yy = y + dir[i];
                if (xx < 0 || yy < 0 || xx >= row || yy >= col|| g[xx][yy] ==1 ) {
                    continue;
                }
                q.add(new int[]{xx, yy});
                g[xx][yy] = 1;
            }
        }
        return false;
    }

    int[][] genGraph(int[][] cells, int day, int row, int col) {
        int[][] g = new int[row][col];
        for (int i = 0; i <= day; i++) {
            int x = cells[i][0] - 1, y = cells[i][1] - 1;
//            g[x][y] = i + 1;
            g[x][y] = 1;
        }
        return g;
    }


}


