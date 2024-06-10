package leetcode.algorithm.tree;

import leetcode.algorithm.dsa.TreeNode;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_106 {
    /**
     * 中序 ,后序建立二叉树
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        int in = inorder.length - 1;
        int val = postorder[postorder.length-1];
        TreeNode root = new TreeNode(val);
        while (inorder[in] != val) {
            in--;
        }
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, in),
                Arrays.copyOfRange(postorder, 0, in));
        root.right = buildTree(Arrays.copyOfRange(inorder, in+1, inorder.length),
                Arrays.copyOfRange(postorder, in, postorder.length - 1));
        return root ;
    }

    public static void main(String[] args) {
        Solution_106 sol = new Solution_106();
        TreeNode treeNode = sol.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        treeNode.inorder(treeNode);
        System.out.println("==================");
    }
}


