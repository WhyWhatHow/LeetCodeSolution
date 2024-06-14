package leetcode.algorithm.dp;

/**
 * @program: LeetCodeSolution
 * @description: #binary Indexed Array
 * @author: WhyWhatHow
 **/

public class Solution_2786 {

    public static void main(String[] args) {
        Solution_2786 sol = new Solution_2786();
        System.out.println(sol.maxScore(new int[]{
                        2, 3, 6, 1, 9, 2
                },
                5
        ));
        System.out.println("==================");
    }

    /**
     * 两种选择,
     * 奇偶性相同 : sum+nums[i]
     * 奇偶性不同: sum+nums[i]-x
     * 初始化:
     * oddSum : 奇数之和
     * evenSum: 偶数之和
     * res = max(oddSum, evenSum)
     * 那么 oddSum=nums[0] 时, evenSum =?
     * if evenSum =0 , eg: [3,2],5,
     * #think
     *
     * @param nums
     * @param x
     * @return
     */
    public long maxScore(int[] nums, int x) {
        // init #important
        long oddSum = (nums[0] & 1) == 1 ? nums[0] : -x;
        long evenSum = (nums[0] & 1) == 0 ? nums[0] : -x;

        // running
        for (int i = 1; i < nums.length; i++) {
            // even
            if ((nums[i] & 1) == 0) {
                evenSum = Math.max(evenSum + nums[i], oddSum + nums[i] - x);
            } else {
                oddSum = Math.max(oddSum + nums[i], evenSum + nums[i] - x);
            }
        }
        return Math.max(evenSum, oddSum);
    }

    /**
     * f[i]  [0,i] maxScore,
     * f[i] = max(f[i-1],f[i-1] +nums[i]) // nums[i] nums[i-1] same
     * f[i] = max(f[i-1], f[i-1]+nums[i]-x) ;
     * 2, 3, 6, 1,   9,    2
     * 2, 0, 8, 4, 13|12, 10 |
     *
     * @param nums
     * @param x
     * @return
     */
    public long maxScoreDP(int[] nums, int x) {
        long res = nums[0];
        long[] f = new long[nums.length];
        long oddSum = 0, evenSum = 0;
        f[0] = nums[0];
        if ((nums[0] & 1) == 0) evenSum = nums[0];
        else oddSum = nums[0];
        for (int i = 1; i < nums.length; i++) {

            // even
            if ((nums[i] & 1) == 0) {
                f[i] = Math.max(evenSum, oddSum - x) + nums[i];
                evenSum = Math.max(evenSum,f[i]);
            } else {
                f[i] = Math.max(oddSum, evenSum - x) + nums[i];
                oddSum = Math.max(oddSum,f[i]);
            }
        }

        return f[nums.length - 1];
    }
}


