package leetcode.algorithm.dsa;

/**
 * @program: LeetCodeSolution
 * @description: 前项星 边结构
 * @author: WhyWhatHow
 * @create: 2023-10-07 16:10
 **/
public class Edge {
    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int to;
    public int next;
    public int val;

    public Edge(int to, int next, int val) {
        this.to = to;
        this.next = next;
        this.val = val;
    }

    public Edge(int to, int val) {
        this.to = to;
        this.val = val;
    }
}
