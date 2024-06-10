package leetcode.algorithm.tree;

import leetcode.algorithm.dsa.TreeNode;

import java.util.ArrayList;
import java.util.List;


public class Solution_98 {
    boolean res = true;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int first, second;
        boolean res = true;
        for (int i = 1; i < list.size(); i++) {
            first = list.get(i - 1);
            second = list.get(i);
            if (first >= second) {
                res = false;
                break;
            }
        }
        return res;
    }

    void inOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }

    void check(TreeNode node) {
        if (node != null) {
            if (!res) {
                return;
            }
            if (node.left != null && node.left
                    .val > node.val) {
                res = false;
            }
            if (node.right != null && node.right.val < node.val) {
                res = false;
            }
            if (!res) {
                return;
            } else
                check(node.left);
            check(node.right);
        }
    }


    public static void main(String[] args) {


        Solution_98 sol = new Solution_98();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        boolean validBST = sol.isValidBST(root);
        System.out.println(validBST);
        String[] s = new String[]{"pwwkew", "bbbbbbbbbbbb", "abcabcbb", "abba"};

    }
}
