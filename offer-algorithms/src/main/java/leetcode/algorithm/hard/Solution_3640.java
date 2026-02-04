package leetcode.algorithm.hard;

import java.util.ArrayDeque;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3640 {

    public static void main(String[] args) {
        Solution_3640 sol = new Solution_3640();//
        System.out.println(sol.maxSumTrionic(
//                new int[]{1, 4, 2, 7}
//                new int[]{0, -2, -1, -3, 0, 2, -1}
                new int[]{1, 4, 2, 2, 3, 1, 2}
        ));
        System.out.println("==================");
    }

    // 枚举p,q, 保证pq之间是严格单调递减的区间,
    // 对于[p,q] 而言, res = nums[p-1]+nums[p]+...+nums[q]+nums[q+1]
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        // sum = nums[p]+...+nums[q-1]
        var list = new ArrayDeque<long[]>(); // //{p,q,sum} [p,q+1]
        int p = 0;
        for (int i = 0; i < n - 1; ) {
            if (nums[i + 1] < nums[i]) {
                long sum = nums[p];
                int q = i + 1;
                while (q < n && nums[q] < nums[q - 1]) {
                    sum += nums[q];
                    q++;
                }
//                if (q == n) q = n - 1;
                if (p != 0 && q <= n - 1)
                    list.add(new long[]{p, q, sum});
                i = q;
                p = i;
            } else {
                p = ++i;
//                i++;
            }
        }

        long res = -(1L << 53) + 1; // alert : leetcode didn't support Long.MIN_VALUE;
        // a=>{p, q+1, nums[p]+...+nums[q]}
        for (long[] a : list) {
            int l = (int) (a[0] - 1);
            int r = (int) a[1];

            // check nums[p-1]<nums[p] && nums[q]<nums[q+1]
            if (nums[l] >= nums[l + 1] || nums[r] <= nums[r - 1]) continue;

            long sum = a[2];
            long lsum = nums[l];
            int lend = l;
            // go left
            while (l > 0 && (nums[l] > nums[l - 1] && nums[l - 1] > 0)) {
                lsum += nums[--l];
            }
            lsum = Math.max(lsum, nums[lend]);
            // go right
            long rsum = nums[r];
            int rst = r;
            while (r < n - 1 && nums[r] < nums[r + 1]) {
                rsum += nums[++r];
            }
            rsum = Math.max(nums[rst], rsum);

            res = Math.max(res, sum + rsum + lsum);
        }
        return res;
    }
}
