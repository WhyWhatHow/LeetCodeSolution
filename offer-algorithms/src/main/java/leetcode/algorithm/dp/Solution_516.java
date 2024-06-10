package leetcode.algorithm.dp;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_516 {

    public static void main(String[] args) {
        Solution_516 sol = new Solution_516();
        int i = sol.longestPalindromeSubseq(
                "bbbab"
        );
        System.out.println(i);

        System.out.println("==================");
    }

    /**
     * # 1 . dp :
     * dp[i][j] subString [i,j] : subString(i,j) 的最大回文子串
     * s[i] == s[j] ==> dp[i][j] = dp[i+1][j-1]+2
     * else         ==> dp[i][j] = max(dp[i][j-1], dp[i+1][j])
     *
     * # 2 init dp:
     *  dp[i][i] =1 ;
     *
     * # 3 . vis order :
     * i (n->0) , j (i+1,n)
     *
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int[][] dp = new int[chars.length][chars.length];
        // init
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < dp.length; j++) {
                if (chars[i] == chars[j]) { // [i,j]'s substring
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][chars.length - 1];

    }
}


