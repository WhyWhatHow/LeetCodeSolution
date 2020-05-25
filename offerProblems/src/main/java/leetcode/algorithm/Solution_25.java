package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 08:03
 **/
public class Solution_25 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode() {
        }

    }

    /**
     *  1.  获取链表长度
     *  2.  设置reserve 的尾结点
     *  3.   链表逆置,尾插法
     *  4 设置下一次循环的头结点,尾结点
     *  5 处理未转置部分
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode(0);
        ListNode p = res, q = head;
        ListNode qq = q.next;
        ListNode tail = res;
        // 标记内部循环次数
        int time = 0;

        int cnt = getCount(head);
        int circle = cnt / k;
        int cnum =0 ;
        while (q != null && cnum<circle) {
            if (time == 0) {
                // 头插法,第一个节点当前逆序过程的尾结点
                tail = q;
            }
            time++;
            q.next = p.next;
            p.next = q;
            // 判断是否结束当前范围的reserve
            if (time == k) {
                // 更新头结点
                p=tail;
                cnum++;
                time = 0;
            }
            q = qq;
            if (qq != null) {
                qq = qq.next;
            }
            cnt--;
        }
        //
        tail.next=q;

        return res.next;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tail = head;
//        ListNode p =head;

        for (int i = 1; i < 5; i++) {
            ListNode p = new ListNode(i + 1);
            tail.next = p;
            tail = p;
        }
        travel(head);
        int cnt = getCount(head);
        System.out.println("==================");
        Solution_25 sol = new Solution_25();
        head = sol.reverseKGroup(head, 3);
        travel(head);
        getCount(head);
    }

    private static int getCount(ListNode head) {
        ListNode p = head;
        int cnt = 0;
        while (p != null) {
            cnt++;
            p = p.next;
        }
        return cnt;
    }

    private static void travel(ListNode head) {
        ListNode p = head;
        int cnt = 0;
        while (p != null) {
            System.out.print(p.val + ",");
            cnt++;
            p = p.next;
        }
        System.out.println("==");

    }
}
