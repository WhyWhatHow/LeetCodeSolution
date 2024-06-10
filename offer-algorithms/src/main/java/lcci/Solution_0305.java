package lcci;

import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow

 **/
class SortedStack {
    Stack<Integer> start = new Stack<>();
    Stack<Integer> end = new Stack<>();

    public SortedStack() {

    }

    public void push(int val) {
        if (start.isEmpty() || val <= start.peek()) {
            start.push(val);
        } else {
            moveData(start, end, val);
//            moveData(end,start);
        }
    }


    private void moveData(Stack<Integer> start, Stack<Integer> end, Integer val) {
        while (!start.isEmpty()) {
            Integer peek = start.peek();
            if (peek <= val) {
                end.push(peek);
                start.pop();
//                end.push(val);
            } else {
                break;
            }
        }
        end.push(val);
        while (!end.isEmpty()) {
            start.push(end.pop());
        }
    }

    public void pop() {
        if (start.isEmpty()) {
            return;
        }
        start.pop();
    }

    public int peek() {
        if (start.isEmpty()) {
            return -1;
        }
        return start.peek();
    }

    public boolean isEmpty() {
        return start.isEmpty();
    }
}

public class Solution_0305 {

    public static void main(String[] args) {
        Solution_0305 sol = new Solution_0305();
        SortedStack stack = new SortedStack();
        stack.push(2);
        stack.push(4);
        stack.push(1);
        int peek = stack.peek();
        stack.pop();
        int peek1 = stack.peek();
        System.out.println("==================");
    }
}


