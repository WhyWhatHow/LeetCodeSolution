package leetcode.algorithm;

import leetcode.algorithm.dsa.ListNode;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_24 {


    public ListNode swapPairs(ListNode head) {

        return reverseKGroup(head, 2);

    }

    /**
     * 题述: 翻转 k 个链表, 不满足k个不翻转
     * 题解 :   链表逆置
     *
     * @param head
     * @param i
     * @return
     */
    private ListNode reverseKGroup(ListNode head, int i) {
        if (head == null || i == 0) {
            return head;
        }
        // 链表的长度
        int count = getCount(head);
        // 需要翻转的圈数
        int circle = count / i;
        // 已翻转的圈数
        int cnum = 0;
        // 统计 已经遍历过的节点数量
        int cnt = 0;
        ListNode res = new ListNode();
        ListNode p = res, q = head, tail = head, qq = q.next;
        while (q != null && cnum < circle) {
            // 设置尾结点
            if (cnt == 0) {
                tail = q;
            }
            cnt++;
            q.next = p.next;
            p.next = q;
            q = qq;
            if (qq != null) {
                qq = qq.next;

            }
            // 设置头结点
            if (cnt == i) {
                cnum++;
                cnt = 0;
                p = tail;
            }
        }
        p.next = q;
        return res.next;

    }

    private int getCount(ListNode head) {
        ListNode p = head;
        int cnt = 0;
        while (p != null) {
            cnt++;
            p = p.next;
        }
        return cnt;
    }


    public static void main(String[] args) {
        Solution_24 sol = new Solution_24();
        ListNode head = new ListNode();
//        head.setArray(new int[]{1, 2, 3, 4, 5});

        head.setArray(new int[]{1, 2, });
        head.travel();
        ;
//        sol.reverseList(head, null).next.travel();
        head = sol.reverseKGroup2(head, 2);
//        head = sol.swapPairs(head);
        head.travel();
        System.out.println("==================");
    }


    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // head
        ListNode emptyHead = new ListNode();
        ListNode cur = head, old = head, tail = emptyHead, next = cur.next;
        int cnt = 0;
        while (cur != null) {
            cnt++;
            next = cur.next;
            if (cnt == k) {
                cnt = 0;
                // 逆转此段链表
                ListNode deal = reverseList(old, cur.next);
                tail.next = deal;

                // 移到链表的尾结点
                while (deal.next != null) {
                    deal = deal.next;
                }
                tail = deal;
                old = next;
            }
            cur = next;
        }
        if (cnt < k) { //存在最后一个列表片段, 未进行 倒序
            tail.next = old;
        }
        return emptyHead.next;
    }

    /**
     * * 逆转此段链表 head->1->2->3; ,  头插法 , 不需要返回
     *
     * @param head 头节点
     * @param tail 结束节点
     * @return
     */
    public ListNode reverseList(ListNode head, ListNode tail) {
        ListNode node = new ListNode();
        ListNode p = head, pp = p, next = head;
        while (p != tail) {
            next = p.next;
            pp = p;
            pp.next = node.next;
            node.next = pp;
            p = next;
        }
        return node.next;
    }


}


