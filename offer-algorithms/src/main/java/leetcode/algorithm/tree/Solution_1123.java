package leetcode.algorithm.tree;

import leetcode.algorithm.dsa.TreeNode;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1123 {

    public static void main(String[] args) {
        Solution_1123 sol = new Solution_1123();
        System.out.println("==================");
    }

    // lcaDeepstLeaves(root) 表示 深度最高的叶子节点第一个公共祖先.

    /***
     *
     flowchart TD
     A[开始] --> B{根节点为空}
    B -->|Yes| C[返回根节点]
    B -->|No| D[计算左子树深度]
    D --> E[计算右子树深度]
    E --> F{左右深度相等}
    F -->|Yes| G[返回当前节点]
    F -->|No| H{左深度大于右深度}
    H -->|Yes| I[递归左子树]
    H -->|No| J[递归右子树]
    I --> K[返回结果]
    J --> K[返回结果]

     * @param root
     * @return
     */
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) return root;
        int dl = depth(root.left);
        int dr = depth(root.right);

        if (dl == dr) return root;
        else if (dl > dr) return lcaDeepestLeaves(root.left);
        else return lcaDeepestLeaves(root.right);

    }

    int depth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}


