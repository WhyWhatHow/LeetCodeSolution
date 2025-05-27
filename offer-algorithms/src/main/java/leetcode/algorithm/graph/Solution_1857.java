package leetcode.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1857 {

    public static void main(String[] args) {
        Solution_1857 sol = new Solution_1857();
        System.out.println(sol.largestPathValue(
//                "a"
                "abaca"
                , new int[][]{
//                        {0, 0}
                        {0, 1}, {0, 2}, {2, 3}, {3, 4}
                }));
        System.out.println("==================");
    }

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        char[] cs = colors.toCharArray();
        ArrayList<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<Integer>());
        int[] ins = new int[n];
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            ins[y]++;
        }

        // init queue
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < ins.length; i++) {
            if (ins[i] == 0) {
                q.add(i);
            }
        }


        char c = 'a';
        int res = 0; // 标记最终结果
        int[][] f = new int[n][26]; // f[i][j] 表示所有到i节点的边, , color = j 的最大数量.
        int cnt = 0; // 如果cnt == n, 则不存在环, cnt<n ,则存在环.


        while (!q.isEmpty()) {
            Integer cur = q.poll();
            int curColor = cs[cur] - c;
            cnt++;
            f[cur][curColor]++;
            res = Math.max(res, f[cur][curColor]);

            // edge{cur,i}
            for (Integer i : g[cur]) {
                // update i node 节点颜色数量  cur-> i
                for (int j = 0; j < 26; j++) { // 更新i的最大颜色数量.
                    f[i][j] = Math.max(f[i][j], f[cur][j]);
                }

                ins[i]--;
                if (ins[i] == 0) q.add(i);
            }
        }

        return cnt < n ? -1 : res;
    }

}


