package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2414 {

    public static void main(String[] args) {
        Solution_2414 sol = new Solution_2414();
        System.out.println("==================");
    }

    public int longestContinuousSubstring(String s) {
        char[] cs = s.toCharArray();
        int max = 0;
        int l = 0, r = l;
        for (r = l + 1; r < cs.length; r++) {
            if (cs[r] - cs[r - 1] != 1) {
                max = Math.max(max, r - l);
                l = r;
            }
        }
        max = Math.max(max, r - l);

        return max == 0 ? r - l : max;
    }

}


