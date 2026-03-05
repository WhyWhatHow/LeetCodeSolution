package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1758 {

    public static void main(String[] args) {
        Solution_1758 sol = new Solution_1758();//
        System.out.println(sol.minOperations(
                "10010100"
        ));
        System.out.println("==================");
    }

    // 010 0
    // 1 0 1 0
//    "10 01010 0"
    //  10
    //  1101010 1
    // 问题转换==> 以0开头需要的操作数, 以1开头需要的操作数.
    public int minOperations(String s) {
        int cnt = 0;
        cnt = count('1', s.toCharArray());
        cnt = Math.min(count('0', s.toCharArray()), cnt);
        return cnt;
    }

    private int count(char c, char[] cs) {
        int cnt = 0;
        int n = cs.length;
        if (cs[0] != c) {
            cs[0] = c;
            cnt++;
        }
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] == cs[i - 1]) {
                cs[i] = cs[i] == '1' ? '0' : '1';
                cnt++;
            }
        }
        return cnt;
    }
}
