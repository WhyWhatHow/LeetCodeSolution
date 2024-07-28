package leetcode.algorithm.easy;

import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_682 {

    public static void main(String[] args) {
        Solution_682 sol = new Solution_682();
        System.out.println("==================");
    }

    /**
     * #easy #stack
     *
     * @param operations
     * @return
     */
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String s : operations) {
            if ("D".equals(s)) {
                stack.push(stack.peek() * 2);
            } else if ("+".equals(s)) {
                Integer pop = stack.pop();
                int val = stack.peek() + pop;
                stack.push(pop);
                stack.push(val);
            } else if ("C".equals(s)) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        Integer sum = stack.stream().reduce(0, Integer::sum);
        return sum;
    }

}


