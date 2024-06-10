package leetcode.algorithm;

import leetcode.algorithm.dsa.ListNode;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_234 {

    public boolean isPalindrome(ListNode head) {
        boolean res = false;
        if (head == null) {
            return true;
        }
        StringBuilder builder = new StringBuilder();
        ListNode p = head;
        while (p != null) {
            builder.append(p.val);
            p = p.next;
        }
        String s = builder.toString();
        String s1 = builder.reverse().toString();
        return s.equals(s1);

    }

    public static void main(String[] args) {
        Solution_234 sol = new Solution_234();
        System.out.println("==================");
    }
}


