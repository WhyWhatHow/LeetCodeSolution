package leetcode.algorithm.dp;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1931 {

    public static void main(String[] args) {
        char[] cs = String.valueOf(321).toCharArray();
        Solution_1931 sol = new Solution_1931();

        System.out.println(sol.colorTheGrid(
//                1, 2
                5, 5
        ));
        System.out.println("==================");
    }

    int mod = 1000_000_007;
    int[] p;
    int m;

    /**
     * 红,绿,蓝, 分别用0,1,2 表示,那么对于第i列 可以的取值范围是3^m(有m行, 所以所有的出现情况是3^m次, 去掉不符合题意的数据后,会少很多)
     * 这样处理完 , 元题意中的m行n列-> 1行n列 中判断相邻数据是否有效的情况.
     */
    public int colorTheGrid(int m, int n) {
        this.m = m;
        p = new int[m]; // 表示 每一个位所取到的最大值.
        p[0] = 1;
        for (int i = 1; i < m; i++) {
            p[i] = p[i - 1] * 3;
        }

        // 获取符合题意的数据.
        List<Integer> q = genQualifiedNum(m, p);
        int[][] f = new int[n][q.size()]; // f[i][j] 表示前i列, 且第i列的值是q.get(i)的情况下 方案数.
        // f[i][j] = f[i-1][k] , k取值范围(枚举q中的每一个元素)
        for (int i = 1; i < f.length; i++) {
            Arrays.fill(f[i], -1);
        }
        Arrays.fill(f[0], 1); // 默认值

        long res = 0;

        for (int i = 0; i < f[n - 1].length; i++) {
            res += dfs(n - 1, i, f, q);
            if (res > mod) res %= mod;
        }

        return (int) (res % mod);
    }

    private int dfs(int i, int j, int[][] f, List<Integer> q) {
//        if (i == 0) return f[i][j];
        if (f[i][j] != -1) return f[i][j];
        int cur = q.get(j);
        int res = 0;
        for (int k = 0; k < q.size(); k++) {
            if (check(cur, q.get(k), m)) {
                res += dfs(i - 1, k, f, q);
                if (res > mod) res %= mod;
            }
        }
        return f[i][j] = res;
    }

    // 判断cur , num 是否可以相邻.
    private boolean check(int cur, Integer num, int m) {
        if (cur == num) return false;
        while (m-- > 0) {
            if (cur % 3 == num % 3) return false;
            cur /= 3;
            num /= 3;
        }
        return true;
    }

    private List<Integer> genQualifiedNum(int m, int[] p) {
        List<Integer> q = new ArrayList<>();

        for (int i = 0; i < 3 * p[m - 1]; i++) {
            boolean yes = true;
            for (int j = 1; j < m; j++) {
                if ((i / p[j - 1]) % 3 == (i / p[j]) % 3) {
//                if (i % p[j - 1] == i % p[j]) { //wrong ,
                    yes = false;
                    break;
                }
            }
            if (yes) q.add(i);
        }
        return q;
    }
    /***
     *🧠 类比十进制理解
     假设你有一个十进制数 i = 5827，想提取百位（第2位）的数字：
     权重：p[j] = 10^j → p[2] = 100
     右移低位：5827 / 100 = 58（去掉个位和十位）
     取当前位：58 % 10 = 8（得到百位的8）
     如果直接 5827 % 1000（即 p[3]）= 827 → 包含百位、十位、个位的总和，无法单独提取百位。


     */


}


