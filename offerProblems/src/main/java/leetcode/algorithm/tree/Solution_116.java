package leetcode.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow

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
    public Node connect2(Node root) {
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

    public static void main(String[] args) {
        Solution_116 sol = new Solution_116();
        System.out.println("==================");
    }


    public Node connect(Node root) {
        if(root == null) return root ;
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            // two pointer, prev -> node
            Node prev = q.poll();
            handle(prev,q);

            for(int i = 1 ; i< size; i++){
                if( i == size - 1){
                    prev.next = null ;
                }
                Node node= q.poll();
                prev.next = node ;
                prev = node;
                handle(node, q);
            }
            // handle the latest node of this level
            prev.next = null ;
        }
        return root ;
    }
    // add node.left&& node.right to queue
    void handle(Node node , LinkedList<Node> q){
        if(node.left != null) {
            q.add(node.left);
        }
        if(node.right != null){
            q.add(node.right);
        }
    }
}


