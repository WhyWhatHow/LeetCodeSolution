package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3201 {

    public static void main(String[] args) {
        Solution_3201 sol = new Solution_3201();

        System.out.println("==================");
    }

    public int maximumLength(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] & 1;
        }
        // 000000 , 11111111
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                res++;
            } else {
                cnt++;
            }
        }
        res = Math.max(res, cnt);

        // 0101,
        cnt = doHandle(0, 0, nums);
        res = Math.max(res, cnt);
        // 1010
        cnt = doHandle(0, 1, nums);
        res = Math.max(res, cnt);
        return res;
    }

    private int doHandle(int cnt, int prev, int[] nums) {

        for (int num : nums) {
            if (num == prev) {
                cnt++;
                prev = prev == 0 ? 1 : 0;
            }
        }
        return cnt;
    }

}


