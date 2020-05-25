package jianzhiOffer;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_17 {
    public int[] printNumbers(int n) {
        int pow = (int) Math.pow(10,n);
        int ans[]=new int[pow];
        for(int i= 0;i<pow;i++){
            ans[i]=i+1;
        }
        return ans ;
    }
    public static void main(String[] args) {
        Sol_17 sol =new Sol_17();
    }
}
