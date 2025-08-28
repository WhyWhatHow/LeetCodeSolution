package leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3446 {

    public static void main(String[] args) {
        Solution_3446 sol = new Solution_3446();
        System.out.println(sol.sortMatrix(new int[][]{
                {1, 7, 3}, {9, 8, 2}, {4, 5, 6}
        }));
        System.out.println("==================");
    }

    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        ArrayList<Integer> list = new ArrayList<>();
        // 右上
        for (int i = 1; i < n; i++) {
            // x+1, y+1,
            int x = 0;
            int y = i;
            while (y < n) {
                list.add(grid[x++][y++]);
            }
            list.sort(Integer::compareTo);
            x = 0;
            y = i;
            int cnt = 0;
            while (y < n) {
                grid[x++][y++] = list.get(cnt++);

            }
            list.clear();
        }

        // 左下
        for (int i = 0; i < n; i++) {
            int x = i;
            int y = 0;
            while (x < n) {
                list.add(grid[x++][y++]);
            }
            list.sort(Collections.reverseOrder());
            x = i;
            y = 0;
            int cnt = 0;
            while (x < n) {
                grid[x++][y++] = list.get(cnt++);
            }
            list.clear();
        }
        return grid;
    }

}


