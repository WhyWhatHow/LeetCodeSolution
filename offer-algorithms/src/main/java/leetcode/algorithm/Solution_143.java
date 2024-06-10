package leetcode.algorithm;

import leetcode.algorithm.dsa.ListNode;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow

 **/

public class Solution_143 {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
//        head.travel();
        ListNode temp = new ListNode();// head 的逆序链表
        ListNode p = head, q = temp;
        // 1. 建立  head逆序 链表 temp
        int all = 0, cnt = 0; // all统计所有节点的数量
        while (p != null) {
            ListNode node = new ListNode(p.val);
            node.next = temp.next;
            temp.next = node;
            p = p.next;
            all++;
        }
        temp = temp.next;// 头结点默认是0, 所以要去掉
//        temp.travel();
        //2. 建立重拍链表
        q = temp;
        p = head;
        ListNode res = new ListNode();// 重拍链表的 resList,
        ListNode t = res;
        while (all != cnt) {// 偶数, 奇数
            t.next = new ListNode(p.val);
            t = t.next;
            t.next = new ListNode(q.val);
            t = t.next;
            p = p.next;
            q = q.next;
            cnt += 2;
            if (cnt + 1 == all) {
                break;
            }
        }
        if (cnt < all) {// 奇数情况
            cnt++;
            t.next = new ListNode(p.val);
            t = t.next;
            p = p.next;
        }
        // 3 刷新head 的值
        t = res.next;
//        System.out.println("res list : ");
//        res.travel();
        p = head;
        while (t != null) {
            p.val = t.val;
            p = p.next;
            t = t.next;
        }
    }

    ListNode head = new ListNode();

    public static void main(String[] args) {
        Solution_143 sol = new Solution_143();
        sol.head.setArray(new int[]{
                1, 2, 3, 4/**/
//                1, 2, 3, 4, 5
        });
        sol.reorderList(sol.head);
        sol.head.travel();
        System.out.println("==================");
    }
}


