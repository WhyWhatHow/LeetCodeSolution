package leetcode.algorithm.hard;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_132 {

    public static void main(String[] args) {
        Solution_132 sol = new Solution_132();
        String[] test = new String[]{
                "abc",
                "aba",
                "aaa",
                "aab"
        };
        for (String s : test) {
            System.out.println(sol.minCut(s));
            ;
        }
        System.out.println("==================");
    }


    int[] f;
    boolean[][] isPal;

    /***
     * 状态定义合理：dfs(i) 表示前i个字符的最小分割次数是常规解法
     * 转移方程正确：dfs(i) = min(dfs(j)+1) 其中 s[j+1..i] 是回文子串
     * 边界条件需要调整：当s[0..i]本身是回文时分割次数应为0
     * @param s
     * @return
     */
    //abccba
    public int minCut(String s) {
        char[] cs = s.toCharArray();
        init(cs);

        f = new int[cs.length];
        Arrays.fill(f, -1);
        dfs(cs, cs.length - 1);
        return f[cs.length - 1];
    }


    /**
     * dfs(i) means s[0,i] 中最少分割次数.
     * dfs (i) = Min(dfs(j))+1; // j属于[0,i) 范围.
     *
     * @param cs
     * @param i
     * @return
     */
    private int dfs(char[] cs, int i) {
        if (isPal[0][i]) { // 如果[0,i] 是回文.
            f[i] = 0;
            return 0;
        }

        if (f[i] != -1) return f[i];

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < i; j++) {
            if (isPal[j + 1][i]) // s[j,i] 是回文.
                res = Math.min(res, dfs(cs, j) + 1);
        }
        f[i] = res;
        return res;
    }

    // TAG [whywhathow] [2025/3/2] 如何记录string 中回文的下标.
    // 打表, 标记[0,n) 范围内所有的回文.
    private void init(char[] cs) {
        int n = cs.length;
        isPal = new boolean[n][n];

        // 逆序遍历：i从右向左，j从左向右扩展
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                // 核心判断条件：
                if (j - i <= 2) // "a" "aa" "aba"
                    isPal[i][j] = cs[i] == cs[j];
                else { //"abcdcba"
                    isPal[i][j] = cs[i] == cs[j] && isPal[i + 1][j - 1];
                }
            }
        }
    }
}


