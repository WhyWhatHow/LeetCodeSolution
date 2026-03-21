package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3643 {

    public static void main(String[] args) {
        Solution_3643 sol = new Solution_3643();//
        System.out.println(sol.reverseSubmatrix(
//                new int[][]{{4, 20, 8, 20}, {2, 16, 3, 12}, {3, 12, 17, 1}, {3, 13, 2, 13}},
//                1,
//                1,
//                1)
                new int[][]{{14, 3, 18, 16}, {2, 14, 11, 20}, {19, 19, 4, 15}, {11, 15, 18, 6}},
                0,
                0,
                4
        ));
        System.out.println("==================");
    }

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int n = grid.length;
        int[] a = new int[k];
        if (k == 1) return grid;
        // x -> n-1 , x+1, -> n-1-1,
        int up = x, down =  up + k - 1;
        while (up < down) {
            //  up -> down
            for (int i = 0; i < k; i++) {
                a[i] = grid[down][y + i];
                grid[down][y + i] = grid[up] [y + i];
                grid[up][y + i] = a[i];
            }

            down--;
            up++;
        }
        return grid;
    }


}
