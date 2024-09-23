package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1014 {

    public static void main(String[] args) {
        Solution_1014 sol = new Solution_1014();
        System.out.println(sol.maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
        System.out.println("==================");
    }

    /**
     * values[i]+values[j]+i-j = values[i] +i + values[j] - j
     * 遍历右侧, 找左侧的最大值
     * #dp
     * @param values
     * @return
     */
    public int maxScoreSightseeingPair(int[] values) {
        int mx = values[0];
        int res = 0;
        for (int i = 1; i < values.length; i++) {
            res = Math.max(res, mx + values[i] - i);
            mx = Math.max(mx, values[i] + i);
        }
        return res ;
    }

}


