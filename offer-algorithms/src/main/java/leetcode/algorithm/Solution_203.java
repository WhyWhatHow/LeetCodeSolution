package leetcode.algorithm;

import leetcode.algorithm.dsa.ListNode;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode res = new ListNode();
        ListNode p = head, pp = res;
        while (p != null) {
            if (p.val != val) {
                ListNode listNode = new ListNode(p.val);
                pp.next=listNode;
                pp =listNode;
            }
            p = p.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        Solution_203 sol = new Solution_203();
        System.out.println("==================");
    }
}


