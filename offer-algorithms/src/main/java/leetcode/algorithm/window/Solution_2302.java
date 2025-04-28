package leetcode.algorithm.window;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2302 {

    public static void main(String[] args) {
        Solution_2302 sol = new Solution_2302();
        System.out.println(sol.countSubarrays(new int[]{
                        2, 1, 4, 3, 5
                },
                10
        ));
        System.out.println("==================");
    }

    /**
     * f[i] means [0,i] sum of nums,
     *
     * @param nums
     * @param k
     * @return
     */
    public long countSubarrays(int[] nums, long k) {
        long cnt = 0;
        long sum = 0; // means [0,i] sum
        int l = 0;
        int n = nums.length;

        // 枚举右, 维护左
        for (int r = 0; r < n; r++) {
            sum += nums[r];
            // 移除无效数组
            while (sum * (r - l + 1) >= k) {
                sum -= nums[l++];
            }
            // 统计依r结尾的所有有效数组.
            cnt += r - l + 1;
        }
        return cnt;
    }

}


