package leetcode.algorithm.dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_3067 {

    public static void main(String[] args) {
        Solution_3067 sol = new Solution_3067();

        System.out.println("==================");
    }

    /**
     * c
     * subtree (3)| st(4) | st(5)
     * 节点c 对应的 总节点数为 3*4 + (3+4)*5
     *
     * @param edges
     * @param signalSpeed
     * @return
     */
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int[] ans = new int[edges.length + 1];

        List<int[]>[] graph = new LinkedList[ans.length];
        Arrays.setAll(graph, i -> new LinkedList<>());

        // init graph
        for (int[] e : edges) {
            int x = e[0], y = e[1], val = e[2];
            graph[x].add(new int[]{y, val});
            graph[y].add(new int[]{x, val});
        }

        // visit all order to get ans

        for (int i = 0; i < ans.length; i++) {

            int sum = 0;
            for (int[] e : graph[i]) {
                int cnt = dfs(e[0], i, e[1], graph, signalSpeed);
                ans[i] += cnt * sum;
                sum += cnt;
            }
        }

        return ans;
    }

    // father -> x 满足条件的边数
    private int dfs(int x, int father, int sum, List<int[]>[] graph, int signalSpeed) {
        int cnt = sum % signalSpeed == 0 ? 1 : 0;
        for (int[] e : graph[x]) {
            if (e[0] == father) continue;
            cnt += dfs(e[0], x, sum + e[1], graph, signalSpeed);
        }
        return cnt;
    }


}


