package leetcode.algorithm.window;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_713 {

    public static void main(String[] args) {
        Solution_713 sol = new Solution_713();
        System.out.println("==================");
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int cnt = 0;
        int n = nums.length;
        int l = 0;
        long res = 1;
        for (int i = 0; i < n; i++) {
            res *= nums[i];
            while (res > k && l <= i) {
                res /= nums[l++];
            }
            cnt += i - l + 1;
        }
        return cnt;
    }

}


