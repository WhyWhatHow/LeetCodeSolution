package leetcode.algorithm.dfs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3249 {

    public static void main(String[] args) {
        Solution_3249 sol = new Solution_3249();
        System.out.println(sol.countGoodNodes(new int[][]{
//                {0, 1},
//                {0, 2},
//                {1, 3},
//                {1, 4},
//                {2, 5},
//                {2, 6}
                //////////////////
                {0, 1},
                {1, 2},
                {1, 3},
                {1, 4},
                {0, 5},
                {5, 6},
                {6, 7},
                {7, 8},
                {0, 9},
                {9, 10},
                {9, 12},
                {10, 11}
                /////////////
//                {2, 0},
//                {4, 2},
//                {1, 2},
//                {3, 1},
//                {5, 1}
                //////
//                {1, 0}, {3, 0}, {2, 3}
        }));
        System.out.println("==================");
    }

    int res = 0;
    int[] nums; // 子树的数量.

    public int countGoodNodes(int[][] edges) {
        int n = edges.length;
        ArrayList<Integer>[] g = new ArrayList[n + 1];
        nums = new int[n + 1];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            g[u].add(v);
            g[v].add(u);
        }
        dfs(g, 0, -1);

        return res;
    }

    /**
     * dfs(cur,parentId)
     * 统计子树的节点数
     *
     * @param g
     * @param cur
     * @param parentId
     * @return
     */
    private int dfs(ArrayList<Integer>[] g, int cur, int parentId) {
        if (cur != 0 && g[cur].size() == 1) {
            res++;
            return 0;
        }

        int[] ss = new int[g[cur].size()];
        int sum = 0;
        int cnt = 0;
        for (Integer node : g[cur]) {
            if (node == parentId) {
                ss[cnt++] = 0;
                continue;
            }
            int size = dfs(g, node, cur) + 1;
            nums[node] = size;
            sum += size;
            ss[cnt++] = size;
        }

        boolean yes = true;
        for (int j = 1; j < ss.length; j++) {
            if (ss[j] != 0 && ss[j - 1] != 0 && ss[j] != ss[j - 1]) {
                yes = false;
                break;
            }
        }
        if (yes) res++;
        return sum;
    }
}


