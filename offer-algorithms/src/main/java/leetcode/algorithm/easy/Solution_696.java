package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_696 {

    public static void main(String[] args) {
        Solution_696 sol = new Solution_696();//
        System.out.println(sol.countBinarySubstrings(
//                "00110011"
//                "000111"
                "00"
        ));
        System.out.println("==================");
    }

    public int countBinarySubstrings(String s) {
        int n = s.length();
        if (n <= 1) return 0;
        char[] cs = s.toCharArray();
        int pcnt = 0;
        int cnt = 1;
        int res = 0;
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] == cs[i - 1]) {
                cnt++;
            } else {
                res += Math.min(pcnt, cnt);
                pcnt = cnt;
                cnt = 1;
            }
        }
        res += Math.min(pcnt, cnt);
        return res;
    }

}
