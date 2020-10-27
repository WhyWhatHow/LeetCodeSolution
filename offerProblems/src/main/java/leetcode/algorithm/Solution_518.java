package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_518 {
    public int change(int amount, int[] coins) {
        if (coins.length == 0) {
            return -1;
        }
        dfs(coins, amount);
        return this.cnt == 0 ? -1 : this.cnt;
    }

    int cnt = 0;

    void dfs(int[] nums, int sum) {
        if (sum == 0) {
            this.cnt++;
            return;
        }
        for (int num : nums) {
            sum -= num;
            if (sum >= 0) {
                dfs(nums, sum);
            }
            sum += num;
        }
    }

    public static void main(String[] args) {
        Solution_518 sol = new Solution_518();
        int change = sol.change(5, new int[]{1, 2, 5});
        System.out.println(change);
    }
}


