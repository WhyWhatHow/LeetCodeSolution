package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_922 {

    public static void main(String[] args) {
        Solution_922 sol = new Solution_922();
        System.out.println("==================");
    }

    public int[] sortArrayByParityII(int[] nums) {
        int[] ans = new int[nums.length];
        int c = 1, cc = 0; // c odd ,cc even
        for (int num : nums) {
            if (isOdd(num)) {
                ans[c] = num;
                c += 2;
            } else {
                ans[cc] = num;
                cc += 2;
            }
        }
        return ans;
    }

    boolean isOdd(int x) {
        return (x & 1) == 1;
    }
}
