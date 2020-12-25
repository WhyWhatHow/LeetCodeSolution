package leetcode.algorithm;

import leetcode.algorithm.dsa.ListNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_141 {
    public boolean hasCycle(ListNode head) {
        // 直接hashset
        HashSet<ListNode> map = new HashSet<>();
//        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode root = head;
        while (root != null) {
            if (map.contains(root)) {
                return true ;
            }
            map.add(root);
            root =root.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution_141 sol = new Solution_141();
        System.out.println("==================");
    }
}


