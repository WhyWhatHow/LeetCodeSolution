package leetcode.algorithm.graph;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3244 {

    public static void main(String[] args) {
        Solution_3244 sol = new Solution_3244();
        System.out.println(sol.shortestDistanceAfterQueries(
                5
//                26
                , new int[][]{
                        {2, 4}, {0, 2}, {0, 4}
//                        {8, 13}, {5, 16}, {21, 23}, {3, 20}, {11, 13}
                }));
        System.out.println("==================");
    }

    /**
     * 0->1->2->3->4 , 一共有三条edge, 分别用e0,e1,e2,e3
     * [2,4] -> e2,e3 合并, e3,e4 合并.
     * res = fenwickTree 中parentId = 自身的节点数.
     *
     * @param n
     * @param queries
     * @return
     */
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int len = queries.length;
        int[] res = new int[len];
        UnionFind uf = new UnionFind(n);
        int size = n - 1;
        int cnt = 0;
        for (int[] query : queries) {
            int l = query[0], r = query[1] - 1;
            System.out.println("====" + l + ": " + r);
            int pr = uf.find(r);
            l = uf.find(l);

            while (l < r) {
                uf.parent[l] = pr;
                size--;
                l = uf.find(l + 1);
            }
            res[cnt++] = size;
        }


        return res;
    }

    class UnionFind {
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            parent = new int[n]; //
            size = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean merge(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return false;
            if (size[pa] > size[pb]) {
                parent[pb] = pa;
                size[pa]++;
            } else {
                parent[pa] = pb;
                size[pb]++;
            }
            return true;
        }
    }

}


