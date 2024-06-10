package jianzhioffer;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_68 {
    /**
     * 分情况考虑问题,
     * 1. p节点与q节点分别在 root(树,或者子树) 两端,  即 root.left=p||q,root.right=p||q, 返回root
     * 2. p 和q 在 root 树的一端
     * p=root, q 在 root.left ,返回 p
     * p =root, q 在root.right, 返回p
     * 3. p 或者q 在 root 节点上, 返回root 节点, (考虑叶子节点与根节点)
     *
     *
     * 简单考虑这个问题: p q 不同侧, 那么返回他们的root
     * p,q 同侧, 返回第一个查找到的p或q
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {// 叶子结点,
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q); // 左子树查找
        TreeNode right = lowestCommonAncestor(root.right, p, q);// 右子树查找

        if (left == null) {//左子树空,表明p或q在右子树
            return right;
        }
        else if (right == null) {// 右子树空,表明p或q在左子树
            return left;
        }else{// 左右子树都不空的情况,返回root节点
            return root;
        }

    }

    public static void main(String[] args) {
        Sol_68 sol = new Sol_68();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode treeNode = sol.lowestCommonAncestor(root, root.left.right.left, root.left.right.right);
//        TreeNode treeNode = sol.lowestCommonAncestor(root, root.left, root.left.right.right);

        System.out.println(treeNode);
        System.out.println("=======");
    }
}
