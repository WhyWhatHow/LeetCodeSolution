package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2643 {

    public static void main(String[] args) {
        Solution_2643 sol = new Solution_2643();
        System.out.println("==================");
    }

    public int[] rowAndMaximumOnes(int[][] mat) {
        int max = 0;
        int rows = 0;
        for (int i = 0; i < mat.length; i++) {
            int cnt = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) cnt++;
            }
            if (cnt > max) {
                max = cnt;
                rows = i;
            }
        }
        return new int[]{rows, max};

    }

}


