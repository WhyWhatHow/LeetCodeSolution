package jianzhioffer;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_14_2 {
    int mod = (int) (1e9 + 7);

    /**
     * 整数拆分求最大乘积
     * n=2 , res =1 , [1,1]
     * n=3, res=2,  [1,2]
     * n=4, res =4 , [2,2]
     * n=5, res =6,  [2,3] , 这时 ,res> n, 说明, 对于n 拆分后的子段 如n1=5,  我们应该将n1 拆分成2,3, 因为乘积更大
     * n=6, res =9 [3,3]. 推论 成立
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n < 4) return n - 1;
        long res = 1;
        while (n > 4) {
            res *= 3;
            if (res >= mod) {
                res %= mod;
            }
            n -= 3;
        }
//        res = res % mod;
        if (n > 1) {
            res *= n;
        }
        res = res % mod;
        return (int) res;
    }

    public static void main(String[] args) {
        Sol_14_2 sol = new Sol_14_2();
        System.out.println(sol.cuttingRope(120));
        System.out.println("=======");
    }
}
