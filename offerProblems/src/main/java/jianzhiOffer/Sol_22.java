package jianzhiOffer;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode res = new ListNode();
        ListNode p = head, q = head;
        while (k > 0) {
            p = p.next;
            k--;
        }
        while (p != null) {
             q=q.next;
             p=p.next;
        }
        return q;

    }

    public static void main(String[] args) {
        Sol_22 sol = new Sol_22();
    }
}
