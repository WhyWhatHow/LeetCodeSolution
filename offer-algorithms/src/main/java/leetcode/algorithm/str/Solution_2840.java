package leetcode.algorithm.str;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_2840 {

    public static void main(String[] args) {
        Solution_2840 sol = new Solution_2840();//
    }

    // abdcde // 分别统计奇偶中每个abcd 的数量,毕竟可以交换只要两者数量一直就可以.
    public boolean checkStrings(String s1, String s2) {
        char[] cs = s1.toCharArray();
        char[] ss = s2.toCharArray();
        int n = cs.length;

        int[][] f = new int[2][26];
        int[][] ff = new int[2][26];
        char c = 'a';
        for (int i = 0; i < cs.length; i++) {
            f[(i & 1)][cs[i] - c]++;
            ff[(i & 1)][ss[i] - c]++;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 26; j++) {
                if (ff[i][j] != f[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
