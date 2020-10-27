package leetcode.algorithm;

import leetcode.algorithm.dsa.TreeNode;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_105 {
    /**
     * 前序, 中序构建二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        int val = preorder[0];
        while (index < inorder.length) {
            if (inorder[index] == val) {
                break;
            }
            index++;
        }
        int[] preLeft = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);

        root.left = buildTree(preLeft, inLeft);
//        root.right =buildTree(preRight, inRight);
        root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length),
                Arrays.copyOfRange(inorder, index + 1, inorder.length));

        return root;

    }

    private TreeNode createBTreePreandIn(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        int val = preorder[0];
        while (index < inorder.length) {
            if (inorder[index] == val) {
                break;
            }
        }
        int[] preLeft = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] preRight = Arrays.copyOfRange(preorder
                , index + 1, preorder.length);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inRight = Arrays.copyOfRange(inorder
                , index + 1, preorder.length);
        root.left = createBTreePreandIn(preLeft, inLeft);
        root.right = createBTreePreandIn(preRight, inRight);
        return root;
    }

    public static void main(String[] args) {
        Solution_105 sol = new Solution_105();
        System.out.println("==================");
    }
}


