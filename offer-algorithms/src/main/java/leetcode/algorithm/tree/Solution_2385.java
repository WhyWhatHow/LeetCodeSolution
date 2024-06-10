package leetcode.algorithm.tree;

import leetcode.algorithm.dsa.TreeNode;

/**
 * @program: LeetCodeSolution
 * @description: #bfs
 * @author: WhyWhatHow
 **/

public class Solution_2385 {

    public static void main(String[] args) {
        Solution_2385 sol = new Solution_2385();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(2);
        // right
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);

        System.out.println(sol.amountOfTime(root,
                3
//                1
        ));
        System.out.println("==================");
    }

    //  starting node to  broken
    TreeNode startNode = null;
    // subtree's diameter
    int max = 0;

    /**
     * 求二叉树的感染速度, 即 感染节点子树的高度 + 以及去掉感染节点子节点的其余子树的直径
     *
     * @param root
     * @param start
     * @return
     */
    public int amountOfTime(TreeNode root, int start) {
        // 1 element
        if (root.val == start) {
            return maxDepth(root) - 1;
        }

        //1. find startNode
        findNode(root, start);
        //2. startNode depth
        int sDpeth = maxDepth(startNode);

        //3. update startNode left & right subtree
        startNode.left = null;
        startNode.right = null;

        //4. other subtree's diameter
        max = 0;
        maxDepth(root);
        return Math.max(max, sDpeth-1);

    }

    void findNode(TreeNode root, int start) {
        if (root == null || startNode != null) {
            return;
        }
        if (root.val == start) {
            startNode = root;
            return;
        }
        findNode(root.left, start);
        findNode(root.right, start);
    }

    int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = maxDepth(node.left);
        int r = maxDepth(node.right);
        // get diameter of the tree
        max = Math.max(max, l + r);

        return Math.max(l, r) + 1;
    }

}


