package leetcode.algorithm;

import jdk.nashorn.internal.ir.IfNode;
import leetcode.algorithm.dsa.ListNode;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode res = new ListNode();
        ListNode pp = res, p = head;
        int[] arr = new int[300];
        while (p != null) {
            arr[p.val + 100]++;
            p = p.next;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                ListNode listNode = new ListNode(i - 100);
                pp.next = listNode;
                pp = listNode;
            }
        }
        return res.next;
    }

    public static void main(String[] args) {
        Solution_82 sol = new Solution_82();
        ListNode root = new ListNode();

        root.setArray(new int[]{1, 1, 2, 3, 3});
        ListNode listNode = sol.deleteDuplicates(root);
        listNode.travel();

        System.out.println("==================");
    }
}


