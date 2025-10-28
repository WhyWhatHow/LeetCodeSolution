package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3354 {

    public static void main(String[] args) {
        Solution_3354 sol = new Solution_3354();
        System.out.println(sol.countValidSelections(new int[]{1, 0, 2, 0, 3}));
        System.out.println("==================");
    }

    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int[] ls = new int[n];
        int[] rs = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                ls[i] = sum;
                // sum = 0;
            } else
                sum += nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                rs[i] = sum;
                // sum = 0;
            } else {
                sum += nums[i];
            }
        }
        int res = 0;
        boolean yes = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0 && ls[i] == rs[i]) {
                res++;
            }
            if (nums[i] == 0 && Math.abs(ls[i] - rs[i]) == 1) {
                res++;
                yes = false;

            }
        }

        return yes ? res * 2 : res;
    }
}


