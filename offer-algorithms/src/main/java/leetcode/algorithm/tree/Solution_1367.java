package leetcode.algorithm.tree;

import leetcode.algorithm.dsa.ListNode;
import leetcode.algorithm.dsa.ListNodeUtils;
import leetcode.algorithm.dsa.TreeNode;
import leetcode.algorithm.dsa.TreeUtils;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1367 {

    public static void main(String[] args) {
        Solution_1367 sol = new Solution_1367();
        ListNode head = ListNodeUtils.buildList(new int[]{1, 4, 2, 6});
        TreeNode root = TreeUtils.buildTree(new Integer[]{1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3});
        System.out.println(sol.isSubPath(head, root));
//        ListNode list =new ListNode();
        System.out.println("==================");
    }


    ListNode head;

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode cur, TreeNode root) {
        if (cur == null) return true;
        if (root == null) return false;
        if (root.val != cur.val) return false;
        return dfs(cur.next, root.left) || dfs(cur.next, root.right);
    }


}


