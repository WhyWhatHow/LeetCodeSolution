package leetcode.algorithm;

import leetcode.algorithm.dsa.ListNode;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_61 {


    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int len = getLength(head); // 标记链表长度
        k = k % len;// 移动位置
        if (k == 0) {
            return head;
        }
        int cnt = len - k; // 标记正序
        ListNode resEnd = new ListNode(); //尾部
        ListNode resStart = new ListNode();// 头部
        ListNode p = head, t = resEnd, tt = resStart;
        while (p != null) {
            if (cnt > 0) {
                cnt--;
                t.next = new ListNode(p.val);
                t = t.next;
            } else {
                tt.next = new ListNode(p.val);
                tt = tt.next;
            }
            p = p.next;
        }
        tt.next= resEnd.next;
        return resStart.next;
    }

    private int getLength(ListNode head) {
        int cnt = 0;
        while (head != null) {
            cnt++;
            head = head.next;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution_61 sol = new Solution_61();
        ListNode root = new ListNode();
//        root.setArray(new int[]{6,5,4,3,2,1});
//        root.setArray(new int[]{1});
        root.setArray(new int[]{
//                4,2,1,3
//                -1,5,3,4,0
//                1, 2, 3, 4, 5,
                0,1,2
        });
//        ListNode listNode = sol.rotateRight(root, 7);
        ListNode listNode = sol.rotateRight(root, 4);
        listNode.travel();

        System.out.println("==================");
    }
}


