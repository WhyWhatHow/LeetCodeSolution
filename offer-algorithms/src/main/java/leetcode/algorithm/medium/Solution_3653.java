package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3653 {

    public static void main(String[] args) {
        Solution_3653 sol = new Solution_3653();//

        System.out.println("==================");
    }

    //    queries[i] = [li, ri, ki, vi]
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod = 1000_000_007;
        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];
            for (int i = l; i <= r; i += k) {
                nums[i] = (int) (1l*nums[i] * v % mod);
            }
        }
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

}
