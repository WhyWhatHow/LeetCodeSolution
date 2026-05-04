package leetcode.algorithm.matrix;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_48 {

    public static void main(String[] args) {
        Solution_48 sol = new Solution_48();//
        System.out.println("==================");
    }

    // 旋转两次, 第一次对角线小旋转.
    // 第二次 一中间列为中心旋转.
    public void rotate(int[][] matrix) {
        // rotate first
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                var tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        int n = matrix.length;
        // 中心点旋转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                var t = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = t;
            }
        }
    }


}
