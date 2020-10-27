package leetcode.algorithm;

import leetcode.algorithm.dsa.TreeNode;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_124 {

    /**
     * 求二叉树中最大路净值,
     * 思路 先求子树的最大路径和,再加上当前节点进行判断,若路径和变大,则跟新,否则,则不管...
     *
     * @param root
     * @return
     */

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }

    int max = Integer.MIN_VALUE;

    int maxSum(TreeNode root) {
        if (root != null) {
            // 左子树的和,右子树的和
            int left = maxSum(root.left);
            int right = maxSum(root.right);
            left = Math.max(left, 0);// 左子树的和,若left<0,则不要左子树
            right = Math.max(right, 0);// 右子树的和
            // 保证 left>=0, right>=0;
            max = Math.max(max, left + right + root.val);//求最大值
            return Math.max(root.val, root.val + left + right);
        }
        return 0;
    }


    public static void main(String[] args) {
        Solution_124 sol = new Solution_124();
        TreeNode root = new TreeNode(-10);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(5);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int i = sol.maxPathSum(root);
        System.out.println(i);
    }



}

