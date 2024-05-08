package leetcode.algorithm.dp;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_718 {

    public static void main(String[] args) {
        Solution_718 sol = new Solution_718();
        int length = sol.findLength(new int[]{
//                1, 2, 3, 2, 1
                0, 1, 1, 1, 1
        }, new int[]{
//                3, 2, 1, 4, 7
                1, 0, 1, 0, 1
        });
        System.out.println(length);
        System.out.println("==================");
    }

    /**
     * dp[i][j] : nums1 range[0,i), range nums2[0,j) : . dp[][] 连续 数组的最大长度
     * nums1[i-1] == nums2[j-1]
        *  : dp[i][j]= dp[i-1][j-1]+1
     * nums1[i-1] != nums2[j-1]
        *   : dp[i][j]=0; // 不是子数组,所以是0
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int res = 0;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
//                    dp[i][j] = dp[i - 1][j - 1];
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                res = Math.max(res, dp[i][j]);

            }
        }

        return res;
    }


}


