package leetcode.algorithm.prefix;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_304 {

    public static void main(String[] args) {
        Solution_304 sol = new Solution_304();
        System.out.println("==================");
    }


}

class NumMatrix {
    // set ps(i+1,j+1) means from (0,0) to (i,j) area sum .

    int[][] ps;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        ps = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 左侧 + 上侧 -  重复添加 + mat[i][j]
                ps[i + 1][j + 1] = ps[i][j + 1] + ps[i + 1][j] - ps[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = ps[row2 + 1][col2 + 1] - ps[row2 + 1][col1] - ps[row1][col2 + 1] + ps[row1][col1];
        return res;
    }
}


/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */