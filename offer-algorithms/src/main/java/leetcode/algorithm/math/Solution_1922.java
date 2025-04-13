package leetcode.algorithm.math;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1922 {

    public static void main(String[] args) {
        Solution_1922 sol = new Solution_1922();
        for (int i = 1; i <=50; i++) {
            System.out.println(sol.countGoodNumbers(i));

        }
        System.out.println("==================");
    }

    int mod = 1000_000_007;

    public int countGoodNumbers(long n) {
        long b = n / 2;
        long even = pow(5, b);
        long odd = pow(4, b);
        if ((n & 1) != 0) {
            even*= 5 % mod;
        }
        return (int) ((even * odd) % mod);
    }

    private long pow(long a, long n) {
        long res = 1;
        while (n != 0) {
            if ((n & 1) != 0) {// odd
                res *= a;
                res = res > mod ? res % mod : res;
            }
            a *= a;
            if (a > mod) a %= mod;
            n = n >> 1;
        }
        return res;
    }
}


