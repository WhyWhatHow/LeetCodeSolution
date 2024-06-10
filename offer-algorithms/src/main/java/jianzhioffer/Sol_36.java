package jianzhioffer;

import jianzhioffer.tree.Node;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/


public class Sol_36 {

    Node p = null;

    /**
     * 将二叉搜索树 转化成有序链表
     * 思路: 中序遍历,left,root,right
     *
     * @param root
     * @return
     */

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        Node head = new Node(0);
        p = head;
        inOrder(root);
        p.right = head.right;// 尾结点指向头结点
        head.right.left = p;// 头结点指向尾结点
        return head.right;
    }

    /**
     * 中序遍历. 左跟右
     *
     * @param root
     * @param p
     */
    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);

        root.left = p;// 头结点的话 root.left==head
        p.right = root;
        p = p.right;

        inOrder(root.right);
    }

    public Node inorderSuccessor(Node root, Node x) {
        if (root == null) {
            return null;
        }
        if (root.val <= x.val) {
            return inorderSuccessor(root.right, x);
        } else {
            Node node = inorderSuccessor(root.left, x);
            return node == null ? root : node;
        }
    }

    public static void main(String[] args) {
        Sol_36 sol = new Sol_36();
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        System.out.println(root);
        Node node = sol.treeToDoublyList(root);
        System.out.println(node);
        System.out.println("=======");
    }
}
