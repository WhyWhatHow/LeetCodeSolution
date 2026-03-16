package leetcode.algorithm.medium;

import java.util.Collections;
import java.util.TreeSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1878 {

    public static void main(String[] args) {
        Solution_1878 sol = new Solution_1878();//
        System.out.println(sol.getBiggestThree(
//                new int[][]{{7, 7, 7}}
//                new int[][]{{20, 17, 9, 13, 5, 2, 9, 1, 5}, {14, 9, 9, 9, 16, 18, 3, 4, 12}, {18, 15, 10, 20, 19, 20, 15, 12, 11}, {19, 16, 19, 18, 8, 13, 15, 14, 11}, {4, 19, 5, 2, 19, 17, 7, 2, 2}}
                new int[][]{{3, 4, 5, 1, 3}, {3, 3, 4, 2, 3}, {20, 30, 200, 40, 10}, {1, 5, 5, 4, 1}, {4, 3, 2, 2, 5}}
        ));
        System.out.println("==================");
    }

    public int[] getBiggestThree(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        var set = new TreeSet<Integer>(Collections.reverseOrder());
        int maxlen = Math.min((n + 1) / 2, (m + 1) / 2);

        for (int[] ints : grid) {
            for (int anInt : ints) {
                set.add(anInt);
            }
        }

        for (int l = maxlen; l > 1; l--) {
            int t = l - 1;

            for (int i = t; i < n - t; i++) {
                for (int j = 0; j < m - 2 * t; j++) {
//                    // check 判断是否可以构成菱形
//                    if (i - t < 0 || j + t >= m || j + 2 * t >= m || i + t >= n) continue;

                    int sum = grid[i][j] + grid[i][j + 2 * t];
                    //  <
                    for (int k = 1; k <= t; k++) {
                        sum += grid[i + k][j + k] + grid[i - k][j + k];
                    }
                    // > 从(i,j+2t) 往回走
                    for (int k = 1; k <= t; k++) {
                        sum += grid[i - k][j + 2 * t - k] + grid[i + k][j + 2 * t - k];
                    }

                    set.add(sum);
                }
            }
        }
        int[] a;
        if (set.size() >= 3) {
            a = new int[3];
        } else {
            a = new int[set.size()];
        }
        int cnt = 0;
        for (Integer i : set) {
            a[cnt++] = i;
            if (cnt >= 3) break;
        }
        return a;
    }

}
