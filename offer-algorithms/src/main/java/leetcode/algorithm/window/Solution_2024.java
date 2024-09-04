package leetcode.algorithm.window;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2024 {

    public static void main(String[] args) {
        Solution_2024 sol = new Solution_2024();
        System.out.println(sol.maxConsecutiveAnswers(
//                "TTFF", 2
//                "TFFT", 1
                "FTFFTFTFTTFTTFTTFFTTFFTTTTTFTTTFTFFTTFFFFFTTTTFTTTTTTTTTFTTFFTTFTFFTTTFFFFFTTTFFTTTTFTFTFFTTFTTTTTTF", 32
//                "TTFTTFTT", 1
        ));
        System.out.println("==================");
    }

    /**
     * [l,r] 有至多 有k 个T, or 至多有k个F
     *
     * @param answerKey
     * @param k
     * @return
     */
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] c = answerKey.toCharArray();
        return Math.max(getLen('T', c, k), getLen('F', c, k));

    }

    /**
     * [l,r) contains k numbers of  tar(char), 's max length
     */
    private int getLen(char tar, char[] c, int k) {
        int l = 0, r = 0;
        int n = c.length;
        int res = 0;
        while (r < n && k >= 0) {
            if (c[r] == tar) k--;
            r++;
            while (k < 0) {
                if (c[l] == tar) k++;
                l++;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }

}


