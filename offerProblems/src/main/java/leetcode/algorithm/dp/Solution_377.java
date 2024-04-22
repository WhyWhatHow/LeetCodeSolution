package leetcode.algorithm.dp;

/**
 * @program: LeetCodeSolution
 * @description:  #dp
 * @author: WhyWhatHow
 **/

public class Solution_377 {

    public static void main(String[] args) {
        Solution_377 sol = new Solution_377();
        System.out.println("==================");
        int i = sol.combinationSum4(new int[]{1, 2, 3}, 4);
        System.out.println(i);
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

//    int cnt = 0;
//    LinkedList tempList = new LinkedList();
//
//    private void dfs(int[] nums, int target, int start) {
//        if (target < 0) return;
//        if (target == 0) {
//            cnt++;
//            tempList.forEach(System.out::print);
//            System.out.println("========");
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            target -= nums[i];
//            tempList.push(nums[i]);
//            dfs(nums, target, i);
//            target += nums[i];
//            tempList.pop();
//        }
//    }

}


