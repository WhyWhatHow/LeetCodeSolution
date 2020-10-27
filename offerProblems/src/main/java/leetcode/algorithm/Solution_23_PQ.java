package leetcode.algorithm;

import leetcode.algorithm.dsa.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_23_PQ {

    /**
     * todo
     *  题解 1 . 利用归并排序思想解题, 需要处理好归并排序的节点设置通道
     * done
     *  题解 2 ; 利用对堆进行处理,处理最小节点,然后整个题目变成一个简单的遍历过程.
     *  @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;

        }

        PriorityQueue pq = new PriorityQueue(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l, ListNode ll) {
                return l.val - ll.val;
            }
        });
        ListNode resList = new ListNode();
        ListNode res = resList;
        for (ListNode list : lists) {
            if (list != null) {

                pq.add(list);
            }
        }
        while (!pq.isEmpty()) {
            ListNode peek = (ListNode) pq.peek();
            pq.poll();
            res.next = new ListNode();
            res = res.next;
            res.val = peek.val;
            peek = peek.next;
            if (peek != null) {
                pq.add(peek);
            }
        }
        return resList.next;
    }


    public static void main(String[] args) {
        Solution_23_PQ sol = new Solution_23_PQ();
        int[][] num = new int[][]{{1, 3, 4}, {1, 4, 5}, {2, 6}};
        ListNode[] lists = new ListNode[3];
        int cnt = 0;
        for (int[] ints : num) {
            lists[cnt] = new ListNode();
            lists[cnt++].setArray(ints);
        }
        ListNode listNode = sol.mergeKLists(lists);
        listNode.travel();
        System.out.println("==================");
    }

    @Test
    void testPQ() {
        int[] num = new int[10];
        Random random = new Random();
        PriorityQueue pq = new PriorityQueue();

        for (int i = 0; i < num.length; i++) {
            num[i] = random.nextInt(100);
            System.out.print(num[i] + ",");
            pq.add(num[i]);
        }
        System.out.println("==============");
        while (!pq.isEmpty()) {
            Object peek = pq.peek();
            System.out.println(peek);
            pq.poll();
        }

    }
}


