package leetcode.algorithm;

import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/
public class Solution_155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
//        System.out.println(minStack.getMin());
        minStack.pop();
//        minStack.top();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }
}

class MinStack {

    /**
     * initialize your data structure here.
     */
    Stack<Integer> mins = new Stack<Integer>();
    Stack<Integer> stack = new Stack<Integer>();

    public MinStack() {

    }

    public void push(int x) {

        if (stack.isEmpty()) {
            stack.push(x);
            mins.push(x);
            return;
        }

        Integer peek = mins.peek();
        if (peek >= x) {
            stack.push(x);
            mins.push(x);
            return ;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        Integer sp = stack.peek();

        Integer peek = mins.peek();

//        if (peek == null) {
//            stack.pop();
//            return;
//        }
        if (sp.equals(peek) ) {
            mins.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
