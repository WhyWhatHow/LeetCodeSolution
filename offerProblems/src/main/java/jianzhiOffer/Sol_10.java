package jianzhiOffer;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_10 {
    static long ans[] = new long[101];
     static {
        ans[0]=0;
        ans[1]=1;
        for(int i= 2;i<ans.length;i++)
            ans[i]=(ans[i-1]+ans[i-2])%1000000007;

    }
    public int fib(int n) {
        return  (int)ans[n];
    }

    public static void main(String[] args) {
        Sol_10 sol =new Sol_10();
        for (long an : ans) {
            System.out.print(an+" ,");
        }
        System.out.println("================");
        for (int i = 0; i < 100; i++) {
            System.out.println(sol.fib(i));
        }
    }
}
