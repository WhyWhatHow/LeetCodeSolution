package leetcode.algorithm.hard;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3171 {

    public static void main(String[] args) {
        Solution_3171 sol = new Solution_3171();
        System.out.println(Integer.toBinaryString(1_000_000_000).length());
        System.out.println("==================");
    }

    /**
     * nums :  2,   3,    6,   5,  4
     * ->     010, 011,  110, 101,100
     * i=1 :  011, 011,
     * i=2 :  111, 111,  110,
     * i=3 :  111, 111,  111, 101,
     * i= 4:  111, 111,  111, 111, 100
     *
     * @param nums
     * @param k
     * @return
     */
    public int minimumDifference(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            ans = Math.min(ans, Math.abs(x - k)); // nums[i] 作为子数组时候的值.
            for (int j = i - 1; j >= 0; j--) {
                if ((nums[j] | x) == nums[j]) break;
                nums[j] = nums[j] | x;
                ans = Math.min(ans, Math.abs(nums[j] - k));
            }
        }
        return ans;
    }
}


