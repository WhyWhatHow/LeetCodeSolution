package leetcode.algorithm.greedy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1653 {

    public static void main(String[] args) {
        Solution_1653 sol = new Solution_1653();//
        System.out.println(sol.minimumDeletions(
//                "aababbab"
//                "bbaaaaabb"
//                "baababbaabbaaabaabbabbbabaaaaaabaabababaaababbb"
                "ababaaaabbbbbaaababbbbbbaaabbaababbabbbbaabbbbaabbabbabaabbbababaa"
        ));
        System.out.println("==================");
    }

    public int minimumDeletions(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int cnt = 0; // 'b*a' 的数量.
        int res = 0;
        for (char c : cs) {
            if (c == 'b') {
                cnt++;
            } else {
                if (cnt > 0) { // 'ba' 情况
                    res++;
                    cnt--; //
                }
            }
        }
        return res;
    }
}
