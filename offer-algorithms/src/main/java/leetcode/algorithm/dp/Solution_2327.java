package leetcode.algorithm.dp;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2327 {

    public static void main(String[] args) {
        Solution_2327 sol = new Solution_2327();
        System.out.println(sol.peopleAwareOfSecret(
//                684, 18, 496
                6, 2, 4
        ));
        System.out.println("==================");
    }

    int mod = 1000_000_007;

    // f[i] means in day i, we have f[i] number of people know the secret(include the people will forget secret in day i).
    // 对于第i天, 前forget天即i-forget 的人会忘记秘密,
    //          同样, 前 delay天的人会开始传递秘密.
    // 那么 对于f[i] =f[i-1] + f[i-delay] - f[i-forget] % mod ;
    // 我们要的结果就是 f[n] -f[n-forget]
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] f = new int[n + 1]; // f[i] means in day i, we have f[i] number of people know the secret.
        // f[i] = f[i-1] + f[i-delay] - f[i-forget]
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            long val = f[i - 1];
//            long val = 0 ;
            val += i < delay ? 0 : f[i - delay];
            val -= i < forget ? 0 : f[i - forget];
            f[i] = (int) ((val) % mod);
        }
        return (f[n] - f[n - forget]+mod) % mod;
    }

}


