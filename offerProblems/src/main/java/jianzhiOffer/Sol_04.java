package jianzhiOffer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 07:33
 **/
public class Sol_04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
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
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
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
            if (a[mid] == target)
                return true;
            else if (a[mid] < target) {
                left = mid;
            } else if (a[mid] > target) {
                right = mid;
            }
        }
        return false;
    }
}
