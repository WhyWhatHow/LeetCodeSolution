package leetcode.algorithm.medium;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3186 {

    public static void main(String[] args) {
        Solution_3186 sol = new Solution_3186();
        System.out.println(sol.maximumTotalDamage(new int[]{
                7, 1, 6, 6
        }));
        System.out.println("==================");
    }

    TreeMap<Integer, Integer> cmap = new TreeMap<>(); // key : power[i], val: cnt
    HashMap<Integer, Long> map = new HashMap<>(); //

    // set f[i] means [0,i] range , maxValue.
    // f[i] = max(f[i-1], f[j]+c[i]*c[i].cnt)
    public long maximumTotalDamage(int[] power) {
        // init
        for (int i : power) {
            cmap.compute(i, (k, v) -> v == null ? 1 : v + 1);
        }
        Integer[] a = new Integer[cmap.size()];
        cmap.keySet().toArray(a);

        return dfs(a.length - 1, a);

//        for (int i = 0; i < a.length; i++) {
//
//        }
//        long res = 0;

//        return res;
    }

    private long dfs(int i, Integer[] a) {
        if (i < 0) return 0;

        if (map.containsKey(a[i])) return map.get(a[i]);

        long res = 0;
        // find j that a[j] < a[i]-2;
        int j = i;
        // for a[i] , [a[i]-2,a[i]+2] range number can't be selected.
        while (j >= 0 && a[j] >= a[i] - 2) {
            j--;
        }
        res = Math.max(dfs(i - 1, a), dfs(j, a) + (long) a[i] * cmap.get(a[i]));
        map.put(a[i], res);
        return res;
    }
}


