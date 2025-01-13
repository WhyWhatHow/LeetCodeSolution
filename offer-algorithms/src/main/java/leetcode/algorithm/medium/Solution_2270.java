package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2270 {

    public static void main(String[] args) {
        Solution_2270 sol = new Solution_2270();
        System.out.println("==================");
    }

    public int waysToSplitArray(int[] nums) {
        long[] a = new long[nums.length];
        a[0] = nums[0];
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int cnt = 0;
        for (int i = 0; i < a.length-1; i++) {
            if (i != 0) {
                a[i] = a[i - 1] + nums[i];
            }

            if (a[i] >= sum - a[i]) cnt++;
        }
        return cnt;
    }

}
