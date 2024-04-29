package leetcode.algorithm.demo;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_1329 {

    public static void main(String[] args) {
        Solution_1329 sol = new Solution_1329();
        int[][] arr = sol.diagonalSort(new int[][]{
                {11, 25, 66, 1, 69, 7},
                {23, 55, 17, 45, 15, 52},
                {75, 31, 36, 44, 58, 8},
                {22, 27, 33, 25, 68, 4},
                {84, 28, 14, 11, 5, 50}
        });
        System.out.println(arr);
        System.out.println("==================");

    }

    /**
     * 思路: 遍历对角线, 分为上半区以及下半部分, 然后 对对角线 数组 进行排序,然后重新填回即可
     * @param mat
     * @return
     */
    public int[][] diagonalSort(int[][] mat) {

        int l = mat.length;
        int h = mat[0].length;

        ArrayList<Integer> list = new ArrayList();
        // 上半区 mat[0][i]
        for (int i = 0; i < h; i++) {
//            list.add(mat[0][i]);
            int x = 0, y = i;
            while (y < h && x < l) {
                list.add(mat[x++][y++]);
            }
            Collections.sort(list);

            //  放回
            x = 0;
            y = i;
            int cnt = 0; //
            while (y < h && x < l) {
                mat[x++][y++] = list.get(cnt++);
            }
            list.clear();
        }

        // 下半区 mat[i][0]
        for (int i = 1; i < l; i++) {
            int x = i, y = 0;
            while (x < l && y < h) {
                list.add(mat[x++][y++]);
            }
            Collections.sort(list);
            // add to mat
            x = i;
            y = 0;
            int cnt = 0;
            while (x < l && y < h) {
                mat[x++][y++] = list.get(cnt++);
            }
            list.clear();
        }
        return mat;

    }

}


