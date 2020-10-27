package leetcode.algorithm;

import leetcode.algorithm.dsa.TreeNode;

import java.util.*;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/
public class Solution_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ansList = new LinkedList<>();
        if (root==null) {
            return ansList;
        }

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);

        LinkedList<Integer> tempList = new LinkedList<>();

        while (!list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = list.poll();
                tempList.add(poll.val);

                if (poll.left != null) {
                    list.add(poll.left);
                }
                if (poll.right != null) {
                    list.add(poll.right);
                }
            }
            ansList.add(tempList);
            tempList = new LinkedList<>();


        }
        List resList=new LinkedList();
        for (int i = ansList.size()-1; i >=0; i--) {
            resList.add(ansList.get(i));
        }
        return resList;
    }

    void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + ",");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Solution_102 sol = new Solution_102();
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
//        sol.inorder(node);
        System.out.println();
        node.level(node);
        System.out.println();
        int depth = node.maxDepth(node);
        System.out.println("depth : "+depth);
        List<List<Integer>> lists = sol.levelOrder(node);
        System.out.println(lists);


    }
}

