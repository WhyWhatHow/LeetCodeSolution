package leetcode.algorithm.dp;

import java.util.ArrayList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2787 {

    public static void main(String[] args) {
        Solution_2787 sol = new Solution_2787();

        System.out.println(sol.numberOfWays(
//                10, 2
                4, 1
        ));
        System.out.println("==================");
    }

    /**
     * 设f[i][j] 表示[0,i) 范围内 和为j 的方案数.
     * 注: i 对应的是 数字范围是 a^x<=n,  其val = a^x 的数量.
     * f[i][j] = f[i-1][j]  //不选则a[i-1] 数字
     * +
     * f[i-1][j-val] // a[i-1] =val , 选择a[i-1] 数字之和.
     *
     * @param n
     * @param x
     * @return
     */
    public int numberOfWays(int n, int x) {
        ArrayList<Integer> list = new ArrayList<>();
        // init arrays
        for (int i = 1; i <= n; i++) {
            int val = (int) Math.pow(i, x);
            if (val > n) break;
            list.add(val);
        }

        int[][] f = new int[list.size() + 1][n + 1]; // f[i][j] means [0,i) range sum=j, the number of ways.
//        for (int i = 0; i < f.length; i++) {
//            Arrays.fill(f[i], -1);
//        }
        f[0][0] = 1;
        for (int i = 1; i <= list.size(); i++) {
            int val = list.get(i - 1);
            for (int j = 0; j <= n; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= val) {
                    f[i][j] += f[i - 1][j - val] % mod;
                }
            }
        }
        return f[list.size()][n] % mod;
//        return dfs(f, list, list.size(), n);


    }

    int mod = 1000_000_007;

    // dfs(i,j) means [0,i) 个数字中, and sum =j ways .
    private int dfs(int[][] f, ArrayList<Integer> list, int i, int j) {
        if (i == 0) return j == 0 ? 1 : 0;
        if (j < 0) return 0;

        if (f[i][j] != -1) return f[i][j];

        int res = dfs(f, list, i - 1, j); // 不选择当前数量.
        int val = list.get(i - 1);

        if (j >= val)
            res += dfs(f, list, i - 1, j - val); // 选择使用数字
        return f[i][j] = res % mod;
    }
}