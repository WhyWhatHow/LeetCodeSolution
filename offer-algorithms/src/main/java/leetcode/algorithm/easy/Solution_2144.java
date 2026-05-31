package leetcode.algorithm.easy;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_2144 {

    public static void main(String[] args) {


        Solution_2144 sol = new Solution_2144();//
        System.out.println("==================");
    }

    class Solution {
        public int minimumCost(int[] cost) {
            Arrays.sort(cost);
            int n = cost.length;
            if (n == 1)
                return cost[0];
            int all = 0;
            int cnt = n / 3;
            int i = n - 1;

            while (cnt > 0) {
                all += cost[i] + cost[i - 1];
                i -= 3;
                cnt--;
            }

            int mod = n % 3;
            while (mod-- > 0) {
                all += cost[i--];
            }

            return all;
        }
    }

}
