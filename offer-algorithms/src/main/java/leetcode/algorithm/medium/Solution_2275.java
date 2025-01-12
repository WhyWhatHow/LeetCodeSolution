package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2275 {

    public static void main(String[] args) {
        System.out.println(Integer.bitCount(16));
        System.out.println(Integer.toBinaryString(16));
        String format = String.format("%032d", 16);
        System.out.println(format);
        Solution_2275 sol = new Solution_2275();
        System.out.println(sol.largestCombination(new int[]{
                16,17,71,62,12,24,14
        }));
        System.out.println("==================");
    }

    public int largestCombination(int[] candidates) {
        int[] nums = new int[32];
        for (int candidate : candidates) {
            String s = Integer.toBinaryString(candidate);
            putStringToNums(s, nums);
        }
        int max = 0;
        for (int num : nums) {
            max =Math.max(num,max);
        }
        return max;
    }

    private void putStringToNums(String s, int[] nums) {
        int len = s.length();
        int k = 0;
        for (int i = nums.length - len; i < nums.length; i++) {
            if (s.charAt(k++) == '1') nums[i]++;
        }
    }
}
