package leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1498 {

    public static void main(String[] args) {
        Solution_1498 sol = new Solution_1498();

        System.out.println("==================");
    }

    int mod = 1000_000_007;


    /**
     * 有题意知, 子序列 在本题中, 可以是无序的.  所以可以排序处理.
     * 举个例子 : 假设 1,3,5,6 为nums , target  = 9 ;
     * 对于 1 , 所有数据符合题意, 总共有 8 个
     * 对于 3, 所有符合题意, 总共有4 个
     * 对于 5,6 分别只有1个符合题意.
     * 猜测规律是2^(r-l) 数量
     *
     * @param nums
     * @param target
     * @return
     */
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        long res = 0;
        int l = 0, r = nums.length;
        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                res += pow(2, r - l);
                res = res % mod;
                l++;
            } else {
                r--;
            }
        }
        return (int) res;
    }

    // 返回a^n
    private long pow(int a, int n) {
        long res = 1;
        long base = a;
        while (n > 0) {
            if ((n & 1) == 1) { // odd
                res = res * base % mod;
            }
            base = base * base % mod;
            n >>= 1;
        }
        return res;
    }

}


