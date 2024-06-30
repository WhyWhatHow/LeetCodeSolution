package leetcode.algorithm.dp;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_494 {

    public static void main(String[] args) {
        Solution_494 sol = new Solution_494();
        System.out.println(sol.findTargetSumWays(new int[]{
                        1, 1, 1, 1, 1
                },
                3
        ));
        System.out.println("==================");

    }

    /**
     * 0-1背包
     * p : all set of positive nums sum.
     * q : 负数之和 的abs
     * 则有:
     * p+q = sum
     * p-q = target
     * p = (sum+target)/2  //  p>0 && p is even num.
     * 设 f[i] 表示 正数子集和为i 的方案数.
     * 则有 f[0] =1 ,
     * 对于每一个num ,
     * 选择num, f[i] += f[i-num]
     * 不选择 num: 不变
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // sum+target 为奇数, || sum< |target|
        if (sum < Math.abs(target) || ((sum + target) & 1) != 0) return 0;

        int p = (sum + target) / 2;
        int[] f = new int[p + 1];
        f[0] = 1; //

        for (int num : nums) {
            for (int i = f.length - 1; i >= num; i--) {
                f[i] += f[i - num];
            }
        }

        return f[p];
    }

    /**
     * dp
     * if f[i][j] means : 前i个元素, sum == j 's num.
     * f[i][j] = max( f[i-1][j+nums[i]]+1, f[i-1][j-nums[i]] +1 ) // wa
     * f[i][j] = f[i-1][j+nums[i-1]]  + f[i-1][j-nums[i-1]]   // plus , minis
     * f[0][0] = 1
     * j's range? [-sum,sum]
     * for avoiding Array index error ,  j+nums[i]+sum
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWaysDP(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < Math.abs(target)) return 0;

        int[][] f = new int[nums.length + 1][sum * 2 + 1];
        f[0][0 + sum] = 1; // 不选元素, 和为0, 的结果为1

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= 2 * sum; j++) {
                int plus = j + nums[i - 1];
                int minis = j - nums[i - 1];
                if (minis >= 0) {
                    f[i][j] += f[i - 1][minis];
                }
                if (plus <= 2 * sum) {
                    f[i][j] += f[i - 1][plus];
                }
            }
        }

        return f[nums.length][target + sum];

    }

}


