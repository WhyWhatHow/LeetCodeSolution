package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_523 {

    public static void main(String[] args) {
        Solution sol = new Solution();
//        int[] nums = new int[]{28, 54, 7, -70, 22, 65, -6};
//        int[] nums = new int[]{1, 0};
        int[] nums =new int[]{23,2,6,4,7};
        int k = 0;

        boolean b = sol.checkSubarraySum(nums, k);
        System.out.println(b);
//        System.out.println( sol.isValid("()"));
    }
}

class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        boolean res = false;
        if (nums.length < 2) {
            return false;
        }
//        int pre = 0;
//        HashMap<Integer, Integer> map = new HashMap<>();
        int pre[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                pre[i] = nums[i];
                continue;
            }
            pre[i] = pre[i - 1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = pre[j] - pre[i];
                if (pre[j] == k || (k != 0 && sum >=k && sum % k == 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}