package leetcode.algorithm.dsa;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-08-26 03:37
 **/
public class ListNode {
    public int val ;
    public ListNode next ;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public void setArray(int[] nums){
        ListNode q= this ;
        for (int i = 0; i < nums.length; i++) {
            q.val=nums[i];
            q.next= new ListNode();
            q=q.next;
        }
        q=null;
    }
     public  void travel(){
        ListNode p =this ;
        while(p!=null){
            System.out.print(p.val+",");
            p=p.next;
        }
        System.out.println();
    }
}
