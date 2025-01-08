package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2264 {

    public static void main(String[] args) {
        Solution_2264 sol = new Solution_2264();
        System.out.println("==================");
    }

    public String largestGoodInteger(String num) {
        boolean[] vis = new boolean[10];
        char[] cs = num.toCharArray();
        for (int i = 1; i < cs.length - 1; i++) {
            if (cs[i] == cs[i - 1] && cs[i] == cs[i + 1]) {
                vis[cs[i] - '0'] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = vis.length - 1; i >= 0; i--) {
            if (vis[i]) {
                char c = (char) (i + '0');
                sb.append(new char[]{c, c, c});
                break;
            }
        }
        return sb.toString();

    }
}
