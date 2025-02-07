package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_59 {
    int[] dir = new int[]{0, 1, 0, -1, 0};

    public int[][] generateMatrix(int n) {
        int[][] as = new int[n][n];
        int all = n * n;
        int x = 0, y = 0;
        int cnt = 1;
        int d = 0; // cur direction
        while (all >= cnt) {
            as[x][y] = cnt++;
            int dx = dir[d] + x;
            int dy = dir[d + 1] + y;
            if (dx < 0 || dx == n || dy < 0 || dy == n || as[dx][dy] != 0) { // change direction
                d = (d + 1) % 4;
                x = dir[d] + x;
                y = dir[d + 1] + y;
            } else {
                x = dx;
                y = dy;
            }
        }
        return as;
    }


    public int[][] generateMatrixOld(int n) {
        int[][] ans = new int[n][n];
        int up = 0, down = n - 1, left = 0, right = n - 1;
        int all = n * n;
        int num = 1;
        while (num <= all) {
            for (int i = left; i <= right; i++) {
                ans[up][i] = num++;
            }
            up++;
            for (int i = up; i <= down; i++) {
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
        int[][] ints = sol.generateMatrixOld(3);
        System.out.println(sol.generateMatrix(9));
        System.out.println("==================");
    }
}


