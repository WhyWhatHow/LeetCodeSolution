package leetcode.algorithm.dfs;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1863 {

    public static void main(String[] args) {
        Solution_1863 sol = new Solution_1863();
        System.out.println(sol.subsetXORSum(new int[]{1, 3}));
        System.out.println("==================");
    }

    int res;

    public int subsetXORSum(int[] nums) {
        res = 0;
        dfs(0, 0, nums);
        return res;
    }

    //
    private void dfs(int i, int presum, int[] nums) {
        if (i >= nums.length) return;

        // not chose i
        dfs(i + 1, presum, nums);
        // chose i
        presum ^= nums[i];
        dfs(i + 1, presum , nums);
        res += presum;


    }
}


