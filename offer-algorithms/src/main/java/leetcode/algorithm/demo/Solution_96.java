package leetcode.algorithm.demo;

/**
 *
 */
public class Solution_96 {

    public static void main(String[] args) {
        System.out.println(4>>1);
        Solution_96 sol = new Solution_96();
        System.out.println("==================");
        int i = sol.numTrees(3);
        System.out.println(i);
    }

    /***
     * dp[i] 表示 i个节点构成的 二叉搜索树情况.
     * dp[0] =1 ,dp[1]=1; dp[2]=2; dp[3]= 5; dp[4]=14;
     * 举例:
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp =new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i = 2; i<=n ;i++){
            for(int j = 0;j<i;j++ )
                dp[i]+=dp[i-j-1]*dp[j];
        }
        return dp[n];
    }
}


