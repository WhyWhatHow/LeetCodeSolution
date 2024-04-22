package leetcode.algorithm.dp;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_1143 {

    public static void main(String[] args) {
        Solution_1143 sol = new Solution_1143();
        int i = sol.longestCommonSubsequence(
//                "abcde", "ace"
                "abc","def"
        );
        System.out.println(i);

        System.out.println("==================");
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        char[] x = text1.toCharArray();
        char[] y = text2.toCharArray();
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (x[i - 1] == y[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[x.length ][y.length ];

    }
}


