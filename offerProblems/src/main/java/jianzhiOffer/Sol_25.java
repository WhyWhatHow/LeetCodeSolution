package jianzhiOffer;

import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode ans = new ListNode(-1);
        ListNode p = l1, q = l2, qq = ans;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                qq.next = p;
                qq=qq.next;
                p = p.next;
            } else {
                qq.next = q;
                qq=qq.next;
                q = q.next;
            }
        }
        while (p != null) {
            qq.next = p;
            qq=qq.next;
            p = p.next;
        }
        while (q != null) {
            qq.next = q;
            qq=qq.next;
            q = q.next;
        }
        return ans.next;
    }

    public static void main(String[] args) {
        Sol_25 sol = new Sol_25();
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(4);
        ListNode l2=new ListNode(1);
         l2.next=new ListNode(3);
        l2.next.next =new ListNode(4);
        ListNode listNode = sol.mergeTwoLists(l1, l2);

    }
}
