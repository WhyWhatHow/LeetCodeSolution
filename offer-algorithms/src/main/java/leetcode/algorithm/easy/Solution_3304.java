package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3304 {

    public static void main(String[] args) {
        Solution_3304 sol = new Solution_3304();
        int[] a = new int[]{5, 10, 244};
        for (int i : a) {
            System.out.println(sol.kthCharacter(i));
        }


        System.out.println("==================");
    }

    public char kthCharacter(int k) {
        char[] cs = new char[k];
        int len = 1;
        cs[0] = 'a';
        while (k-- > 0 && len < cs.length) {

            for (int i = 0; i < len && len + i < cs.length; i++) {
                if (cs[i] == 'z') {
                    cs[len + i] = 'a';
                } else {
                    cs[len + i] = (char) (cs[i] + 1);
                }
            }
            len = len * 2;
        }

        return cs[cs.length - 1];

    }

}


