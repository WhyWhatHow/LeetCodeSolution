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
                {1,0,1},
                {0,0,0},
                {0,1,1}
        }));
    }

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
                    if (i - 1 >= 0 && grid[i - 1][j] != 0 && set.add(grid[i - 1][j])) {
                        temp += map.get(grid[i - 1][j]);
                    }
                    if (i + 1 < grid.length && grid[i + 1][j] != 0 && set.add(grid[i + 1][j])) {
                        temp += map.get(grid[i + 1][j]);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] != 0 && set.add(grid[i][j - 1])) {
                        temp += map.get(grid[i][j - 1]);
                    }
                    if (j + 1 < grid[0].length && grid[i][j + 1] != 0 && set.add(grid[i][j + 1])) {
                        temp += map.get(grid[i][j + 1]);
                    }
                    res = Math.max(temp, res);
                }
            }
        }
        return res == 0 ? map.get(2) : res;
    }

    int[] dir = new int[]{1, 0, -1, 0, 1};

    // bfs
    private Integer calculateArea(int[][] grid, int i, int j, int idx) {
        int rows = grid.length;
        int cols = grid[0].length;
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
                if (dx >= 0 && dx < rows && dy >= 0 && dy < cols && grid[dx][dy] == 1) {
                    q.add(new int[]{dx, dy});
                    grid[dx][dy] = idx;
                }
            }
        }
        return res;

    }
}


