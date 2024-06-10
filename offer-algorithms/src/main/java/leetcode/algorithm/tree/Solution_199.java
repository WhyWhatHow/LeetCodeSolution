package leetcode.algorithm.tree;

import leetcode.algorithm.dsa.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_199 {

    public static void main(String[] args) {
        Solution_199 sol = new Solution_199();

        System.out.println("==================");
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        levelTravel(root, resList);
        return resList;
    }

    private void levelTravel(TreeNode root, List<Integer> resList) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        resList.add(root.val);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                if (i == size - 1)
                    resList.add(node.val);
            }
        }
        return ;
    }
}


