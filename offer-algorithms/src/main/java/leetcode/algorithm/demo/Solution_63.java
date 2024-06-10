package leetcode.algorithm.demo;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_63 {

    public static void main(String[] args) {
        Solution_63 sol = new Solution_63();
        System.out.println("==================");
    }


    /**
     *  路障通路 , 思路 : 保证通络
     * dp[i][j] =0 , 表示当前地点不可到达 ,未通路
     * dp[i][j]!=0 , 表示通路
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1)
            return 0 ;
        int[][] dp =new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0]=1;
        for(int i = 1 ; i< dp.length;i++){
            // 保证可达
            if(obstacleGrid[i][0]==0 && dp[i-1][0]==1)
                dp[i][0]=1 ;
        }
        for(int i = 1 ; i< dp[0].length;i++)
            // 保证 可达
            if(obstacleGrid[0][i]==0 && dp[0][i-1]==1)
                dp[0][i] =1;

        for(int i=1; i< dp.length; i++){
            for(int j= 1; j<dp[0].length;j++){
                if(obstacleGrid[i][j]== 0 ){
                    // 左侧通路
                    if(dp[i-1][j] != 0 ){
                        dp[i][j]+=dp[i-1][j];
                    }
                    // 上方通路
                    if(dp[i][j-1]!=0){
                        dp[i][j]+=dp[i][j-1];
                    }
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    /**
     *  优化版本
     */
    public int uniquePathsWithObstaclesBetter(int[][] obstacleGrid) {
        int[][] dp =new int[obstacleGrid.length][obstacleGrid[0].length];
        // 边界初始化
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        for(int i =0 ; i< m ;i++){
            if(obstacleGrid[i][0]==1) break ; //  不可达
            dp[i][0]=1;
        }
        for(int i =0 ; i< n ;i++){
            if(obstacleGrid[0][i]==1) break ; //  不可达
            dp[0][i]=1;
        }
        for(int i = 1; i<m ;i++){
            for(int j=1 ;j< n ;j++){
                if(obstacleGrid[i][j]==1) continue ;
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];

    }
}


