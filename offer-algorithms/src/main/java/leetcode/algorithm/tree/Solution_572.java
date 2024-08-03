package leetcode.algorithm.tree;

import leetcode.algorithm.dsa.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_572 {

    public static void main(String[] args) {
        Solution_572 sol = new Solution_572();
        System.out.println("==================");
    }


    /**
     * if subRoot is root's subtree,
     * subRoot == null
     * subRoot = root
     * subRoot is  root.left's subtree
     * subRoot is  root.right's subtree.
     *
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot) || isSameTree(root, subRoot);
    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) return false;
        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }


    ///////////////
    List<TreeNode> subList = new LinkedList<>();
    public boolean isSubtreeByList(TreeNode root, TreeNode subRoot) {
        // get all val == subroot.val
        in(root,subRoot);
        // check
        for (TreeNode sub : subList) {
            if (check(sub,subRoot)==true) {
                return true;
            }
        }
        return  false ;
    }


    void in(TreeNode root, TreeNode sub) {
        if (root == null) return;
        if (root.val == sub.val) {
            subList.add(root);
        }
        in(root.left, sub);
        in(root.right, sub);

    }

    boolean check(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;

        if (root.val == subRoot.val) {
            boolean res = true;
            res = res && check(root.left, subRoot.left) && check(root.right, subRoot.right);
            return res;
        }
        return false;
    }


}


