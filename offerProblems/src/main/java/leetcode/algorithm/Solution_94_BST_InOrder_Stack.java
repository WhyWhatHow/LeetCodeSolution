package leetcode.algorithm;

import leetcode.algorithm.dsa.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/
public class Solution_94_BST_InOrder_Stack {
    /**
     *   递归的本质是栈 ...
     *   中序遍历的顺序是 : 左右根.
     *    利用 stack 实现就是, 无限的压榨 左子树,  意思是把所有的树想象成 / 这种树, 这样就可以利用stack 进行 压栈操作,保证中序遍历的正确性
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
          //1 .处理左子树 inorder(cur.left)
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            // 2 . 处理节点值 sout(cur.val)
            list.add(cur.val);
            // 3 , 处理右子树  inorder(cur.right)
            cur = cur.right;
        }
        return list;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

    public static void main(String[] args) {
        Solution_94_BST_InOrder_Stack sol = new Solution_94_BST_InOrder_Stack();
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        List<Integer> integers = sol.inorderTraversal1(node);
        System.out.println(integers);
//        System.out.println( sol.isValid("()"));
    }
}

