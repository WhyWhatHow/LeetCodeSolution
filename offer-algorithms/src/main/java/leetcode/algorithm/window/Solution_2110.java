package leetcode.algorithm.window;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2110 {

    public static void main(String[] args) {
        Solution_2110 sol = new Solution_2110();
        System.out.println(sol.getDescentPeriods(new int[]{3, 2, 1, 4}));
        System.out.println("==================");
    }

    public long getDescentPeriods(int[] prices) {
        long cnt = 0;
        int l = 0;
        for (int r = 0; r < prices.length; r++) {

            // not qualified
            if (r > 0 && prices[r - 1] - prices[r] != 1) {
                l = r;
            }
            // count r end subArray number
            cnt += r - l + 1;
        }
        return cnt;
    }

}


