package leetcode.algorithm.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_827 {

    public static void main(String[] args) {
        Solution_827 sol = new Solution_827();
        System.out.println("==================");
        System.out.println(sol.largestIsland(new int[][]{
//                {1, 1},
//                {1, 1}

//                {0, 0},
//                {0, 1}
                {1, 0, 1},
                {0, 0, 0},
                {0, 1, 1}
        }));
    }

    int[] dir = new int[]{1, 0, -1, 0, 1};

    public int largestIsland(int[][] grid) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();// store idx's island, area of this island
        int idx = 2;

        // count each island's area
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    map.put(idx, calculateArea(grid, i, j, idx));
                    idx++;
                }
            }
        }
        // no island
        if (map.size() == 0) return 1;

        HashSet<Integer> set = new HashSet<>();// remove dup element
        // visit each water place
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                set.clear();
                if (grid[i][j] == 0) {
                    int temp = 1;
                    for (int k = 0; k < dir.length - 1; k++) {
                        int dx = dir[k] + i;
                        int dy = dir[k + 1] + j;
                        if (judge(dx, dy, grid) && grid[dx][dy] != 0 && set.add(grid[dx][dy])) {
                            temp += map.get(grid[dx][dy]);
                        }
                    }
                    res = Math.max(temp, res);
                }
            }
        }
        return res == 0 ? map.get(2) : res;
    }


    // bfs
    private Integer calculateArea(int[][] grid, int i, int j, int idx) {
        LinkedList<int[]> q = new LinkedList<>();
        int res = 0;
        q.add(new int[]{i, j});
        grid[i][j] = idx; // update
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            res++;
            for (int k = 0; k < dir.length - 1; k++) {
                int dx = dir[k] + x;
                int dy = dir[k + 1] + y;
                if (judge(dx, dy, grid) && grid[dx][dy] == 1) {
                    q.add(new int[]{dx, dy});
                    grid[dx][dy] = idx;
                }
            }
        }
        return res;

    }

    /**
     *  判断x,y 是否越界
     * @param x
     * @param y
     * @param grid
     * @return
     */
    boolean judge(int x, int y, int[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

    public int largestIsland2(int[][] grid) {
        int res = 0;
        int idx = 2;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = calArea(grid, i, j, idx);
                    map.put(idx, area);
                    idx++;
                }
            }
        }

        if (map.size() == 0) return 1;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                set.clear();
                int area = 1;
                if (grid[i][j] == 0) {
                    if (i - 1 >= 0 && grid[i - 1][j] != 0 && set.add(grid[i - 1][j])) {
                        area += map.get(grid[i - 1][j]);
                    }
                    if (i + 1 < grid.length && grid[i + 1][j] != 0 && set.add(grid[i + 1][j])) {
                        area += map.get(grid[i + 1][j]);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] != 0 && set.add(grid[i][j - 1])) {
                        area += map.get(grid[i][j - 1]);
                    }
                    if (j + 1 < grid[0].length && grid[i][j + 1] != 0 && set.add(grid[i][j + 1])) {
                        area += map.get(grid[i][j + 1]);
                    }
                    res = Math.max(res, area);
                }

            }
        }
        return res == 0 ? map.get(2) : res;
    }

    private int calArea(int[][] grid, int i, int j, int idx) {
        int res = 0;
        LinkedList<int[]> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        grid[i][j] = idx;
        q.add(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            res++;
            for (int k = 0; k < dir.length - 1; k++) {
                int dx = dir[k] + x;
                int dy = dir[k + 1] + y;
                if (dx >= 0 && dx < rows && dy >= 0 && dy < cols && grid[dx][dy] == 1) {
                    grid[dx][dy] = idx;
                    q.add(new int[]{dx, dy});
                }
            }
        }

        return res;
    }

}


