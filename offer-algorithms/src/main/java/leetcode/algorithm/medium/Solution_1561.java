package leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1561 {

    public static void main(String[] args) {
        Solution_1561 sol = new Solution_1561();
        System.out.println(sol.maxCoins(new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4}));
        System.out.println("==================");
    }

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int res = 0;
        int l = 0, r = piles.length - 1;

        while (l < r - 1) {
            res += piles[r - 1];
            l++;
            r -= 2;
        }
        return res;
    }

}
