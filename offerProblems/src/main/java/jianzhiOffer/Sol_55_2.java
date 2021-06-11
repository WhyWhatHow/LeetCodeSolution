package jianzhiOffer;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_55_2 {

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    boolean res;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int abs = Math.abs(leftDepth - rightDepth);
        if (left && right && abs <= 1) {
            return true ;
        }else {
            return false;
        }
    }


    public static void main(String[] args) {
        Sol_55_2 sol = new Sol_55_2();
        System.out.println("=======");
    }
}
