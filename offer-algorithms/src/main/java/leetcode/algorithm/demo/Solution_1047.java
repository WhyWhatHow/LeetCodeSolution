package leetcode.algorithm.demo;

import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_1047 {

    public static void main(String[] args) {
        Solution_1047 sol = new Solution_1047();
        System.out.println("==================");
        String abbacc = sol.removeDuplicates("abbaca");

    }

    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            boolean change = false;
            while (!stack.empty() && stack.peek() == c) {
                stack.pop();
                change = true;
            }
            if (!change) {
                stack.push(c);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.empty()){
            builder.append( stack.pop());
        }
        return builder.reverse().toString();
    }
}


