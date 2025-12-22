package leetcode.algorithm.dp;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_300 {

    public static void main(String[] args) {
        Solution_300 sol = new Solution_300();
        int i = sol.lengthOfLIS(new int[]{
//                10, 9, 2, 5, 3, 7, 101, 18
                0, 1, 0, 3, 2, 3,
        });
//        int ij = sol.lengthOfLIS20251222(new int[]{
//                10, 9, 2, 5, 3, 7, 101, 18
////                4, 10, 4, 3, 8, 9
//        });
        System.out.println(i);

        System.out.println("==================");
    }

    // 用贪心的思路解题

    /**
     * 设f[i] 表示 长度为i时结尾的最小值.
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        var set = new TreeSet<Integer>();
        for (int i : nums) {
            if (!set.isEmpty() && set.last() < i) set.add(i);
            else {
                if (!set.contains(i) && set.higher(i) != null) {
                    int val = set.higher(i);
                    set.remove(val);
                }
                set.add(i);
            }
        }
        return set.size();
    }

    public int lengthOfLIS20251222(int[] nums) {
        int n = nums.length;
        int[] f = new int[n + 1]; // f[i] means [0,i] range length;
        // f[i] = max (f[j])+1 ;
        Arrays.fill(f, 1);
        f[0] = 1;
        int mx = 1;
        for (int i = 1; i < nums.length; i++) {
            int res = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    res = Math.max(f[j] + 1, res);
                }
            }
            mx = Math.max(mx, res);
            f[i] = res;
        }
        return mx;
    }

    /**
     * dp[i] i pos max length of (0,i)
     * j <==>(0,i) == 0<=j<i,
     * if nums[i] >nums[j] dp[i] = max(dp[j]+1,dp[i]);
     *
     * @param nums
     * @return
     */
    public int lengthOfLISDP(int[] nums) {
        // init
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        //
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }


        int res = -1;
        for (int i : dp) {
            res = res < i ? i : res;
        }
        return res;
    }
}


