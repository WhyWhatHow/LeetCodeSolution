package leetcode.algorithm;

import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/
public class Solution_739 {
    /**
     * 求比当前天气气温高的的下一天日期的差值
     *
     * @param t 每一天的问题,下标表示日期
     * @return
     */
    public int[] dailyTemperatures(int[] t) {

        int[] ans = new int[t.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < t.length; i++) {
            if (stack.size() == 0) {
                stack.push(i);
            }
            Integer peek = stack.peek();
            while (t[peek] < t[i]) {
                ans[peek] = i - peek;
                stack.pop();
                if (stack.size() == 0) {
                    break;
                }
                peek = stack.peek();
            }
            stack.push(i);
        }

        return ans;
    }


    public static void main(String[] args) {
        Solution_739 sol = new Solution_739();
        int[] temp = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = sol.dailyTemperatures2(temp);
        for (int anInt : ints) {
            System.out.println(anInt + ",");
        }

    }

    public int[] dailyTemperatures2(int[] t) {
        int[] ans = new int[t.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < t.length; i++) {
            if (i == 0) stack.push(i);
            while (!stack.empty() && t[stack.peek()] < t[i]) {
                Integer pop = stack.pop();
                ans[pop] = i - pop;
            }
            stack.push(i);
        }

        return ans;
    }
}
