package jianzhioffer;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_26 {
    /**
     * 解题思路: 1. 遍历A ,找到B 中root 节点值相等的temp list数组, (存在节点值相等的节点)
     * 2.  遍历 a与b的子树判断 子节点是否相等.
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }// 1. 找到 A 中Broot节点的位置, 然后递归遍历判断两者是否相等.
        boolean res = true;
        List<TreeNode> list = new LinkedList<>();
        pre(A, B, list);
        if (list.size() == 0) {
            return false;
        }
        for (TreeNode temp : list) {
            res = preOrder(temp, B);
            if (res) {
                break;
            }
        }
//
        return res;
    }

    private void pre(TreeNode a, TreeNode b, List<TreeNode> list) {
        if (a == null) {
            return;
        }
        if (a.val == b.val) {
            list.add(a);
        }
        pre(a.left, b, list);
        pre(a.right, b, list);
        return;
    }

    private boolean preOrder(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.val == b.val) {
            boolean res = true;
            if (b.left != null) {
                res = res && preOrder(a.left, b.left);
            }
            if (b.right != null) {
                res = res && preOrder(a.right, b.right);
            }
            return res;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        Sol_26 sol = new Sol_26();
        TreeNode aRoot = new TreeNode(4);
        aRoot.left = new TreeNode(2);
        aRoot.right = new TreeNode(3);
        aRoot.left.left = new TreeNode(4);
        aRoot.left.right = new TreeNode(5);
        aRoot.right.left = new TreeNode(6);
        aRoot.right.right = new TreeNode(7);
        aRoot.left.left.left = new TreeNode(8);
        aRoot.left.left.right = new TreeNode(9);
        TreeNode bRoot = new TreeNode(4);
        bRoot.left = new TreeNode(8);
        bRoot.right = new TreeNode(9);
        boolean subStructure = sol.isSubStructure(aRoot, bRoot);
        System.out.println(subStructure);
        System.out.println("=======");
    }
}
