package leetcode.algorithm.greedy;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_122 {

    public static void main(String[] args) {
        Solution_122 sol = new Solution_122();
        System.out.println("==================");
        System.out.println(sol.maxProfit(new int[]{
//                7,1,5,3,6,4
//                1,2,3,4,5
                7,6,5,4,3,2,1
        }));;

    }

    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            int left = i, right = left + 1;
            while (left < right && right<prices.length) {
                if (prices[left] > prices[right]) break;
                right++;
                left++;
            }
            if (prices[i] < prices[left]) {
                res += prices[left] - prices[i];
                right = left;
            }
            i = left;
        }
        return res;
    }
}


