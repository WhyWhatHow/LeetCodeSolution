package leetcode.algorithm;

import leetcode.algorithm.bst.TreeNode;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur= root ;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur =cur.right;
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
        List<Integer> integers = sol.inorderTraversal(node);
        System.out.println(integers);
//        System.out.println( sol.isValid("()"));
    }
}

