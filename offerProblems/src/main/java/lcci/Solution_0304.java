package lcci;

import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

class MyQueue {

    Stack<Integer> start = new Stack<>();
    Stack<Integer> end = new Stack<>();

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        start.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (end.isEmpty()) {
            moveDataFromStartToEnd(start, end);
        }

        Integer pop = end.pop();
        moveDataFromStartToEnd(end, start);
        return pop;
    }

    private void moveDataFromStartToEnd(Stack<Integer> start, Stack<Integer> end) {
        while (!start.isEmpty()) {
            Integer pop = start.pop();
            end.push(pop);
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        moveDataFromStartToEnd(start, end);
        Integer peek = end.peek();
        moveDataFromStartToEnd(end, start);
        return peek;

    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return start.isEmpty();

    }
}

public class Solution_0304 {

    public static void main(String[] args) {
        Solution_0304 sol = new Solution_0304();
        System.out.println("==================");
    }
}


