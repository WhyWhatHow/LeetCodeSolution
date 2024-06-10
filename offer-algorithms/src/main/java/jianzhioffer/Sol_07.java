package jianzhioffer;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 07:33
 **/
public class Sol_07 {
    /**
     * 前缀数组赵根节点,
     * 中缀数组分左右
     * 递归处理
     * 先序遍历 根左右
     * 中序遍历 左跟右
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        while (inorder[index] != preorder[0]) index++;
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1),
                Arrays.copyOfRange(inorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length),
                Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return root;
//        return dfs(preorder, inorder, 0,  preorder.length,0, inorder.length);
    }

    public TreeNode dfs(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        if (preEnd - preStart < 0 || inEnd - inStart < 0)
            return null;
        int index = inStart;
        int first = pre[preStart];
        TreeNode root = new TreeNode(pre[preStart]);
        while (in[index] != first)
            index++;
        root.left = dfs(pre, in, preStart + 1, index, inStart, index);
        root.right = dfs(pre, in, index + 1, preEnd, index + 1, inEnd);
        return root;

    }

//        Arrays.copyOfRange(preorder,0,)
////        int
//        TreeNode treeNode = pre_in_tree(preorder, inorder, preorder.length, 0, 0);
//        return treeNode;
//        return null;
//}

    TreeNode pre_in_tree(int[] pre, int[] in, int len,
                         int preLeft, int inleft) {
        if (len <= 0 || preLeft == pre.length || inleft == in.length) {
            return null;
        }
        int i = inleft;
        int first = pre[preLeft];
        TreeNode now = new TreeNode(first);
        while (in[i] != first && i < len) i++;
        now.left = pre_in_tree(pre, in, i - inleft, preLeft + 1, inleft);
        now.right = pre_in_tree(pre, in, len - i - 1, preLeft + i + 1, inleft + i + 1);
        return now;
    }

    public static void main(String[] args) {

//        testArrayCopyOfRange(a);
        Sol_07 sol = new Sol_07();
        int[] preorder = new int[]{3, 9, 20, 15, 7};

        int[] in = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = sol.buildTree(preorder, in);
        sol.in(treeNode);
        System.out.println("");

    }

    private static void testArrayCopyOfRange() {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = i;
        }
        int[] ints = Arrays.copyOfRange(a, 5, 10);
        for (int anInt : ints) {
            System.out.print(anInt + ",");
        }
    }

    void in(TreeNode root) {
        if (root != null) {
            in(root.left);
            System.out.print(root.val + ",");
            in(root.right);
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}