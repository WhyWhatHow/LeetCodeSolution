package leetcode.algorithm.tree;

import leetcode.algorithm.dsa.TreeNode;
import leetcode.algorithm.dsa.TreeUtils;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_865 {

    public static void main(String[] args) {
        Solution_865 sol = new Solution_865();
        TreeNode node = TreeUtils.buildTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        node.level(node);
        System.out.println(sol.subtreeWithAllDeepest(node));
        System.out.println("==================");
    }


    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return root;
        int dl = getDepth(root.left);
        int dr = getDepth(root.right);
        if (dl == dr) {
            return root;
        }
        if (dl < dr) return subtreeWithAllDeepest(root.right);
        else return subtreeWithAllDeepest(root.left);
    }

    int getDepth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }


}


