package jianzhiOffer;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/


public class Sol_35 {


    /**
     * 解法:
     * 假设head : 1->2->3->null
     * step 1:  1-_1->2->_2->3->_3->null : _Num表示复制后的节点
     * step 2: 为复制的节点设置random,
     * step 3: 将链表分离
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        while (cur != null) { //复制链表
            Node cpNode = new Node(cur.val);
            cpNode.next = cur.next;
            cur.next = cpNode;
            cur = cur.next.next;
        }// 2. 设置 random 值
        cur = head;
        while (cur != null) {
            if (cur.random != null) {// cur.next = cpNode
                cur.next.random = cur.random.next; //2->_2
            }
            cur = cur.next.next;
        }
        //3. 分离两个 链表
        Node res = head.next, tail = res;
        cur = head.next;
        Node pre = head;
        while (cur.next != null) {
            pre.next = pre.next.next;
            pre = pre.next;
            cur = cur.next.next;
            tail.next = cur;
            tail = tail.next;
        }
        pre.next = null;

        return res;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static void main(String[] args) {
        Sol_35 sol = new Sol_35();
        Node head = new Node(1);
        head.next = new Node(2);
        head.random = head.next;
        head.next.random = head.next;
        sol.copyRandomList(head);
        System.out.println("=======");
    }
}

