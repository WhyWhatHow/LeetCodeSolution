package leetcode.algorithm.demo;

import leetcode.algorithm.dsa.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_114 {

    public static void main(String[] args) {
        Solution_114 sol = new Solution_114();
        System.out.println("==================");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        sol.flatten1(root);
        System.out.println(root);
        root.level(root);
    }


    // lmr preOrder
    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        // add left subtree to right
        TreeNode rr = root.right;
        root.right = root.left;
        root.left = null;
        // handle left subtree:
        flatten1(root.right); // left subtree
        flatten1(rr); // right subtree

        // goto the end of the left tree(cause we already move the left subtree to the right subtree.
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        // add right subtree to right
        p.right =rr;

    }

    List<TreeNode> list = new LinkedList<TreeNode>();

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node = new TreeNode();
        preOrder(root);
        for (TreeNode t : list) {
            node.right = t;
            node = node.right;
            node.left = null;
        }
        root = list.get(0);
        root.level(root);
    }

    void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }
}


