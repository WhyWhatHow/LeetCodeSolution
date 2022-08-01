package leetcode.algorithm.demo;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_698 {

    public static void main(String[] args) {
        Solution_698 sol = new Solution_698();
        System.out.println("==================");
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        boolean res =false;
        int sum = 0 ;
        for (int num : nums) {
            sum+=num;
        }
        if(sum % k!=0) return false ; // 不可等分
        sum/=k;
        boolean[] vis = new boolean[nums.length];
        for (int i = 0; i < k; i++) {
            res = res &judge(nums,vis,sum);
        }
        return res ;
    }

    private boolean judge(int[] nums, boolean[] vis, int sum) {
        int[] dp =new int[sum+1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = dp.length - 1; j >= nums[i] &&!vis[i]; j--) {
                vis[i] =true ;
                dp[j] =Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[sum]==sum;
    }
}


