package leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1458 {

    public static void main(String[] args) {
        Solution_1458 sol = new Solution_1458();
        System.out.println("==================");
    }

    // DP[i][j] as the maximum dot product of two subsequences starting in the position i of nums1 and position j of nums2.
    //  set t = a[i]*b[j]
    // 对f[i][j] 而言, 我们必须使用

    //    f(i, j) = max(
    //            f(i-1, j-1) + nums1[i] * nums2[j],  # 用当前元素对，连接前面
    //    nums1[i] * nums2[j],                 # 只用当前元素对，重新开始
    //    f(i-1, j),                           # 不用 nums1[i]
    //    f(i, j-1)                            # 不用 nums2[j]
    //            )
    int min = -2000000;
    public int maxDotProduct(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i < f.length; i++) {
            Arrays.fill(f[i], min);
        }
        return dfs(n - 1, m - 1, a, b, f);

    }

    // set f(i,j) means [0,i]for a, and [0,j] for j maxVal ;
    private int dfs(int i, int j, int[] a, int[] b, int[][] f) {
        if (i < 0 || j < 0) return min;
        if (f[i][j] !=min ) return f[i][j];


        int t = a[i] * b[j];
        int res = t;
        res = Math.max(dfs(i - 1, j, a, b, f), res);
        res = Math.max(res, dfs(i, j - 1, a, b, f));
        res = Math.max(res, dfs(i-1,j-1, a,b,f)+t);
        f[i][j] =res;
        return res;
    }

}


