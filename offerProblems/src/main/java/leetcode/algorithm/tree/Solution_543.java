package leetcode.algorithm.tree;

import dsa.tree.TreeNode;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_543 {

    public static void main(String[] args) {
        Solution_543 sol = new Solution_543();

        System.out.println("==================");
    }

    /**
     * 二叉树的直径为 左右子树的高度之和
     * 2
     * 1    3
     * 4 5  6 8
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null) return 0;
        maxDepth(root);
        return maxDiameter;
    }

    int maxDiameter = -1;

    int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        // 求最大宽度
        maxDiameter = Math.max(maxDiameter, left + right);

        return Math.max(left, right) + 1;
    }

}


