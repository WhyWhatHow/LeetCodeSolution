package leetcode.algorithm;

import leetcode.algorithm.dsa.ListNode;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_92 {
    /**
     *  题解: 新建链表,  采用逆序建表的方式处理 逆转链表部分. 其他部分采用正序建表方案
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode res = new ListNode();
        int cnt = 0;
        ListNode p = res, q = head, tail = q;
        while (q != null) {
            cnt++;

            if (cnt >= m && cnt <= n) {
                ListNode temp = new ListNode(q.val);
                temp.next = p.next;
                p.next = temp;
                // 设置尾结点
                if (cnt == m) {
                    tail = temp;
                }// 逆转后重新设置 头结点
                if (cnt == n) {
                    p = tail;
                }


            } else {
                p.next = new ListNode(q.val);
                p = p.next;
            }
            q = q.next;
        }
        return res.next;

    }

    public static void main(String[] args) {
        Solution_92 sol = new Solution_92();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.travel();
        ListNode listNode = sol.reverseBetween(head, 1, 5);
        listNode.travel();

        System.out.println("==================");
    }
}


