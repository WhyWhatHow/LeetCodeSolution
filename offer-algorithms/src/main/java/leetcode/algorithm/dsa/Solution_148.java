package leetcode.algorithm.dsa;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_148 {

    public static void main(String[] args) {


        Solution_148 sol = new Solution_148();//
        ListNode root = ListNodeUtils.buildList(
                new int[]{-1, 5, 3, 4, 0}
        );
        sol.sortList(root);
        System.out.println("==================");
    }

    // mergeSort , nlogn
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 1 . 快慢指针找中点. slow 找到的就是最后的mid 的前节点.
        var fast = head.next;
        var slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        var mid = slow.next;
        slow.next = null;
//        -1, 5, 3, 4, 0
        var left = sortList(head);
        var right = sortList(mid);

        return merge(left, right);
    }

    private ListNode merge(ListNode l, ListNode r) {
        var t = new ListNode(0);
        var cur = t;
        while (l != null && r != null) {
            if (l.val <= r.val) {
                cur.next = l;
                l = l.next;
            } else {
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }
        cur.next = l == null ? r : l;

        return t.next;
    }

}
