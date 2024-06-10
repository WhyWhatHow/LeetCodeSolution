package leetcode.algorithm.demo;


public class Solution_416 {

    public static void main(String[] args) {
        Solution_416 sol = new Solution_416();
        System.out.println("==================");
        System.out.println(4&1);
        boolean b = sol.canPartition(new int[]{1, 2,3, 5});
        System.out.println(b);
    }
    public boolean canPartition(int[] nums) {
        int sum = 0 ;
        for(int i = 0 ; i<nums.length; i++){
            sum+=nums[i];
        }
        if((sum &1)!=0) return false; //  奇数, 整数划分失败
        sum= sum>>1;  // package weight

        int[] dp = new int[sum+1];
        dp[0] = 0;
        boolean res =false ;
        for(int i = 0 ; i< nums.length; i++){
            for(int j = sum; j>=nums[i];j--){

                dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);

            }
        }
//        System.out.println("dp------------>");
//        for (int i : dp) {
//            System.out.println(i);
//        }
        return dp[sum] ==sum ;
    }

    /**
     * o1 背包 模板
     */
    void test(){
        int[] weight = new int[]{1,2,3};
        int[] value = new int[]{10,2,33};
        int[] dp = new int[10];
        dp[0] = 0 ;
        for (int i = 0; i < weight.length; i++) {
            for(int j = dp.length-1; j>=weight[i];j-- )
                dp[j] = Math.max(dp[j],dp[j-weight[i]]+value[i]);
        }
    }
}


