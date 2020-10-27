package leetcode.algorithm;

import leetcode.algorithm.dsa.ListNode;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_19 {
    /**
     *   问题描述;给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *      示例： head : 1, 2, 3, 4, 5
     *      题解:  添加一个哨兵节点 ,front
     *      即 front -> head
     *               0-1-2-3-4-5
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front =new ListNode() ;
        front.next=head;
        ListNode p=front, q=front;
        int cnt = 0;
        while(cnt!=n+1 && q!=null ){
            q=q.next;
            cnt++;
        }
        while(q!=null){
            p=p.next;
            q=q.next;
        }
        if (p==null ||p.next==null) {
         return null;
        }
        p.next= p.next.next;
        return front.next;
    }

    public static void main(String[] args) {
        Solution_19 sol = new Solution_19();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        head.travel();
        head = sol.removeNthFromEnd(head, 2);
        head.travel();
        System.out.println("==================");
    }
}


