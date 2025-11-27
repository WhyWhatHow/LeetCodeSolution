package leetcode.algorithm.dp;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3381 {

    public static void main(String[] args) {
        Solution_3381 sol = new Solution_3381();
        System.out.println(sol.maxSubarraySum(new int[]
//                        {-1, -2, -3, -4, -5},
                        {1,2},
//                4
                1
        ));
        System.out.println("==================");
    }

    /**
     * 设pre[i] means [0,i) range preSum.
     * 当 k ==1,最大值, pre[j] - min(pre[i]) , i < j
     * 当 k ==2, 对于 pre[j] - min(pre[i]) , i == j % k  && i < j
     *
     * @param nums
     * @param k
     * @return
     */
    public long maxSubarraySum(int[] nums, int k) {
        long[] pres = new long[nums.length + 1]; // pres[i] means[0,i)  ranges sum.

        pres[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            pres[i + 1] = pres[i] + nums[i];
        }
        // init minks ,
        long[] minks = new long[k];
        for (int i = 0; i < k; i++) minks[i] = pres[i];

        long res = Long.MIN_VALUE;
        for (int r = k; r < pres.length; r++) {
            int mod = r % k;
            res = Math.max(res, pres[r] - minks[mod]);
            if (minks[mod] > pres[r]) {
                minks[mod] = pres[r];
            }
        }
        return res;

    }
}


