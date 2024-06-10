package leetcode.algorithm;

import leetcode.algorithm.dsa.ListNode;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_2 {

    int opt = 0; // 用作判断 是否进位

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode w = new ListNode();
        ListNode p = l1, q = l2, pre = res;
        int val;
        //1 .处理两者共有的部分
        while (p != null && q != null) {
            // 2. 计算,获取当前位置的val, 以及进位值
            val = getVal(p.val, q.val);
            w.val = val;
            pre.next= w;
            pre = w;
            w.next = new ListNode();
            p = p.next;
            q = q.next;
            w = w.next;
        }
        // 单独处理 判断进位与否
        while (p != null) {
            pre.next= w;

            w.val = p.val + opt;
            opt = 0;
            if (w.val >= 10) {
                w.val -= 10;
                opt = 1;
            }
            pre = w;
            w.next = new ListNode();

            w = w.next;
            p = p.next;
        }
        while (q != null) {
            w.val = q.val + opt;
            pre.next= w;
            opt = 0;
            if (w.val >= 10) {
                w.val -= 10;
                opt = 1;
            }
            pre = w;
            w.next = new ListNode();
            w = w.next;
            q = q.next;
        }

        if (opt != 0) {
            w = new ListNode(1);
            pre.next = w;
        } else {
            pre.next = null;
        }

        return res.next;

    }

    private int getVal(int pval, int qval) {
        int val;
        val = pval + qval + opt;
        opt = 0;
        if (val >= 10) {
            val -= 10;
            opt = 1;
        }
        return val;
    }

    public static void main(String[] args) {

        Solution_2 sol = new Solution_2();
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(9);
        ListNode ll = new ListNode(9);
        ll.next = new ListNode(7);
        ll.next.next = new ListNode(4);

//        ListNode l = new ListNode(0);
//        ListNode ll = new ListNode(5);
//        ll.next = new ListNode(3);
        ListNode listNode = sol.addTwoNumbers(l, ll);
        System.out.println("==================");
    }
}


