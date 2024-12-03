package leetcode.algorithm.easy;

import java.util.Set;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3274 {

    public static void main(String[] args) {
        Solution_3274 sol = new Solution_3274();

        System.out.println("==================");
    }

    public boolean checkTwoChessboards(String s, String ss) {
        Set<Character> m = Set.of('a', 'c', 'e', 'g');
        Set<Character> mm = Set.of('b', 'd', 'f', 'h');
        char c = s.charAt(0);
        char cc = ss.charAt(0);
        if ((m.contains(c) && m.contains(cc)) || (mm.contains(c) && mm.contains(cc))) {
            if (isOdd(s.charAt(1)) == isOdd(ss.charAt(1))) return true;
            else return false;
        } else {
            if (isOdd(s.charAt(1)) == isOdd(ss.charAt(1))) return false;
            return true;
        }
    }

    // 判断是否是奇数
    boolean isOdd(char x) {
        int val = x - '0';
        return (val & 1) == 1;
    }

}


