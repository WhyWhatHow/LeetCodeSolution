package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3019 {

    public static void main(String[] args) {
        Solution_3019 sol = new Solution_3019();
        System.out.println("==================");
    }

    public int countKeyChanges(String s) {
        char[] cs = s.toLowerCase().toCharArray();
        int res = 0;
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] != cs[i - 1]) res++;
        }
        return res;
    }

}
