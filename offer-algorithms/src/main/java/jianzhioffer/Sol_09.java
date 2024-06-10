package jianzhioffer;

import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/

class CQueue {
    Stack<Integer> start = new Stack<>();
    Stack<Integer> end = new Stack<>();

    public CQueue() {

    }


    public void appendTail(int value) {
        start.push(value);
    }

    public int deleteHead() {
        if (start.isEmpty()) {
            return -1;
        }
        while (!start.isEmpty()){
            Integer pop = start.pop();
            end.push(pop);
        }
        int res =  end.pop();
        while (!end.isEmpty()){
            start.push(end.pop());
        }
        return res ;
    }

}

public class Sol_09 {
    public static void main(String[] args) {
        Sol_09 sol = new Sol_09();
    }
}
