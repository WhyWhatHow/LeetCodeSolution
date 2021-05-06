package leetcode.algorithm;

import leetcode.algorithm.dsa.ListNode;

import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_445 {
    /**
     * @param l1 1234 表示 1->2->3->4 正序
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        Stack<Integer> s = new Stack<>(); // op1
        Stack<Integer> ss = new Stack<>(); // op2
        //1. 将两个操作数压栈
        ListNode p = l1, q = l2;
        while (p != null) {
            s.push(p.val);
            p = p.next;
        }
        while (q != null) {
            ss.push(q.val);
            q = q.next;
        }
        p = res;
        boolean yes = false;// 进位标志
        // 2 进行加法 运算
        while (true) {
            int op1 = 0, op2 = 0, temp = 0;
            if (s.isEmpty() && ss.isEmpty()) {
                break;
            }
            // 获取操作数
            if (!s.isEmpty()) {
                op1 = s.pop();
            }
            if (!ss.isEmpty()) {
                op2 = ss.pop();
            }
            // 进行加法运算
            if (yes) {
                temp = (op1 + op2 + 1);
            } else {
                temp = (op1 + op2);
            } // 标记是否需要进位
            yes = temp < 10 ? false : true;
            // 生成操作数 , 头插法
            ListNode listNode = new ListNode(temp % 10);
            listNode.next = p.next;
            p.next = listNode;
        }
        if (yes) {
            ListNode listNode =new ListNode(1);
            listNode.next=p.next;
            p.next= listNode;
        }
        return res.next;
    }

    public static void main(String[] args) {
        Solution_445 sol = new Solution_445();
//        ListNode l1 = new ListNode();
//        l1.setArray(new int[]{7, 2, 4, 3});
//        ListNode l2 = new ListNode();
//        l2.setArray(new int[]{5, 6, 4});
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        l1.travel();
        l2.travel();
        ListNode listNode = sol.addTwoNumbers(l1, l2);
        listNode.travel();
        System.out.println("==================");
    }
}


