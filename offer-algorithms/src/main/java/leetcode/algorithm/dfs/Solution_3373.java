package leetcode.algorithm.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3373 {

    public static void main(String[] args) {
        Solution_3373 sol = new Solution_3373();
        System.out.println(sol.maxTargetNodes(new int[][]{
                {0, 1},
                {0, 2},
                {2, 3},
                {2, 4}
        }, new int[][]{
                {0, 1},
                {0, 2},
                {0, 3},
                {2, 7},
                {1, 4},
                {4, 5},
                {4, 6}
        }));
        System.out.println("==================");
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length; // n 条边对应n+1个点.
        int m = edges2.length;
        int[] ans = new int[n + 1];


        List<Integer>[] g = genGraph(edges1);
        List<Integer>[] gg = genGraph(edges2);

        // 统计 在gg中  cs[0] 偶数边的数量, cs[1] 表示奇数边数量.
        int[] cs = new int[2];
        dfs(0, -1, 0, gg, cs);
        int max = Math.max(cs[0], cs[1]); // 可以从任意节点添加,所以需要去最大值.

        // 对g 进行分组, 黑白两组.
        HashSet<Integer> set = new HashSet<>();
        handleFirstTree(0, -1, 0, g, set);
        for (int i = 0; i < ans.length; i++) {
            if (set.contains(i)) {
                ans[i] += set.size() + max;
            } else {
                ans[i] += n + 1 - set.size() + max;
            }
        }
        return ans;

    }

    // val= 0 , 表示偶数条边的节点. val =1 , 奇数条边的节点.
    private void handleFirstTree(int cur, int fa, int val, List<Integer>[] g, HashSet<Integer> set) {
        if ((val & 1) == 0) {
            set.add(cur);
        }
        for (Integer i : g[cur]) {
            if (i == fa) continue;
            handleFirstTree(i, cur, val ^ 1, g, set);
        }
    }

    // 统计 gg 树中 偶数以及奇数条边的数量.
    private void dfs(int cur, int fa, int val, List<Integer>[] gg, int[] cs) {
        cs[val]++;
        for (Integer i : gg[cur]) {
            if (i == fa) continue;
            dfs(i, cur, val ^ 1, gg, cs); // 黑白黑, 配色, 所以选择异或.
        }
    }


    private List<Integer>[] genGraph(int[][] es) {
        int n = es.length;
        List<Integer>[] g = new ArrayList[n + 1];
        Arrays.setAll(g, i -> new ArrayList<Integer>());
        for (int[] e : es) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        return g;
    }
}


