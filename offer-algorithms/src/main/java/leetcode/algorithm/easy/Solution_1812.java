package leetcode.algorithm.easy;

import java.util.Set;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1812 {

    public static void main(String[] args) {
        Solution_1812 sol = new Solution_1812();
        System.out.println("==================");
    }
    public boolean squareIsWhite(String coordinates) {
        Set<Character> m = Set.of('a', 'c', 'e', 'g');
        Set<Character> mm = Set.of('b', 'd', 'f', 'h');
        char c = coordinates.charAt(0);
        char cc = coordinates.charAt(1);
        if((m.contains(c) && !isOdd(cc)) ||(mm.contains(c) && isOdd(cc)) ){
            return true;
        }
        return false;


    }
    // 判断是否是奇数
    boolean isOdd(char x) {
        int val = x - '0';
        return (val & 1) == 1;
    }
}


