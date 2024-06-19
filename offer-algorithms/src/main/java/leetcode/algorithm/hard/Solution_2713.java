package leetcode.algorithm.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #dp
 * @author: WhyWhatHow
 **/

public class Solution_2713 {

    public static void main(String[] args) {
        Solution_2713 sol = new Solution_2713();
        System.out.println(sol.maxIncreasingCells(new int[][]{
//                {3, 1}, {3, 4}
                {1, -8}, {4, 4}, {-3, -9}
        }));
        System.out.println("==================");
    }

    /**
     * 设 f[i][j] 为(i,j)坐标 严格递增 的最大单元格数
     * f[i][j] =
     * row: max(f[i'][j])+1 ;  mat[i'][j] < mat[i][j]
     * col: max(f[i][j'])+1 ;  mat[i][j'] < mat[i][j]
     *
     * @param mat
     * @return
     */
    public int maxIncreasingCells(int[][] mat) {
        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
        int n = mat.length, m = mat[0].length;

        int[] rows = new int[n];
        int[] cols = new int[m];
        int[][] f = new int[n][m];
        // init
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.putIfAbsent(mat[i][j], new ArrayList<>());
                map.get(mat[i][j]).add(new int[]{i, j});

            }
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        for (Integer key : keys) {
            ArrayList<int[]> list = map.get(key);
            ArrayList<Integer> resList = new ArrayList<>(); // save f[x][y]
            for (int[] ints : list) {
                int x = ints[0], y = ints[1];
                resList.add(Math.max(rows[x], cols[y]) + 1);
            }

            // update rows and cols
            for (int i = 0; i < list.size(); i++) {
                Integer val = resList.get(i);
                int[] ints = list.get(i);
                int x = ints[0], y = ints[1];
                rows[x] = Math.max(rows[x], val);
                cols[y] = Math.max(cols[y], val);
            }
        }


        int res = 0;
        for (int row : rows) {
            res = Math.max(res, row);
        }
        return res;
    }

}


