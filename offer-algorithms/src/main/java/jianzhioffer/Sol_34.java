package jianzhioffer;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_34 {
    public static void main(String[] args) {
        Sol_34 sol = new Sol_34();
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(8);
//        root.left.left = new TreeNode(11);
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//        root.right.right.left = new TreeNode(5);
//        root.right.right.right = new TreeNode(1);
//        List<List<Integer>> lists = sol.pathSum(root, 22);
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        List<List<Integer>> lists = sol.pathSum(root, 1);
        lists.forEach(list -> {
            System.out.println(list.toString());
        });
    }

    List resList = new LinkedList();

    /**
     * 解题思路: 前序遍历, root,left,right, 维护一个状态,(链表添加与删除的状态就好了)
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null ) { // 排除掉根节点值= sum 的情况, 要的是路径,不是点
            return resList;
        }
        solve(root, sum, list);
        return resList;
    }

    private void solve(TreeNode root, int sum, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        sum -= root.val;
//        if (sum < 0) {
//            list.removeLast();
//            return;
//        }
        if (sum == 0 && root.left == null && root.right == null) { // 叶子结点加入
            resList.add(list.clone());
            list.removeLast();
            return;
        }
        if (root.left != null) {
            solve(root.left, sum, list);
        }
        if (root.right != null) {
            solve(root.right, sum, list);
        }
        list.removeLast();
    }

}
