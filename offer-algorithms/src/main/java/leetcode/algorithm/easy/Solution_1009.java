package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1009 {

    public static void main(String[] args) {
        Solution_1009 sol = new Solution_1009();//
        sol.bitwiseComplement(8);
        System.out.println("==================");
    }

    public int bitwiseComplement(int n) {

        var s = Integer.toBinaryString(n);
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            cs[i] = cs[i] == '1' ? '0' : '1';
        }
        int res = 0;
        for (int i = 0; i < cs.length; i++) {
            res = res * 2 + cs[i] - '0';
        }
        return res;
    }
}
