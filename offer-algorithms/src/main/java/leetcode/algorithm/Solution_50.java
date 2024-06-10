package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_50 {
    /**
     * 求 x 的n次方 快速幂
     *
     * @param x
     * @param n 可以为负数, 2^-2 即 (1/2)^2 平方
     * @return
     */
    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE)
            return 0;
//        return Math.pow(x,n);
        double res = 1.0d;
        // 处理n为负数的情况
        if (n < 0) {
            x = 1 / x;

            n = -n;
        }
        while (n > 0) {
            if ((n & 1) == 1) {// 处理奇数
                res *= x;
            }
            x *= x;
            n = n >> 1;// n/2
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_50 sol = new Solution_50();
        for (int i = 0; i < 10; i++) {
            double v = sol.myPow(2, i);
            System.out.println(v);
            double v1 = sol.myPow(2, -i);
            System.out.println(v1);
        }
        System.out.println("==================");
    }
}


