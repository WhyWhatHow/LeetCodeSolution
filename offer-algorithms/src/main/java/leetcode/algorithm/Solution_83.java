package leetcode.algorithm;

import leetcode.algorithm.dsa.ListNode;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head, q = p.next;
        boolean yes = false;// 标志是否有重复元素
        while (p != null && q != null) {
            if (p.val == q.val) {
                q = q.next;
                yes = true;
            } else {
                p.next = q;
                p = q;
                q = q.next;
                yes = false;
            }
        }
        if (yes) {
            p.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution_83 sol = new Solution_83();
        ListNode root = new ListNode();
        root.setArray(new int[]{1, 1, 2, 3, 3});
        ListNode listNode = sol.deleteDuplicates(root);
        listNode.travel();
        System.out.println("==================");
    }
}


