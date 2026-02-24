package leetcode.algorithm.tree;

import leetcode.algorithm.dsa.TreeNode;
import leetcode.algorithm.dsa.TreeUtils;

import java.util.ArrayList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1022 {

    public static void main(String[] args) {
        Solution_1022 sol = new Solution_1022();//
        TreeNode node = TreeUtils.buildTree(new Integer[]{
                1, 0, 1, 0, 1, 0, 1
        });
        System.out.println(sol.sumRootToLeaf(node));
        System.out.println("==================");
    }

    public int sumRootToLeaf(TreeNode root) {
        var list = new ArrayList<Integer>();
        preOrder(root, list, 0);
        int res = 0;
        for (Integer i : list) {
            res += i;
        }
        return res;
    }

    private void preOrder(TreeNode root, ArrayList<Integer> list, int i) {
        if (root == null) {
            return;
        }
        i = i * 2 + root.val;
//        if (root.left != null)
        preOrder(root.left, list, i);
//        if (root.right != null)
        preOrder(root.right, list, i);
        if (root.left == null && root.right == null)
            list.add(i);
    }

}
