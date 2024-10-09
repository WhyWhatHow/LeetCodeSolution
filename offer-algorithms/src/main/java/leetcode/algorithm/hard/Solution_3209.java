package leetcode.algorithm.hard;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3209 {

    public static void main(String[] args) {
        Solution_3209 sol = new Solution_3209();
        System.out.println(Integer.toBinaryString(1_000_000_000).length());
        System.out.println(sol.countSubarrays(new int[]{
//                1, 1, 1
                        1, 2, 3
                },
//                1
                2
        ));
        System.out.println("==================");
    }


    /**
     * 前提:
     * logTrick: 将& or | 的操作结果保存到前一个元素中,举例来说,
     * 在[0,i] 范围内, nums[j] 保存的内容是 nums 中的[j,i] & 或者 | 运算结果.
        * & 集合交集运算,集合越多,数越少(right->left) : nums[i] 不变, nums[j] 从右想左看, 递减, 也就是是说, [0,i] (左到右角度)范围内  递增.
        * | 集合并集运算,集合越多,数越多(right->left): 或运算 正好相反. r->l: 递增, l->r 递减.
     * 由此,可以通过logTrick 思路,求得 子数组 对应的 & , | 操作值.
     * 题意要求 子数组&的值 记为val = k, 的数量,
     * 做法无非是 在计算完[0,i] 范围内的值后,统计 nums[j] =k 的元素数量.
     * 结合上面所说的& 操作, 从l->r 看, 数组结果会递增. 所以只需要维护一个slide_window 即可.
     * @param nums
     * @param k
     * @return
     */
    public long countSubarrays(int[] nums, int k) {
        long res = 0;
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                if ((nums[j] & x) == nums[j]) break;
                nums[j] &= x;
            }
            //
            while (left <= i && nums[left] < k) left++;
            while (right <= i && nums[right] <= k) right++;
            res += right - left;
        }
        return res;
    }
}


