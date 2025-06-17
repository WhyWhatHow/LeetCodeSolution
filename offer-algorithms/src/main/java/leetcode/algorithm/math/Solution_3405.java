package leetcode.algorithm.math;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3405 {

    public static void main(String[] args) {
        Solution_3405 sol = new Solution_3405();
        System.out.println(sol.pow(3, 3, 100));
        System.out.println(sol.countGoodArrays(
                3, 2, 1
        ));
        System.out.println("==================");
    }

//    math , 费马小定理, 逆元

    /**
     * 有费马小定理 + 逆元可以的公式
     * 假设 p为质数,则有 a^(p-1) %p = 1; // 费马小定理.
     * 即 a^(p-2) %p = a^-1 %p ;
     */
    static final int mod = 1000_000_007;
    static final int N = 100_005;
    static final long[] fa = new long[N]; // n!
    static final long[] rfa = new long[N]; // (n!)^(p-2)

    static {
        rfa[0] = 1;
        fa[0] = 1;  // 修改初始化值为0! = 1
        for (int i = 1; i <N; i++) {  // 修改循环条件，确保计算到n
            fa[i] = fa[i - 1] * i % mod;
            rfa[i] = pow(fa[i], mod - 2, mod);
        }
    }

    private static long pow(long a, int n, int mod) {
        long res = 1;
        a = a % mod;  // 先对底数取模
        while (n != 0) {
            if ((n & 1) == 1) {
                res = res * a % mod;  // 使用取模确保不会溢出
            }
            a = a * a % mod;  // 使用临时变量避免自乘导致的精度问题

            n /= 2;
        }
        return res;
    }

    // c(a,b) = a!/(b!*(a-b)!) = a! *(b!)^(mod-2) * (a-b)!^(mod-2)
    // 即 fa[a] * rfa[b] * rfa[a-b]
    long comb(int a, int b, int mod) {
        if (b < 0 || b > a) return 0;  // 添加边界检查
        return fa[a] * rfa[b] % mod * rfa[a - b] % mod;  // 添加每步取模操作
    }

    /***
     * n 个数, -> n-1个数对,  题目要求k个数对元素相同, 那么也就是说 n-1-k 个数对元素不同.
     * 那么共有 C(n-1,n-1-k)中 选择. 其中每一个数对的选择数量是 m * (m-1)^(n-1-k) 中
     * 元素
     * @param n
     * @param m
     * @param k
     * @return
     */
    public int countGoodArrays(int n, int m, int k) {
        if (n == 0 || m == 0) return 0;  // 添加边界检查
        long sum = (long) m * pow(m - 1, n - 1 - k, mod) % mod;

        // 修改组合数计算，使用正确的参数顺序并防止负数指数
        return (int) (comb(n - 1, k, mod) * sum % mod);
    }

}


