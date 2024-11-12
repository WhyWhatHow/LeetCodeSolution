package leetcode.algorithm.dp;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #dp #hard #区间dp
 * @author: WhyWhatHow
 **/

public class Solution_1547 {

    public static void main(String[] args) {
        Solution_1547 sol = new Solution_1547();
        System.out.println(sol.minCost(
                9
                , new int[]{
                        5, 6, 1, 4, 2
                }));
        System.out.println("==================");
    }

    /**
     * f(i,j) [i,j] minCost.
     *
     * @param n
     * @param cuts
     * @return
     */
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] arr = new int[cuts.length + 2];
        arr[0] = 0;
        for (int i = 1; i <= cuts.length; i++)
            arr[i] = cuts[i - 1];
        arr[cuts.length + 1] = n;
        return dfs(arr, 0, arr.length - 1);
    }

    HashMap<Long, Integer> map = new HashMap<>();

    /**
     * f(i,j) [i,j] minCost.
     * if exist k (k<j && k>l)
     * f(i,j) = min(f(i,k) + f(k,j))+ cuts[j]-cuts[i]
     */
    private int dfs(int[] cuts, int l, int r) {
        if (l >= r) return 0;
        long key = ((long)r << 32) | l;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int res = Integer.MAX_VALUE;
        int cost = cuts[r] - cuts[l];
        for (int i = l + 1; i < r; i++) {
            res = Math.min(res, dfs(cuts, l, i) + dfs(cuts, i, r));
        }
        res = res + cost;
        map.put(key, res);
        return res;
    }

}


