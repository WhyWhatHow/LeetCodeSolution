package jianzhiOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_41 {
    public static void main(String[] args) {
        Sol_41 sol = new Sol_41();
        MedianFinder temp = new MedianFinder();
        temp.addNum(1);
        temp.addNum(6);
        double median = temp.findMedian();
        System.out.println(median);
        temp.addNum(7);
        temp.addNum(9);

//        for (int i = 0; i < 10; i++) {
//            temp.minQ.add(i);
//            temp.maxQ.add(i);
//        }
        System.out.print(temp.minQ.peek() + ".");
        System.out.println(temp.maxQ.peek());
        double median1 = temp.findMedian();

        System.out.println("=======");
    }
}

class MedianFinder {
    /**
     * 思路 : 两个堆,
     *  大顶堆(求最大值,)-> 用来放小数字,
     *  小顶堆(求堆中最小值) -> 放大数字.
     *
     */
    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    PriorityQueue<Integer> minQ = new PriorityQueue<>(25000);// 小顶堆,放大数
    PriorityQueue<Integer> maxQ = new PriorityQueue<>(25000, (x, y) -> {
        return y - x;
    });// 大顶堆, 放数值小的

    public void addNum(int num) {

        if (minQ.size() == maxQ.size()) {
            minQ.add(num);
            maxQ.add(minQ.poll());
        } else {
            maxQ.add(num);
            minQ.add(maxQ.poll());
        }
    }

    public double findMedian() {
        return maxQ.size() == minQ.size() ? (minQ.peek() + maxQ.peek()) / 2.0 : maxQ.peek();
    }
}

