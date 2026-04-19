package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1592 {

    public static void main(String[] args) {
        Solution_1592 sol = new Solution_1592();//
        System.out.println(sol.reorderSpaces("  this   is  a sentence "));

        System.out.println("==================");
    }

    public String reorderSpaces(String text) {
        char[] cs = text.toCharArray();
        String[] ss = text.trim().split("\\s+");

        int cnt = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == ' ') {
                cnt++;
            }
        }

        int maxSpace, left;
        if (ss.length != 1) {
            maxSpace = cnt / (ss.length - 1);
            left = cnt % (ss.length - 1);
        }else {
            maxSpace =cnt ;
            left = cnt;
        }

        var sps = buildSpaces(maxSpace);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ss.length - 1; i++) {
            sb.append(ss[i]);
            sb.append(sps);
        }
        sb.append(ss[ss.length - 1]);
        if (left != 0) {
            for (int i = 0; i < left; i++) {
                sb.append(" ");
            }
        }
        return sb.toString();

    }

    private String buildSpaces(int maxSpace) {
        var s = "";
        for (int i = 0; i < maxSpace; i++) {
            s += " ";
        }
        return s;
    }

}
