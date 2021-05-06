package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_59 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int up = 0, down = n - 1, left = 0, right = n - 1;
        int all = n * n;
        int num = 1;
        while (num <= all) {
            for (int i = left; i <=right; i++) {
                ans[up][i] = num++;
            }
            up++;
            for (int i = up; i <=down; i++) {
                ans[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                ans[down][i] = num++;
            }
            down--;
            for (int i = down; i >= up; i--) {
                ans[i][left] = num++;
            }
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution_59 sol = new Solution_59();
        int[][] ints = sol.generateMatrix(3);

        System.out.println("==================");
    }
}


