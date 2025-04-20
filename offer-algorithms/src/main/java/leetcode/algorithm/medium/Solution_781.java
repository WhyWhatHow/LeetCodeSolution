package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_781 {

    public static void main(String[] args) {
        Solution_781 sol = new Solution_781();
        System.out.println(sol.numRabbits(new int[]{
                2, 2, 2, 2
        }));
        System.out.println("==================");
    }

    public int numRabbits(int[] answers) {
        int n = answers.length;
        int[] nums = new int[1001];
        for (int answer : answers) {
            nums[answer]++;
        }
        int res = nums[0]; // 每一个颜色都不同
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (nums[i] > i)
                    res += (i + 1) * Math.ceilDiv(nums[i], i + 1);
                else
                    res += nums[i] + 1;
            }
        }
        return res;

    }

}


