package jianzhiOffer.tree;

/**
 * @program: LeetCodeSolution
 * @description: 36 题需要的ds
 * @author: WhyWhatHow
 * @create: 2021-06-21 13:40
 **/
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

