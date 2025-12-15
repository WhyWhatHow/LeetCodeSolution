package leetcode.algorithm.greedy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2110 {

    public static void main(String[] args) {
        Solution_2110 sol = new Solution_2110();
        System.out.println(sol.getDescentPeriods(
                new int[]{3, 2, 1, 4}
        ));
        System.out.println("==================");
    }

    public long getDescentPeriods(int[] prices) {
        long res = 0;
        int l = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i-1] - prices[i] == 1) {
                continue;
            } else {
                int t = i - l;
                res += (long) (t + 1) * t / 2;
                l = i;
            }
        }
        int t = prices.length - l;
        res += (long) t * (t + 1) / 2;
        return res;
    }
}


