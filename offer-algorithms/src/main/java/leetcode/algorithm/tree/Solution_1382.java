package leetcode.algorithm.tree;

import leetcode.algorithm.dsa.TreeNode;
import leetcode.algorithm.dsa.TreeUtils;

import java.util.ArrayList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1382 {

    public static void main(String[] args) {
        Solution_1382 sol = new Solution_1382();//
//        TreeNode root = new TreeNode();
        TreeNode node = TreeUtils.buildTree(new Integer[]{
                1, null, 2, null, 3, null, 4, null, null
        });
        sol.balanceBST(node);
        System.out.println("==================");
    }

    public TreeNode balanceBST(TreeNode root) {
        var list = new ArrayList<Integer>();
        inorder(root, list);

        return buildTree(0, list.size() - 1, list);
    }

    private TreeNode buildTree(int l, int r, ArrayList<Integer> list) {
        if (l > r) return null;
        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(list.get(mid),
                buildTree(l, mid - 1, list),
                buildTree(mid + 1, r, list));
        return node;
    }


    private void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

}
