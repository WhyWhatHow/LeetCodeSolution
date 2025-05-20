package leetcode.algorithm.prefix;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3355 {

    public static void main(String[] args) {
        Solution_3355 sol = new Solution_3355();
        System.out.println(sol.isZeroArray(new int[]{
//                1, 0, 1
                4, 3, 2, 1
        }, new int[][]{
//                {0, 2}
                ///
                {1, 3}, {0, 2}
        }));
        System.out.println("==================");
    }
    // 差分数组

    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] diff = new int[nums.length + 1];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
        for (int[] q : queries) {
            diff[q[0]]--;
            diff[q[1] + 1]++;
        }
        nums[0] = diff[0];
        if (nums[0] > 0) return false;
        for (int i = 1; i < nums.length; i++) {
//            if (i == 0) nums[i] += diff[i];
//            else
            nums[i] = nums[i - 1] + diff[i];
            if (nums[i] > 0) return false;
        }
        return true;
    }

}


