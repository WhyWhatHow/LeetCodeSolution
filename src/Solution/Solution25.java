package Solution;

/**
 * 25. Reverse Nodes in k-Group
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 *
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
// // TODO: 2020/3/26 k个数据反转链表 
public class Solution25 {
    public static void main(String[] args) {
//        HashMap;
//        ListNode head = new  ListNode();
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre ,cur,next;
        cur =head ;
        pre = null;
        int n = k ;
        while(cur.next!=null){
            next = cur.next;
            cur.next= pre ;
            pre= cur ;
            cur = next ;
        }
        return  null;
    }
    class ListNode {
        int val ;
        ListNode next ;
        ListNode(){}
        ListNode(int val){
            this.val  =val ;
        }
    }
}
