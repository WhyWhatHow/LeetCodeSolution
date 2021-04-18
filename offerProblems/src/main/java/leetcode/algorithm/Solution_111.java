package leetcode.algorithm;

import leetcode.algorithm.dsa.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_111 {
    class TempNode{
        public TreeNode getNode() {
            return node;
        }

        public void setNode(TreeNode node) {
            this.node = node;
        }

        /**
         *
         */
        TreeNode node;
        int depth ; //深度

        public TempNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    public int minDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int ans = 0 ;
        LinkedList<TempNode> list = new LinkedList<>();
        list.add(new TempNode(root,1));
        while (!list.isEmpty()) {
            TempNode tempNode = list.removeFirst();
            TreeNode treeNode = tempNode.getNode();
//            cnt--;
//            if (cnt == 0) { //维护层数
//                ans++;
//            }
            if (treeNode.left == null && treeNode.right == null) {
                ans =tempNode.depth;
                break;
            }
            if (treeNode.left != null) {
                list.add(new TempNode(treeNode.left, tempNode.depth+1));
//                cnt++;
            }
            if (treeNode.right != null) {
                list.add(new TempNode(treeNode.right, tempNode.depth+1));
//                cnt++;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        Solution_111 sol = new Solution_111();
        System.out.println("==================");
    }
}


