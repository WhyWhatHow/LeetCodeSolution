package leetcode.algorithm.window;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2962 {

    public static void main(String[] args) {
        Solution_2962 sol = new Solution_2962();
        System.out.println("==================");
    }

    public long countSubarrays(int[] nums, int k) {
        long res = 0;
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int cnt = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == max) {
                cnt++;
            }
            while (cnt == k ) {
                res += nums.length - r;
                if (nums[l] == max) cnt--;
                l++;
            }
        }
        return res;

    }
}


