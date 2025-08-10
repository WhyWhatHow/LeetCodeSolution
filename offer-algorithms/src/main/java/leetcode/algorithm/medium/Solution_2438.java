package leetcode.algorithm.medium;

import java.util.ArrayList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2438 {

    public static void main(String[] args) {
        Solution_2438 sol = new Solution_2438();
        System.out.println(sol.productQueries(
//                2
                10
                , new int[][]{

                }));
        System.out.println("==================");
    }

    public int[] productQueries(int n, int[][] queries) {
        char[] cs = Integer.toBinaryString(n).toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = cs.length - 1; i >= 0; i--) {
            if (cs[i] != '0') {
                list.add(1 << (cs.length - i - 1));
            }
        }
        int[] res = new int[queries.length];
        int MOD = 1000_000_007;
        int cnt = 0;
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            long val = 1;
            for (int i = l; i <= r; i++) {
                val *= list.get(i);
                if (val > MOD) val %= MOD;
            }
            res[cnt++] = (int) val;
        }
        return res;
    }
}


