package leetcode.algorithm.dp;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1745 {

    public static void main(String[] args) {
        Solution_1745 sol = new Solution_1745();
        System.out.println(sol.checkPartitioning(
//                "abcbdd"
//                "abac"
                "tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttxxvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv"
        ));
        System.out.println("==================");
    }

    int[][] f;
    boolean[][] isPal; // 标记s[l,r] 是否是回文

    public boolean checkPartitioning(String s) {
        char[] cs = s.toCharArray();
        f = new int[cs.length][4];


        init(cs);

        dfs(cs, cs.length - 1, 3);
        return f[cs.length - 1][3] != 0;
    }

    // f[i][k]>0 => S[0,i] range has K PalString.
    private int dfs(char[] cs, int i, int k) {
        if (k <= 0) return 0;
        if (isPal[0][i] && k == 1) return f[i][k] = 1;
        if (f[i][k] != 0) return f[i][k];
        int res = 0;
        for (int l = 0; l < i; l++) {
            if (isPal[l + 1][i]) {
                res = dfs(cs, l, k - 1);
                if (res != 0) break;
            }
        }
        f[i][k] = res;
        return res;
    }

    private void init(char[] cs) {
        int n = cs.length;
        isPal = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (j - i <= 2) isPal[i][j] = cs[i] == cs[j];
                else
                    isPal[i][j] = cs[i] == cs[j] && isPal[i + 1][j - 1];
            }
        }
    }
}


