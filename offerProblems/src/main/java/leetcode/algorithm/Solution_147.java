package leetcode.algorithm;

import leetcode.algorithm.dsa.ListNode;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode res = new ListNode(Integer.MIN_VALUE);
        ListNode q = head, t = res, p = res, pre = null;
        while (q != null) {
            if (t.val <= q.val) {
                // 尾插法 , 升序 1,2,3  insert 4
                ListNode listNode = new ListNode(q.val);
                t.next = listNode;
                t = listNode;
            } else {  // 4, insert 3  -> 3,4
                // 定位插入位置
                p= res;
                pre = null;
                while (p != null) {
                    if (p.val <= q.val) {
                        pre = p;
                    }else {
                        break;
                    }
                    p = p.next;
                }
                // 链表头部插入 插入元素
                ListNode node = new ListNode(q.val);
                if (pre == null) {
                    node.next = res.next;
                    res.next = node;
                }else{ // 链表中间插入
                    node.next= pre.next;
                    pre.next= node;
                }

            }
            q = q.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        Solution_147 sol = new Solution_147();
        ListNode root = new ListNode();
//        root.setArray(new int[]{6,5,4,3,2,1});
//        root.setArray(new int[]{1});
        root.setArray(new int[]{
//                4,2,1,3
                -1,5,3,4,0
        });
        root.travel();
        ListNode listNode = sol.insertionSortList(root);
        listNode.travel();
        System.out.println("==================");
    }
}


