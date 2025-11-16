package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1513 {

    public static void main(String[] args) {
        Solution_1513 sol = new Solution_1513();
        System.out.println("==================");
    }

    /**
     * 给你一个二进制字符串 s（仅由 '0' 和 '1' 组成的字符串）。
     * <p>
     * 返回所有字符都为 1 的子字符串的数目。
     * <p>
     * 由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
     *
     * @param s
     * @return
     */
    public int numSub(String s) {
        s += "0";
        int mod = 1000_000_007;
        char[] cs = s.toCharArray();
        int n = cs.length;
        long res = 0;
        long cnt = 0;
        for (char c : cs) {
            if (c == '1') {
                cnt++;
            } else {
                res += ((1 + cnt) * cnt) / 2;
//                for (int i = 0; i < cnt; i++) {
//                    res+=i;
//                }
                cnt = 0;
            }
        }
        return (int) (res % mod);


    }

}


