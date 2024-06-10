package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_91 {
    /**
     * dp[i]: 表示 i下标可以 标记的元素数 ,
     * i=0 : dp[i]=1 (char[i]!='0'); dp[i]=0 char[i]='0'
     * i>0:
     * char[i]=0 : dp[i] =dp[i-1]
     * char[i]!=0:
     *      char[i-1] =0 : dp[i] =dp[i-2]
     *      令 x = s.subString(i-1,2);
     *      char[i-1]!=0    ji  10<=x<=26 : dp[i]+=dp[i-1]+dp[i-2];
     * ============================================
     * dp[i] 表示i下标 所标记的元素数.
     * i下标可以标记的元素类型有两种, 要么是 [i] ,[i-1,i] 的字母,
     * [i] : 最后一个位置确定 一个字母 : dp[i]+=dp[i-1]
     * [i-1,i]: 最后两个位置表示一个字母: dp[i]+=dp[i-2]
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            int temp = c - '0';
            if (temp > 0 && temp < 10) {
                dp[i] += dp[i - 1];
            }
            char cc = chars[i - 1];
            int temp1 = cc - '0';
            if (temp1 > 0 && temp1 < 3 && temp > 0 && temp < 7) {
                if (i>1) {
                    dp[i] += dp[i - 2];
                }else{
                    dp[i]++;
                }
            }
        }
        return dp[n - 1];

    }

    public static void main(String[] args) {
        Solution_91 sol = new Solution_91();
        int i = sol.numDecodings("226");
        System.out.println(i);
//        int i1 = sol.numDecodings("2226");
        int i1 = sol.numDecodings(
                "2611055971756562"
        );
        System.out.println(i1);
        System.out.println("==================");
    }
}


