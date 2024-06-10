package leetcode.algorithm.tree;

import leetcode.algorithm.dsa.TreeNode;

import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_230 {

    public static void main(String[] args) {
        Solution_230 sol = new Solution_230();

        System.out.println("==================");
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int res = 0;
        while (root != null || !stack.isEmpty()) {

            // 遍历左子树
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if (++cnt == k) {
                res = root.val;
                break;
            }
            root = root.right;
        }
        return res;
    }

    int cnt = 0;
    int result;

    //dfs  without stack
    public int kthSmallest2(TreeNode root, int k) {
        inOrder(root, k);
        return result;
    }

    public void inOrder(TreeNode root, int k) {
        if (root == null) return;

        inOrder(root.left, k);
        if (k == ++cnt) {
            result = root.val;
            return;
        }
        inOrder(root.right, k);
    }

}


