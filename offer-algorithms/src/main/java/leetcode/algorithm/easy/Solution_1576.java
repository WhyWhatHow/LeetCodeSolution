package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1576 {

    public static void main(String[] args) {
        Solution_1576 sol = new Solution_1576();//
        System.out.println("==================");
    }

    public String modifyString(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 0; i < n; i++) {
            if (cs[i] == '?') {
                cs[i] = 'a';
                while (i < n - 1 && cs[i] == cs[i + 1] || (i > 0 && cs[i] == cs[i - 1])) {
                    cs[i] = cs[i]++;
                }
            }
        }
        return String.valueOf(cs);

    }

}
