package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_2087 {

    public static void main(String[] args) {
        Solution_2087 sol = new Solution_2087();//

        System.out.println("==================");
    }

    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int dx = homePos[0] - startPos[0];
        int dy = homePos[1] - startPos[1];
        boolean checkx = dx < 0 ? false : true;
        boolean checky = dy < 0 ? false : true;
        int res = 0;
        for (int i = 1; i <= Math.abs(dx); i++) {
            var idx = startPos[0];
            idx = checkx ? idx + i : idx - i;
            res += rowCosts[idx];
        }
        for (int i = 1; i <= Math.abs(dy); i++) {
            var idx = startPos[1];
            idx = checky ? idx + i : idx - i;
            res += colCosts[idx];
        }
        return res;

    }
}
