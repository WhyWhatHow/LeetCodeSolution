package dsa.tree;

import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description: 关于二叉树的一些算法
 * @author: WhyWhatHow
 * @create: 2023-10-09 15:48
 **/
public class TreeUtils {
    public static void main(String[] args) {
        //    5
        //  3, 6
        // 2, 4
        //1
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        System.out.println("============================");
        inOrderByStack(root); //1,2,3,4,5,6
        System.out.println("\n=============================");
        preOrderByStack(root); // 5,3,2,1,4,6
    }

    // 中序遍历, stack 实现
    static void inOrderByStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            // left subtree
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            // mid
            System.out.printf(root.val + " ");

            // right subtree
            root = root.right;
        }
    }

    static void preOrderByStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.printf(pop.val + " ");
            // right
            if (pop.right != null)
                stack.push(pop.right);
            if (pop.left != null)
                stack.push(pop.left);
        }
    }

}
