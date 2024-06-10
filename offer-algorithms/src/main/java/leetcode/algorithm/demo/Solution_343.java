package leetcode.algorithm.demo;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_343 {

    public static void main(String[] args) {
        Solution_343 sol = new Solution_343();
        System.out.println("==================");
        int i = sol.integerBreak(10);
        System.out.println(i);
    }

    /**
     * dp[i] 表示 数字i的最大 累积值
     * dp[i] = max (dp[i-j]*j, (i-j)*j), j from [2...i]
     *      dp[i-j]* j ,  拆到i-j 基础后,将(i-j) 继续拆的情况,
     *       (i-j) *j ,    拆到i-j后不再拆的情况.
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int[] dp =new int[n+1];
        dp[2]=1;
        for(int i = 3; i<=n;i++){
            for(int j =2; j< i;j++){
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
        }
        return dp[n];
    }
}


