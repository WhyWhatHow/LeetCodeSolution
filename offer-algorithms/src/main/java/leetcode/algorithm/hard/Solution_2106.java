package leetcode.algorithm.hard;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2106 {

    public static void main(String[] args) {
        Solution_2106 sol = new Solution_2106();
        System.out.println(sol.maxTotalFruits(new int[][]{
//                        {2, 8}, {6, 3}, {8, 6}
//                        {2000_00,1000}
                        {0, 10000}
                },
//                5, 4
//                0,2000_00
                2000_00, 2000_00
        ));
        System.out.println("==================");
    }


    // 统计 从[startPos-k,startPos] -> [startPos, startPos+k] 之间的最大值.
    // 设 f[i] 表示 [0,i) 范围内的果子之和.
    // [0,i] 范围的前缀和, [i,j] f[j]-f[i-1] ,如果要表示0 , 需要整体右移一格, 不方便思考.
    // 则 区间[i,j]内的果子和则是:   f[j+1]-f[i]
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int MAX = 2000_00;
        int[] dp = new int[2000_05];

        // count preSum
        int j = 0;
        for (int[] ff : fruits) {
            int i = ff[0], val = ff[1];
            while (j <= i) {
                dp[j + 1] = dp[j];
                j++;
            }
            dp[i + 1] = dp[i] + val;
//            j = i;
        }

        while (j + 1 < dp.length) {
            dp[j + 1] = dp[j];
            j++;
        }

        //  最大水果数量
        int res = 0;

        // 向左走
        for (int l = 0; l <= k; l++) { // l 向左走的步数.
            int r = k - l;
            int lpos = startPos - l;
            lpos = Math.max(0, lpos);
            int rpos = lpos + r;
            rpos = Math.min(MAX, rpos);
            res = Math.max(res, dp[rpos + 1] - dp[lpos]);
        }

        // 向右走
        for (int r = 0; r <= k; r++) {
            int l = k - r;
            int rpos = startPos + r;
            rpos = Math.min(MAX, rpos);
            int lpos = rpos - l;
            lpos = Math.max(0, lpos);
            res = Math.max(dp[rpos + 1] - dp[lpos], res);
        }

        return res;
    }
}


