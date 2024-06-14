package leetcode.algorithm.medium;

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
     * 奇偶性相同 : 相加
     * 奇偶性不同: sum+nums[i]-x
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
                evenSum = Math.max(evenSum, Math.max(evenSum + nums[i], oddSum + nums[i] - x));
            } else {
                oddSum = Math.max(oddSum, Math.max(oddSum + nums[i], evenSum + nums[i] - x));
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
    public long maxScoreWrong(int[] nums, int x) {
        long res = nums[0];
        long[] f = new long[nums.length];
        f[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (isSame(nums[i], f[i - 1])) {
                f[i] = Math.max(f[i - 1], f[i - 1] + nums[i]);
            } else {
                long temp = f[i - 1] + nums[i] - x;
                // nums[i] is different for nums[i-1
                int k = i - 1;
                while (k > 0 && isSame(nums[k], nums[i])) {
                    temp += nums[k--];
                }
                f[i] = Math.max(f[i - 1], temp);
            }
            res = Math.max(f[i], res);
        }

        return res;
    }

    boolean isSame(long a, long b) {
        return isEven(a) == isEven(b);
    }

    boolean isEven(long num) {
        return (num & 1) == 0;
    }
}


