package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_868 {

    public static void main(String[] args) {
        Solution_868 sol = new Solution_868();//
        System.out.println("==================");
    }

    public int binaryGap(int n) {
        if (Integer.bitCount(n) == 1) {
            return 0;
        }
        char[] cs = Integer.toBinaryString(n).toCharArray();
        int len = cs.length;
        int res = 0;
        int prev = -1;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '1') {
                if (prev == -1) prev = i;
                else {
                    res = Math.max(res, i - prev);
                    prev = i;
                }
            }
        }
        return res;
    }
}
