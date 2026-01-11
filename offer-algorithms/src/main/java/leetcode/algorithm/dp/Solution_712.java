package leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_712 {

    public static void main(String[] args) {
        Solution_712 sol = new Solution_712();
        System.out.println("==================");
    }

    //给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和 。
    // 等效代换 s1,s2 ascii 码和最大的最长公共子序列 记为a .
    // 记 sum 为 (s1,s2 的ascii码的和) , 那么
    // 记 r 为题目要求的结果.
    // 则有 r = sum -max(a)
    // 那么我们可以定义 f(i,j) 表示[0,i] in s, [0,j] in s2 中 ascii码和最大的情况下的公共子序列.
    // 当 s(i) == ss[j] , f(i,j) = f(i-1,j-1) + s[i]
    // 当 s(i) != ss[j],  f(i,j) = max(f(i-1,j) , f(i,j-1) 的情况.
    public int minimumDeleteSum(String s, String s2) {
        char[] cs = s.toCharArray();
        char[] ss = s2.toCharArray();
        int[][] f = new int[cs.length][ss.length];
        for (int i = 0; i < f.length; i++) {
            Arrays.fill(f[i], -1);
        }
        int max = dfs(cs.length - 1, ss.length - 1, f, cs, ss);

        // 获取最大的ascii码
        int sum = 0;
        for (char c : cs) {
            sum += c;
        }
        for (char c : ss) {
            sum += c;
        }

        return sum - 2 * max;
    }

    // 那么我们可以定义 f(i,j) 表示[0,i] in s, [0,j] in s2 中 ascii码和最大的情况下的公共子序列.
    // 当 s(i) == ss[j] , f(i,j) = f(i-1,j-1) + s[i]
    // 当 s(i) != ss[j],  f(i,j) = max(f(i-1,j) , f(i,j-1) 的情况.

    private int dfs(int i, int j, int[][] f, char[] cs, char[] ss) {
        if (i < 0 || j < 0) return 0;

        if (f[i][j] != -1) return f[i][j];

        int res = 0;
        if (cs[i] == ss[j]) res = cs[i] + dfs(i - 1, j - 1, f, cs, ss);
        else {
            res = Math.max(dfs(i, j - 1, f, cs, ss),
                    dfs(i - 1, j, f, cs, ss));
        }
        f[i][j] = res;
        return res;
    }
}


