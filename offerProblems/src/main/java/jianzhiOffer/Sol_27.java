package jianzhiOffer;

import java.text.DateFormatSymbols;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_27 {
    /**
     *  根左右, -> 根右左 顺序变化
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode res = new TreeNode(0);

        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, TreeNode res) {
        if (root == null) {
            return;
        }
        res.val = root.val;
        if (root.left != null) {
            res.right = new TreeNode(0);
        }
        if (root.right != null) {
            res.left = new TreeNode(0);
        }
        dfs(root.right, res.left);
        dfs(root.left, res.right);
    }

    public static void main(String[] args) {
        Sol_27 sol = new Sol_27();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        TreeNode treeNode = sol.mirrorTree(root);

        System.out.println("=======");
    }
}
