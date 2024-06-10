package leetcode.algorithm;

import java.util.Stack;


public class Solution_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if(stack.size()==0){
                stack.push(aChar);
                continue;
            }
            Character peek = stack.peek();
            if ( ( '}' == aChar && peek == '{')
                    || (peek =='[' && aChar ==']')
                    ||(peek=='(' && aChar==')')) {
                stack.pop();
            } else {
                stack.push(aChar);
            }

        }
        return stack.size()==0;
    }

    public static void main(String[] args) {
        Solution_20 sol= new Solution_20();
        System.out.println( sol.isValid("()"));
    }
}
