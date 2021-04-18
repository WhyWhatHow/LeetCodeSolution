package leetcode.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Solution_116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        root.next = null;

        ArrayList<Node> tempList = new ArrayList<>();

        while (!list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Node node = list.removeFirst();
                if (node.left != null) {
                    list.add(node.left);
                    tempList.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                    tempList.add(node.right);
                }
            }
            dealWithTemplist(tempList);

        }

        return root;
    }

    //  处理  一行数据
    private void dealWithTemplist(ArrayList<Node> tempList) {
        if (tempList == null || tempList.size() == 0) {
            return;
        }
        for (int i = 0; i < tempList.size() - 1; i++) {
            tempList.get(i).next = tempList.get(i + 1);
        }
        tempList.get(tempList.size() - 1).next = null;
        tempList.clear();
//         return tempList;
    }

    //    java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
//    at line 64, java.base/jdk.internal.util.Preconditions.outOfBounds
//    at line 70, java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex
//    at line 248, java.base/jdk.internal.util.Preconditions.checkIndex
//    at line 373, java.base/java.util.Objects.checkIndex
//    at line 426, java.base/java.util.ArrayList.get
//    at line 63, Solution.dealWithTemplist
//    at line 48, Solution.connect
//    at line 177, __Driver__.main
    public static void main(String[] args) {
        Solution_116 sol = new Solution_116();
        System.out.println("==================");
    }
}


