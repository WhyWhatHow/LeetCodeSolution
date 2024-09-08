package leetcode.algorithm.medium;

import leetcode.algorithm.dsa.ListNode;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2181 {

    public static void main(String[] args) {
        Solution_2181 sol = new Solution_2181();
        System.out.println("==================");
    }


    /**
     * o(n) space
     *
     * @param head
     * @return
     */
    public ListNode mergeNodesByAnotherList(ListNode head) {
        int sum = 0;
        ListNode res = new ListNode();
        ListNode next = head, rn = res;
        while (next != null) {
            if (next.val == 0 && next != head) {
                rn.next = new ListNode(sum);
                rn = rn.next;
                sum = 0;
            } else {
                sum += next.val;
            }
            next = next.next;
        }
        return res.next;
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode prev = head;
        ListNode cur = head.next;
        int sum = 0;
        while (cur != null) {
            if (cur.val != 0) {
                sum += cur.val;
            } else {
                cur.val = sum;
                prev.next = cur;
                prev = prev.next;
                sum = 0;
            }
            cur = cur.next;
        }
        return head.next;

    }


}


