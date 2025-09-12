package leetcode.algorithm.medium;

import java.util.Set;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3227 {

    public static void main(String[] args) {
        Solution_3227 sol = new Solution_3227();
        System.out.println("==================");
    }

    public boolean doesAliceWin(String s) {
        char[] cs = s.toCharArray();
//        int[] f = new int[cs.length]; // f[i] means [0,i] range has a,e,i,o,u number.
        int cnt = 0;
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        for (int i = 0; i < cs.length; i++) {
            if (set.contains(cs[i])) {
                cnt++;
            }
//            f[i] = cnt;
        }
        return cnt == 0 ? false : true;
    }
}


