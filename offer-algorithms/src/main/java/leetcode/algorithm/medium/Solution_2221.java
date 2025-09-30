package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2221 {

    public static void main(String[] args) {
        Solution_2221 sol = new Solution_2221();
        System.out.println(sol.triangularSum(new int[]{
//                1, 2, 3, 4, 5
                8
        }));
        System.out.println("==================");
    }

    public int triangularSum(int[] nums) {
        int[] as;
        as = genArray(nums);
        while (as.length > 1) {
            as = genArray(as);
        }
        return as[0];
    }

    private int[] genArray(int[] nums) {
        if (nums.length == 1) return nums;
        int n = nums.length;
        int[] rs = new int[n - 1];
        int cnt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            rs[cnt++] = (nums[i] + nums[i + 1]) % 10;
        }
        return rs;
    }

}


