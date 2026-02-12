package leetcode.algorithm.medium;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3713 {

    public static void main(String[] args) {
        Solution_3713 sol = new Solution_3713();//
        System.out.println(sol.longestBalanced(
                "zz"
        ));
        System.out.println("==================");
    }

    public int longestBalanced(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int res = 0;
        var map = new HashMap<Character, Integer>();

        for (int i = 0; i < cs.length; i++) {
            map.clear();
            for (int j = i; j < n; j++) {
                map.compute(cs[j], (kk, v) -> v == null ? 1 : v + 1);
                if (isBalanced(map)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    private boolean isBalanced(HashMap<Character, Integer> map) {
        int tar = -1;
        for (Integer v : map.values()) {
            if (tar == -1) {
                tar = v;
            } else if (tar != v) return false;
        }
        return true;
    }


}
