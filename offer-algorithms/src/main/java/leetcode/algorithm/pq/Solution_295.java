package leetcode.algorithm.pq;


import javax.print.attribute.standard.Media;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_295 {

    public static void main(String[] args) {
        Solution_295 sol = new Solution_295();
        System.out.println("==================");
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
        finder.addNum(4);
        System.out.println(finder.findMedian());
    }
}

class MedianFinder {

    public MedianFinder() {

    }

    PriorityQueue<Integer> minQ = new PriorityQueue<>(); //  小堆 -> 大数
    PriorityQueue<Integer> maxQ = new PriorityQueue<>((x, y) -> y - x);// 大堆 -> 小数
    // maxQ.size()> minQ.size()
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
        if (minQ.size() == maxQ.size()) {
            return (double) (minQ.peek() + maxQ.peek()) / 2.0;
        } else {
            return minQ.size() > maxQ.size() ? minQ.peek() : maxQ.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


