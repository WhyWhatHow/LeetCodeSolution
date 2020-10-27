package leetcode.algorithm;

import leetcode.algorithm.dsa.ListNode;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_21 {
    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * 题解: 哨兵 ans -> l1|| l2; 归并排序
     *      q 结果集
     *      p 指针              1-2-4
     *      pp指针              1-3-5
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // l1 : 1-2-4
        // l2 : 1-3-4
        ListNode p = l1, pp = l2;
        ListNode ans = new ListNode();
        ListNode q = ans;
        while (p != null && pp != null) {
            if (p.val <= pp.val) {
                q.next = p;
                q = q.next;
                p = p.next;
            } else {
                q.next = pp;
                q = q.next;
                pp = pp.next;
            }
        }
        if (p != null) {
            q.next = p;
        } else if (pp != null) {
            q.next = pp;
        }
        return ans.next;
    }

    public static void main(String[] args) {
        Solution_21 sol = new Solution_21();
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(4);
        ListNode ll = new ListNode(1);
        ll.next = new ListNode(3);
        ll.next.next = new ListNode(5);

        ListNode list = sol.mergeTwoLists(l, ll);
        list.travel();
        System.out.println("==================");
    }
}


