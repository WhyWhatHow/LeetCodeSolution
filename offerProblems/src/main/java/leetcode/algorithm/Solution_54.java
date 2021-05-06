package leetcode.algorithm;

import javafx.print.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int n = matrix.length, m = matrix[0].length;
        int up = 0, down = n - 1, left = 0, right = m - 1;
        int all = n * m;
        int cnt = 0;
        while (cnt < all) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
                cnt++;
            }
            if (cnt>=all) {
                break;
            }
            up++;
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
                cnt++;
            }
            if (cnt>=all) {
                break;
            }
            right--;
            for (int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
                cnt++;
            }
            if (cnt>=all) {
                break;
            }
            down--;
            for (int i = down; i >= up; i--) {
                cnt++;
                list.add(matrix[i][left]);
            }
            if (cnt>=all) {
                break;
            }
            left++;
        }

        return list;
    }

    public static void main(String[] args) {
        Solution_54 sol = new Solution_54();
        List<Integer> integers = sol.spiralOrder(new int[][]{
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        });
        integers.forEach(System.out::println);
        System.out.println("==================");
    }
}


