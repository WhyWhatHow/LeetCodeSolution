package leetcode.algorithm.easy;

import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_119 {

    public static void main(String[] args) {
        Solution_119 sol = new Solution_119();
        sol.getRow(3);
        System.out.println("==================");
    }

    public List<Integer> getRow(int rowIndex) {
        int[][] g = new int[rowIndex+1][rowIndex+1];
        for (int i = 0; i < g.length; i++) {
            g[i][0] = 1;
        }
        for (int i = 1; i <=rowIndex; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == i) g[i][j] = 1;
                else g[i][j] = g[i - 1][j - 1] + g[i - 1][j];
            }
        }
        return Arrays.stream(g[rowIndex]).boxed().toList();
    }

}
