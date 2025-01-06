package leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2274 {

    public static void main(String[] args) {
        Solution_2274 sol = new Solution_2274();
        System.out.println("==================");
    }

    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int max = special[0] - bottom;
        for (int i = 1; i < special.length; i++) {
            max = Math.max(max, special[i] - special[i - 1]-1);
        }
        max = Math.max(max, top - special[special.length - 1]);
        return max ;
    }
}
