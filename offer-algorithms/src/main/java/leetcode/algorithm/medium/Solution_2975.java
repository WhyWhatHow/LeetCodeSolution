package leetcode.algorithm.medium;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_2975 {

    public static void main(String[] args) {
        Solution_2975 sol = new Solution_2975();
        System.out.println(sol.maximizeSquareArea(4, 3, new int[]{2, 3}, new int[]{2}));
        System.out.println("==================");
    }

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        var set = new HashSet<Integer>();
        Arrays.sort(hFences);
        Arrays.sort(vFences);
        for (int i = 0; i < hFences.length; i++) {
            set.add(hFences[i] - 1);
            set.add(m - hFences[i]);
            for (int j = i - 1; j >= 0; j--) {
                set.add(hFences[i] - hFences[j]);
            }
        }
        set.add(m - 1);
        long res = 0;

        long edge = 0;
        for (int i = 0; i < vFences.length; i++) {
            int l = vFences[i] - 1;
            int r = n - vFences[i];
            edge = getEdge(set, l, edge);
            edge = getEdge(set, r, edge);
            for (int j = i - 1; j >= 0; j--) {
                int t = vFences[i] - vFences[j];
                edge = getEdge(set, t, edge);
            }
        }
        // 删除全部中间的vfences 
        edge = getEdge(set, n - 1, edge);
        int mod = 1000_000_007;
        res = edge == 0 ? -1 : edge * edge % mod;

        return (int) res;
    }

    private long getEdge(HashSet<Integer> set, int len, long edge) {
        if (set.contains(len)) {
            edge = Math.max(len, edge);
        }
        return edge;
    }


}


