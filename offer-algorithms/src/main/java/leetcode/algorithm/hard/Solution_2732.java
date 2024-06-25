package leetcode.algorithm.hard;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #math
 * @author: WhyWhatHow
 **/

public class Solution_2732 {

    public static void main(String[] args) {
        Solution_2732 sol = new Solution_2732();
        System.out.println(sol.goodSubsetofBinaryMatrix(new int[][]{
                {0, 1, 1, 0}, {0, 0, 0, 1}, {1, 1, 1, 1}
        }));

        System.out.println("==================");
    }

    /**
     * hints:
     * subset's row number must be 1 or 2 .
     * if row's number = 1 , exist one row is filled by 0
     * if row's number = 2 , exist two rows xor = 1
     *
     * @param grid
     * @return
     */
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        List<Integer> resList = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;

        // if subset's row num is 1 
        for (int i = 0; i < grid.length; i++) {
            if (check(grid[i])) {
                resList.add(i);
                return resList;
            }
        }

        // row's num  is 2 
        for (int i = 0; i < grid.length; i++) {
            for (int j = i + 1; j < grid.length; j++) {
                if (check(grid[i], grid[j])) {
                    resList.add(i);
                    resList.add(j);
                    return resList;
                }
            }
        }

        return resList;
    }

    boolean check(int[] nums) {
        for (int num : nums) {
            if (num == 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param as
     * @param bs
     * @return
     */
    boolean check(int[] as, int[] bs) {
        for (int i = 0; i < as.length; i++) {
            if ((as[i] ^ bs[i]) == 0 && as[i] == 1) {
                return false;
            }
        }
        return true;
    }
}


