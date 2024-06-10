package lcci;

import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow

 **/

class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }

    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

public class Solution_0302 {

    //    ["MinStack","push","push","push","getMin","pop","getMin"]
//            [[],[0],[1],[0],[],[],[]]
//    ["MinStack","push","push","push","push","pop","getMin","pop","getMin","pop","getMin"]
//            [[],[512],[-1024],[-1024],[512],[],[],[],[],[],[]]
    public static void main(String[] args) {
        Solution_0302 sol = new Solution_0302();
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        int min = minStack.getMin();//  --> 返回 -3.
//        minStack.top();      //--> 返回 0.
        minStack.pop();
        int min2 = minStack.getMin();
        minStack.pop();
        int min1 = minStack.getMin();
        System.out.println(min + ";" + min2 + ";" + min1);
        // --> 返回 -2.

        System.out.println("==================");
    }
}


