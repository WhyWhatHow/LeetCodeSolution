package leetcode.algorithm.medium;

import leetcode.algorithm.dsa.ListNode;
import leetcode.algorithm.dsa.ListNodeUtils;

import java.util.HashSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3217 {

    public static void main(String[] args) {
        Solution_3217 sol = new Solution_3217();
//        new ListNode();
        ListNode node = ListNodeUtils.buildList(new int[]{1, 2, 3, 4, 5});
        System.out.println(sol.modifiedList(new int[]{1, 2, 3}, node));
        System.out.println("==================");
    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        var set = new HashSet<Integer>();
        for (int i : nums) {
            set.add(i);
        }
        var node = new ListNode(0);
        node.next = head;
        ListNode cur = node, next = cur.next;
        while (next != null) {
            if (set.contains(next.val)) {
                cur.next = next.next;
                // next = cur.next ;
            } else {
                cur = cur.next;
            }
            //    else {

            //  cur = next;
            next = next.next;
            //  }
        }
        return node.next;
    }
}


