package jianzhiOffer;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode taila = headA, tailb = headB;
        int cnta = 0, cntb = 0;
        while (taila != null) {
            cnta++;
            taila = taila.next;
        }
        while (tailb != null) {
            cntb++;
            tailb = tailb.next;
        }
        if (taila != tailb) { // 如果两个链表相交, 那么 尾结点一定相同.
            return null;
        }
        taila = headA;
        tailb = headB;
        int temp = cnta - cntb;
        while (taila != null && temp > 0) {// headA 长的情况
            temp--;
            taila = taila.next;
        }
        while (tailb != null && temp < 0) {// headA 长的情况
            temp++;
            tailb = tailb.next;
        }
        // headA 与 headb 等长
        while (taila != tailb) {
            taila = taila.next;
            tailb = tailb.next;
        }
        return taila;


    }

    public static void main(String[] args) {
        Sol_52 sol = new Sol_52();
        System.out.println("=======");
    }
}
