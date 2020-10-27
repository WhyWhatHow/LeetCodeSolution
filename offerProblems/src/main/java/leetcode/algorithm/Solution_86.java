package leetcode.algorithm;

import leetcode.algorithm.dsa.ListNode;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_86 {
    //    输入: head = 1->4->3->2->5->2, x = 3
//    输出: 1->2->2->4->3->5

    /**
     * 题解: 遍历两次链表, 第一次保存 小于x的节点, 第二次保存余下节点
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode();
        ListNode p = res, q = head;
        while (q != null) {
            if (q.val < x) {
                p.next = new ListNode(q.val);
                p= p.next;
            }
            q=q.next;
        }
        q= head;
        while (q != null) {
            if (x <= q.val ) {
                p.next = new ListNode(q.val);
                p= p.next;
            }
            q=q.next;
        }
        return  res.next;
    }

    public static void main(String[] args) {
        Solution_86 sol = new Solution_86();
        System.out.println("==================");
    }
}


