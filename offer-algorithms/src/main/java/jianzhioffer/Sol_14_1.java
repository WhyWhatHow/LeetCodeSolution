package jianzhioffer;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_14_1 {
    public int cuttingRope(int n) {
        if (n < 4) return n - 1;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        if (n == 4) {
            return res << 2;
        }
        return res * n;
    }
    public static void main(String[] args) {
        Sol_14_1 sol =new Sol_14_1();
    }
}
