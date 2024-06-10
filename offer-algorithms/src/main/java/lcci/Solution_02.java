package lcci;

import leetcode.algorithm.dsa.ListNode;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: 链表
 * @author: WhyWhatHow

 **/

public class Solution_02 {

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<Integer, Boolean> map = new HashMap<>();
        ListNode res = new ListNode();
        ListNode p = head, tail = res;
        while (p != null) {
            if (!map.containsKey(p.val)) {
                map.put(p.val, true);
                tail.next = new ListNode(p.val);
                tail = tail.next;
            }
            p = p.next;
        }
        return res.next;
    }

    public int kthToLast(ListNode head, int k) {
        int len = getLength(head);
        int loc = len - k;
        int res = -1;
        int cnt = 0;
        ListNode p = head;
        while (p != null) {
            cnt++;
            if (cnt == loc) {
                res = p.val;
                break;
            }
            p = p.next;
        }
        return res;
    }

    private int getLength(ListNode head) {
        int cnt = 0;
        while (head != null) {
            cnt++;
            head = head.next;
        }
        return cnt;
    }

    public void deleteNode(ListNode node) {
//        while (node != null) {
        node.val = node.next.val;
        node.next = node.next.next;
//        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode h = new ListNode(), eqX = new ListNode(), end = new ListNode();
        ListNode p = head, hp = h, henq = eqX, endp = end;
        while (p != null) {
            if (p.val < x) {
                hp.next = new ListNode(p.val);
                hp = hp.next;
            } else if (p.val == x) {
                henq.next = new ListNode(x);
                henq = henq.next;
            } else {
                endp.next = new ListNode(p.val);
                endp = endp.next;
            }
            p = p.next;
        }
        if (end.next != null) {
            hp.next = end.next;
            endp.next = eqX.next;
        } else {
            hp.next = eqX.next;
        }

        return h.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        int up = 0;
        ListNode result = new ListNode();
        ListNode res = result;
        while (p != null && q != null) {
            int temp = p.val + q.val + up;
            if (temp > 9) {
                up = 1;
                temp -= 10;
            } else {
                up = 0;
            }
            res.next = new ListNode(temp);
            res = res.next;
            p = p.next;
            q = q.next;
        }
        while (p != null) {
            int temp = p.val + up;
            if (temp > 9) {
                temp -= 10;
                up = 1;
            } else {
                up = 0;
            }
            res.next = new ListNode(temp);
            res = res.next;
            p = p.next;
        }
        while (q != null) {
            int temp = q.val + up;
            if (temp > 9) {
                temp -= 10;
                up = 1;
            } else {
                up = 0;
            }
            res.next = new ListNode(temp);
            res = res.next;
            q = q.next;
        }
        if (up == 1) {
            res.next = new ListNode(up);
            res = res.next;
        }
        return result.next;
    }

    /**
     * 相交的定义, 尾部数据相同 ,比较的是引用, 不是指
     * 1->2->3 ->
     * -> 4 ->5
     * 2->3->1->
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tailA = headA, tailB = headB;
        int cntA = 0;
        int cntB = 0;
        while (tailA != null) {
            tailA = tailA.next;
            cntA++;
        }
        while (tailB != null) {
            tailB = tailB.next;
            cntB++;
        }
        if (tailA != tailB) {
            return null;
        }
        int ans = cntA - cntB;
        tailA = headA;
        tailB = headB;
        while (ans < 0) {
            ans++;
            tailB = tailB.next;
        }
        while (ans > 0) {
            ans--;
            tailA = tailA.next;
        }
        while (tailA != tailB) {
            tailA = tailA.next;
            tailB = tailB.next;
        }
        return tailA;

    }

    /**
     * 思路一 hashmap 打表 放 listnode , 遍历一遍后查找就可以了
     * 思路二:快慢指针
     * 1、和判断链表是否有环一样，用快慢指针
     * 2、如果有环，快慢指针在某一处相遇，此时让快指针回到头节点
     * 3、然后快指针和慢指针同时往下一步步走
     * 4、他们一定会在入环节点相遇(定理)
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode res = null;
        ListNode slow = head, quick = head;
        while (quick.next != null) {
            if (quick.next.next != null) {
                quick = quick.next.next;
            } else {
                break; // return null
            }
            slow = slow.next;
            if (quick == slow) { //. 判断链表存在环
                quick = head; // 重置 quick指针
                while (quick != null) { // 找环节点.
                    if (quick == slow) {
                        res = quick;
                        break;
                    }
                    quick = quick.next;
                    slow = slow.next;
                }
                if (res != null) {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        Solution_02 sol = new Solution_02();
        ListNode head = new ListNode();
        head.setArray(new int[]{
//                4, 1, 8, 4, 5
                1
        });
        ListNode head1 = new ListNode();
        head1.setArray(new int[]{
                1
//                5, 0, 1, 8, 4, 5
        });
        ListNode intersectionNode = sol.getIntersectionNode(head, head1);
        System.out.println("==================");
    }
}


