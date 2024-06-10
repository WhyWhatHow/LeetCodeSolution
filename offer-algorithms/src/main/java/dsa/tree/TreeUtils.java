package dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
        System.out.println("\n----------------------------");
//        postOrderByStack(root);1,2,4,3,6,5
        List<Integer> integers = postOrderTraversal(root);
    }

    //    #TODO [whywhathow] [2023/10/10] [must]  think how it work.
    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode prev = null;

        while (current != null || !stack.isEmpty()) {
            // left
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            TreeNode peek = stack.peek();

            if (peek.right == null || peek.right == prev) {
                result.add(peek.val);
                stack.pop();
                prev = peek;
            } else {
                current = peek.right;
            }
        }

        return result;
    }

    // bfs
    private static List<List<TreeNode>> levelTravel(TreeNode root) {

        List<List<TreeNode>> list = new ArrayList<>();
        if (root == null) return list;

        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        ArrayList<TreeNode> temp = new ArrayList<>();

        temp.add(root);
        list.add(new ArrayList<>(temp));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                    temp.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                    temp.add(node.right);
                }// next level
                if (i == size - 1) {
                    list.add(new ArrayList<>(temp));
                    temp.clear();
                }
            }
        }
        return list;
    }

    // 后序遍历
    private static void postOrderByStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || stack.isEmpty()) {
            // left
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // right
            TreeNode pop = stack.pop();

            while (pop.right != null) {
                stack.push(pop.right);
                pop = pop.right;
            }
            System.out.println(pop.val);
        }
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
