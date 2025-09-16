package dsa;

/**
 * @program: LeetCodeSolution
 * @description: 快速幂，以及素数筛选
 * @author: WhyWhatHow
 * @create: 2020-05-24 17:04
 **/
public class MyMath {
    /**
     * 快速幂
     *
     * @param x 处理x^- 5
     * @param n
     * @return
     */
    static double myPow(double x, long n) {
        double res = 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        while (n > 0) {
            if ((n & 1) != 0) { // 判断是否是奇数
                res *= x;
            }
            x *= x;
            n = n >> 1; // 右移一位
        }
        return res;
    }

    /**
     * 快速幂
     *
     * @param a
     * @param n
     * @return
     */
    static long pow(long a, long n) {
        if (n == 0) {
            return 1;
        }
        long ans = 1, base = a;
        while (n != 0) {
            if ((n & 1) == 1) {// odd
                ans *= base;
            }
            n >>= 1;
            base *= base;
        }
        return ans;
    }

    /**
     * 素数，欧拉筛选
     */
    final static int MAX = 10000086;
    int[] prime = new int[MAX];
    boolean vis[] = new boolean[MAX];
    int cnt = 0; //素数的个数

    void getPrime() {
        for (int i = 2; i < MAX; i++) {
            if (!vis[i]) {
                prime[cnt++] = i;
                for (int j = i << 1; j < MAX; j += i) {
                    vis[j] = true;
                }
            }
        }
    }


    // 返回 第i位对应的bit值.(从右往左数)
    // example: 11,-> 1011.   num=11,i=4,-> 1
    private static int getBitAt(int num, int i) {
        return (num >> i) & 1;
    }


    // gcd

    /**
     * 欧几里得算法（辗转相除法）
     * 这是计算GCD最常用和最高效的方法，基于以下原理：
     * 原理：gcd(a, b) = gcd(b, a % b)（其中 a > b，a % b 表示 a 除以 b 的余数）
     * 如果r是a除以b的余数（即a = bq + r），那么gcd(a, b) = gcd(b, r)。
     * ===============================
     * 欧几里得算法的关键是证明：a 和 b 的最大公约数，与 b 和 r 的最大公约数是同一个数。
     * 证明过程：
     * 设 d 是 a 和 b 的任意一个公约数，即 d 能同时整除 a 和 b（a % d == 0 且 b % d == 0）。
     * 根据 a = b×q + r，可以推出 r = a - b×q。
     * 由于 d 能整除 a 和 b，那么 d 也能整除 a - b×q（因为 b×q 是 b 的倍数，自然也是 d 的倍数），即 d 能整除 r。
     * 因此，d 也是 b 和 r 的公约数。
     * 反过来，设 d 是 b 和 r 的任意一个公约数，即 d 能整除 b 和 r。
     * 由于 a = b×q + r，a 是 b×q（b 的倍数）与 r（d 的倍数）的和，因此 d 也能整除 a。
     * 因此，d 也是 a 和 b 的公约数。
     * 结论：
     * a 和 b 的所有公约数，与 b 和 r 的所有公约数完全相同。
     * 既然公约数集合相同，那么其中最大的那个数（最大公约数）也必然相同，即：
     * gcd(a, b) = gcd(b, r) = gcd(b, a % b)。
     * ==================================
     * 算法步骤：
     * 用较大数除以较小数得到余数
     * 用较小数除以余数得到新的余数
     * 重复此过程，直到余数为0
     * 此时除数就是最大公约数
     * 示例：计算gcd(48, 18)
     * 48 ÷ 18 = 2 余 12
     * 18 ÷ 12 = 1 余 6
     * 12 ÷ 6 = 2 余 0
     * 所以gcd(48, 18) = 6
     */
    public static int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }

    // 返回x,y的最小公倍数.
    //    lcm(x,y) =x*y /gcd(x,y)
    public static int lcm(int x, int y) {
        int g = gcd(x, y);
        return x / g * y;
    }
}
