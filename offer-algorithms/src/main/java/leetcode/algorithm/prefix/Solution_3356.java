package leetcode.algorithm.prefix;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3356 {

    public static void main(String[] args) {
        Solution_3356 sol = new Solution_3356();
        System.out.println(sol.minZeroArray(new int[]{
//                2, 0, 2
                0, 8
        }, new int[][]{
//                {0, 2, 1}, {0, 2, 1}, {1, 1, 3}
                {0, 1, 4},
                {0, 1, 1},
                {0, 1, 4},
                {0, 1, 1},
                {1, 1, 5},
                {0, 1, 2},
                {1, 1, 4},
                {0, 1, 1},
                {1, 1, 3},
                {0, 0, 2},
                {1, 1, 3},
                {1, 1, 2},
                {0, 1, 5},
                {1, 1, 2},
                {1, 1, 5}
        }));
        System.out.println("==================");
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        if (nums.length == 1 && nums[0] == 0) return 0;
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum == 0) return 0;

        int n = queries.length;
        int l = 0, r = n - 1;
        int mid;
        int res = -1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (check(mid, nums.clone(), queries)) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res == -1 ? -1 : res + 1;
    }

    private boolean check(int mid, int[] nums, int[][] queries) {
        int[] diff = new int[nums.length + 1];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
        for (int i = 0; i <= mid; i++) {
            diff[queries[i][0]] -= queries[i][2];
            diff[queries[i][1] + 1] += queries[i][2];
        }
//        int sum = diff[0]; // reason: 没有处理diff[0] >0 的情况.
//        for (int i = 0; i < nums.length; i++) {
//            sum = sum + diff[i];
//            if (sum > 0) return false;
//        }
        // ///  right way to handle this.
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += diff[i];
            if (sum > 0) return false;
        }
        return true;
    }
}


