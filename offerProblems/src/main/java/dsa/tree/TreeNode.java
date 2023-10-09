package dsa.tree;

import java.util.LinkedList;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-14 07:54
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.val);
            inorder(root.right);
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public void level(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode peek = list.peek();
            list.pop();
            if (list.isEmpty())
                System.out.println(peek.val);
            else
                System.out.print(peek.val + " , ");
            if (peek.left != null)
                list.add(peek.left);
            if (peek.right != null)
                list.add(peek.right);
        }
    }
}