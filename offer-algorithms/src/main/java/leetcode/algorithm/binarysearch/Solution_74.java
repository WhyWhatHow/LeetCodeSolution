package leetcode.algorithm.binarysearch;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_74 {

    public static void main(String[] args) {
        Solution_74 sol = new Solution_74();
        System.out.println(sol.searchMatrix(new int[][]{
                {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}
        }, 3));
        System.out.println("==================");
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        int mid;
        boolean checked = false;
        while (left <= right) {
            mid = left + (right - left) / 2;
            int x = mid / n;
            int y = mid % n;
            if (matrix[x][y] == target) {
                checked = true;
                break;
            } else if (matrix[x][y] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return checked;
    }

}


