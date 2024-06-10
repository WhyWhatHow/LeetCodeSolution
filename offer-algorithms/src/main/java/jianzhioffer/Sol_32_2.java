package jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_32_2 {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ansList = new LinkedList<>();
        if (root == null) {
            return ansList;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);

        LinkedList<Integer> tempList = new LinkedList<>();
        boolean circle = false; // circle true,left -> right false  right->left
        while (!list.isEmpty()) {
            int size = list.size();
            circle = !circle;
            for (int i = 0; i < size; i++) {
                TreeNode poll = list.poll();
                if (circle) {
                    tempList.add(poll.val);
                } else {
                    tempList.addFirst(poll.val);
                }
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
        return ansList;
    }

    public int maxDepth(TreeNode root) {
        if (root != null) {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        } else
            return 0;
    }

    public int kthLargest(TreeNode root, int k) {
        ArrayList<Integer> list =new ArrayList<>();
        inorder(root,list);
        return list.get(list.size()-k);
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }

    public static void main(String[] args) {
        Sol_32_2 sol = new Sol_32_2();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(15);
//        root.right.right = new TreeNode(7);

        for(int i= 0; i< 4 ;i++)
            System.out.println(sol.kthLargest(root,i+1));

    }

}
