package leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3153 {

    public static void main(String[] args) {
        Solution_3153 sol = new Solution_3153();
        System.out.println(sol.sumDigitDifferences(new int[]{
                //                10, 10, 10
                13, 23, 12
        }));
        System.out.println("==================");
    }


    /**
     * 统计 每个位中, 不同元素的数量.
     *
     * 统计每一个位中, 0-9, 出现的次数.
     * 假设 nums 一共有 5 个数字, 分别是1,2,3,1,1 ; 对应的元素数量是{1:3}, {2:1}{3,1}
     * 对于1 而言, 数量差是 3 * 2 =6;  (1 用掉了, nums中划掉1, nums.len : 5 -> 2
     * 对于2 而言,         1 * 1 = 1; (2 用掉后, nums.len : 2 -> 1
     * 对于3 而言,         1* 0 = 0;  (3 用掉后, nums.len : 1->0 (没有其他元素了)
     * 结果是7
     * @param nums
     * @return
     */
    public long sumDigitDifferences(int[] nums) {
        Arrays.sort(nums);
        long res = 0;
        int len = String.valueOf(nums[0]).length();
        int[][] cnt = new int[len][10]; //

        // init
        for (int num : nums) {
            // count 
            for (int i = 0; i < len; i++) {
                cnt[i][num % 10]++;
                num /= 10;
            }
        }
        for (int[] ints : cnt) {

            int n = nums.length;
            for (int i : ints) {

                if (i != 0) {
                    n -= i;
                    res += (long) i * n;
                }
            }
        }
        return res;

    }
}


