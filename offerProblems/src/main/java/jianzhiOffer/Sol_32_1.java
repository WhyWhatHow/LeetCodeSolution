package jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_32_1 {


    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode curr = root;
        list.add(root);
        int size;
        int[] ans = new int[1000];
        int cnt = 0;
        while (!list.isEmpty()) {
            size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = list.poll();
                ans[cnt++] = poll.val;
                if (poll.left != null) {
                    list.add(poll.left);
                }
                if (poll.right != null) {
                    list.add(poll.right);
                }
            }
        }
        int[] res =new int[cnt];
        for(int i= 0 ;i<cnt;i++){
            res[i]= ans[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Sol_32_1 sol = new Sol_32_1();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int[] ints = sol.levelOrder(root);
        System.out.println(ints.toString());

    }

}
