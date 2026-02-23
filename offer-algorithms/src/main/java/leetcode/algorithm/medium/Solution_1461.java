package leetcode.algorithm.medium;

import java.util.TreeSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1461 {

    public static void main(String[] args) {
        Solution_1461 sol = new Solution_1461();//
        System.out.println(sol.hasAllCodes(
                "00110",
                2));
        System.out.println("==================");
    }

    public boolean hasAllCodes(String s, int k) {
        var res = 1 << k;
        var set = new TreeSet<String>();
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 0; i <= n - k; i++) {
            set.add(String.valueOf(cs, i, k));
        }
        return set.size() == res;

    }
}
