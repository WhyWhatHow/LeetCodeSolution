package leetcode.algorithm.medium;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_2657 {

    public static void main(String[] args) {

        Solution_2657 sol = new Solution_2657();//
        System.out.println(sol.findThePrefixCommonArray(
                new int[]{1, 3, 2, 4},
                new int[]{3, 1, 2, 4}
        ));
        System.out.println("==================");
    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] rs = new int[A.length];
        var map = new HashMap<Integer, Integer>();
        int cnt = 0;
        for (int i = 0; i < rs.length; i++) {
            int t = map.compute(A[i], (k, v) -> v == null ? 1 : v + 1);
            int tt = map.compute(B[i], (k, v) -> v == null ? 1 : v + 1);
            if (t == 2) cnt++;
            if (tt == 2) cnt++;
            rs[i] = cnt;
        }
        return rs;
    }

}
