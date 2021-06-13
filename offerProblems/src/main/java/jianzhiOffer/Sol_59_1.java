package jianzhiOffer;

import sun.awt.SunHints;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
class MaxQueue {
    LinkedList<Integer> list = new LinkedList<>();// 5,1,3,2
    LinkedList<Integer> maxList = new LinkedList<>(); // 5,3,2 // 保证升序, 就好, 与list 同步进行删除操作

    public MaxQueue() {

    }

    public int max_value() {
        if (maxList.isEmpty()) {
            return -1;
        }
        return maxList.getFirst();
    }

    public void push_back(int value) {
        list.addLast(value);
//        list.offer()
        if (maxList.isEmpty()) {
            maxList.addLast(value);
        } else {
            while (!maxList.isEmpty() && maxList.peekLast() < value) {// 不然的话, 尾部插入, 维持降序列表(l->r)(r->l 升序)
                maxList.removeLast();
            }
            maxList.addLast(value);
        }
    }

    public int pop_front() {
        if (list.isEmpty()) {
            return -1;
        }
        if (list.peekFirst().equals(maxList.peekFirst())) {
            maxList.pop();
        }
        return list.pop();
    }
}

public class Sol_59_1 {
    public static void main(String[] args) {
        Sol_59_1 sol = new Sol_59_1();
        System.out.println("=======");
    }
}
