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
        p.next=q;
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
        head.setArray(new int[]{1, 2, 3, 4,5});
        head.travel();
        ;
        head = sol.swapPairs(head);
        head.travel();
        System.out.println("==================");
    }
}


