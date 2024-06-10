package leetcode.algorithm;

import leetcode.algorithm.dsa.ListNode;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_23 {
    ListNode leftNode, rightNode;

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        } else if (lists.length == 2) {
            return mergeTwoLists(lists[0], lists[1]);
        }
        ListNode[] example = new ListNode[lists.length];
        int cnt = 0;
        for (ListNode list : lists) {
            if (list != null) {
                example[cnt++] = list;
            }
        }
        return mergeSort(example, 0, cnt-1);
//        return mergeTwoLists(leftNode, rightNode);
    }

    //    public  ListNode mergeList(ListNode[] lists,){
//        int mid =lists.length>>1;
//
//    }
    public ListNode mergeSort(ListNode[] lists, int left, int right) {
        if (left >= right) {
            return null;
        }
        int mid = (left + right) >> 1;
        leftNode
//               lists[left]
                = mergeSort(lists, left, mid);
//        ListNode listNode1
//             lists[right]

        rightNode = mergeSort(lists, mid + 1, right);
        return mergeTwoLists(lists[left], lists[right]);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // l1 : 1-2-4
        // l2 : 1-3-4
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode p = l1, pp = l2;

        ListNode ans = new ListNode();

        ListNode q = ans;
        while (p != null && pp != null) {
            if (p.val <= pp.val) {
                q.next = p;
                q = q.next;
                p = p.next;
            } else {
                q.next = pp;
                q = q.next;
                pp = pp.next;
            }
        }
        if (p != null) {
            q.next = p;
        } else if (pp != null) {
            q.next = pp;
        }
        return ans.next;
    }

    public static void main(String[] args) {
//        [[-1,1],[-3,1,4],[-2,-1,0,2]]
        ListNode lll=new ListNode(-1);
        lll.next=new ListNode(1);
        ListNode llll =new ListNode(-3);
        llll.next =new ListNode(1);
        llll.next.next= new ListNode(4);
        ListNode lq= new ListNode(-2);
        lq.next= new ListNode(-1);
        lq.next.next= new ListNode(0);
        lq.next.next.next =new ListNode(2);
        Solution_23 sol = new Solution_23();
        ListNode l = new ListNode(-1);
        l.next = new ListNode(5);
        l.next.next = new ListNode(11);

        ListNode ll = new ListNode(6);
        ll.next = new ListNode(10);
//        ll.next.next= new ListNode(11);

        ListNode listNode = sol.mergeKLists(new ListNode[]{null, l, null, ll});
        System.out.println("==================");
    }
}


