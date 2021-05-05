package dataSturcture;

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

                res *=x ;
            }
            x*=x;
            n =n>>1; // 右移一位
        }
        return res ;
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
            if ((n & 1) == 1) {
                // odd
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

    void getPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (!vis[i]) {
                prime[cnt++] = i;
                for (int j = i << 1; j < n; j += i) {
                    vis[j] = true;
                }
            }
        }
    }

}
