package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_796 {

    public static void main(String[] args) {
        Solution_796 sol = new Solution_796();//
        System.out.println(sol.rotateString(
                "abcde",
                "cdeab"
        ));
        System.out.println("==================");
    }

    public boolean rotateString(String s, String goal) {
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (goal.equals(rotate(cs, i))) return true;
        }
        return false;
    }

    // i 表示旋转次数.
    private String rotate(char[] cs, int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = i; j < cs.length; j++) {
            sb.append(cs[j]);
        }
        for (int j = 0; j < i; j++) {
            sb.append(cs[j]);
        }
        return sb.toString();
    }

}
