package jianzhioffer;

import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_63 {
    /**
     * 思路:
     * 多次购买,当天卖,当天买假设每次都是在售价最低时买入,售出价最高的时候卖出.
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int temp, profit = 0;
        for (int i = 1; i < prices.length; i++) {
            temp = prices[i] - prices[i - 1];
            if (temp > 0) {
                profit += temp;
            }
        }
        return profit;
    }

    /**
     * 维护单调栈,栈中存最大差值
     *
     * @param prices
     * @return
     */
    public int maxProfit123(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int min = Integer.MAX_VALUE, max = 0, profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] - min >= profit) {
                profit = prices[i] - min;
                min = prices[i];
                stack.push(profit);
            }
        }
        int cnt = 0;
        int sum= 0 ;
        while (!stack.isEmpty() && cnt < 2) {
            Integer pop = stack.pop();
            sum += pop;
            cnt++;
        }
        return sum;

    }

    public static void main(String[] args) {
        Sol_63 sol = new Sol_63();
        int i = sol.maxProfit123(new int[]{1,2,3,4,5});
        System.out.println(i);
    }
}
