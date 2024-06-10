package jianzhioffer;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 07:33
 **/
public class Sol_04 {
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        boolean res = false;
        for (int[] ints : matrix) {
            if (ints[0] > target) {
                break;
            }
//            int i = Arrays.binarySearch(ints, target);
            int i = Arrays.binarySearch(ints, target);
            res = i >= 0;
            if (res) {
                break;
            }
        }
        return res;
    }

    public boolean Find(int target, int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        boolean res = false;
        for (int[] ints : matrix) {
            if (ints[0] > target) {
                break;
            }
//            int i = Arrays.binarySearch(ints, target);
            int i = Arrays.binarySearch(ints, target);
            res = i >= 0;
            if (res) {
                break;
            }
        }
        return res;
    }

    boolean binarySearch(int[] a, int target) {
        int left = 0, right = a.length, mid;
        while (left < right) {

            mid = left + ((right - left) / 2);
            if (a[mid] == target) {
                return true;
            } else if (a[mid] < target) {
                left = mid;
            } else if (a[mid] > target) {
                right = mid;
            }
        }
        return false;
    }

    /**
     * 设 y 为 二维数组的右上端 的值, y表示当前行的最大值, 当前列的最小值.
     * 那么 target ==y 返回true
     * target<y  当前行的前面, 不可能是y所在的列
     * target>y  当前列的下面, 不可能是y所在的行
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        boolean res = false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0, col = cols - 1;
        while (row < rows && 0<=col) {
            if (matrix[row][col] == target) {
                res = true;
                break;
            } else if (target < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30},
                {-5}
        };
        Sol_04 sol_04 = new Sol_04();
        boolean numberIn2DArray = sol_04.findNumberIn2DArray(matrix, 5);
        System.out.println(numberIn2DArray);
    }

}
