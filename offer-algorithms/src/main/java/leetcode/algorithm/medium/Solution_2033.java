package leetcode.algorithm.medium;

import java.util.TreeMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_2033 {

    public static void main(String[] args) {
        Solution_2033 sol = new Solution_2033();//
        System.out.println(sol.minOperations(
                new int[][]{{2, 4}, {6, 8}},
                2
        ));
        System.out.println("==================");
    }

    // 前缀和 and 后缀和
    public int minOperations(int[][] grid, int x) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] ints : grid) {
            for (int i : ints) {
                map.compute(i, (k, v) -> v == null ? 1 : v + 1);
            }
        }

        // check have answer or not.
        int min = map.firstKey();
        var set = map.keySet().stream().toList();
        for (Integer i : set) {
            if ((i - min) % x != 0) return -1;
        }

        int[] pres = new int[set.size() + 1];//
        int[] sufs = new int[set.size() + 1];

        // count pres
        int all = 0;
        for (int i = 1; i < set.size(); i++) {
            all += map.get(set.get(i - 1));
            // cnt ss[i]-ss[i-1]
            pres[i] = pres[i - 1] + all * (set.get(i) - set.get(i - 1)) / x;
        }

        // count sufs
        all = 0;
        for (int i = set.size() - 2; i >= 0; i--) {
            all += map.get(set.get(i + 1));
            sufs[i] = sufs[i + 1] + all * (set.get(i + 1) - set.get(i)) / x;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < pres.length - 1; i++) {
            res = Math.min(res, pres[i] + sufs[i]);
        }
        return res;

    }

}
