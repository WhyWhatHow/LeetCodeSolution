package jianzhioffer;

import java.util.LinkedList;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 07:33
 **/
public class Sol_06 {

    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> list =new LinkedList<>();
        ListNode p =head;
        while(p!=null){
            list.addFirst(p.val);
            p=p.next;
        }
//        Object[] objects = list.toArray();
        int[] ans =new int[list.size()];
        int cnt =0 ;
        for (Integer integer : list) {
            ans[cnt++]=integer;
        }
        return ans ;
    }

    public static void main(String[] args) {


    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int x) {
        val = x;
    }

}
/**
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */