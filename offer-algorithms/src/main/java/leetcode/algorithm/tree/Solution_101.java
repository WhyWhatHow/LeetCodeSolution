package leetcode.algorithm.tree;

import leetcode.algorithm.dsa.TreeNode;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_101 {

    /**
     *   题解: 递归方式进行处理, 判断对称 ,主要是判断左子树是否与右子树对称, 即 left.right -- right.left, left.left = right.right
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root ==null) {
             return true;
        }
        return isSys(root.left, root.right);
    }

    private boolean isSys(TreeNode left, TreeNode right) {
        if (left==null && right==null) {
            return true ;
        }
        if (left==null||right==null) {
            return false ;
        }
        return left.val==right.val  && isSys(left.left,right.right) && isSys(left.right,right.left);
    }

    public static void main(String[] args) {
        Solution_101 sol = new Solution_101();
        System.out.println("==================");
    }
}


