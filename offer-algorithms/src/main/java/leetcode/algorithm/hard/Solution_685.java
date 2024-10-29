package leetcode.algorithm.hard;

import java.util.ArrayList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_685 {

    public static void main(String[] args) {
        Solution_685 sol = new Solution_685();
        System.out.println(sol.findRedundantDirectedConnection(new int[][]{
//                {1, 2}, {2, 3}, {3, 4}, {4,1}, {1, 5}
                {2, 1}, {3, 1}, {4, 2}, {1, 4}
        }));
        System.out.println("==================");
    }

    /**
     * in a tree,
     * root Node , in_degree = 0 ,
     * other node in_degree = 1;
     * if root_node in_degree =0 &&  one node as node_x's in_degree =2 ,
     * has circle,
     * no circle, delete the last edge.
     * if root_node in_degree =1 ==> has a circle, delete.
     */
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] in = new int[n + 1];
        ArrayList<int[]> q = new ArrayList<>(); // in_degree =2 node's edge. noCircle one edge, if not ,then the next.
        // count in_degree && noCircle in[] if exist a node's degree =2  ,
        for (int[] edge : edges) {
            int v = edge[1];
            in[v]++;
        }
        for (int i = 0; i < edges.length; i++) {
            if (in[edges[i][1]] == 2) {
                q.add(edges[i]);
            }
        }

        UnionFind uf = new UnionFind(n + 1);
        // all node's in_degree =1 ==> noCircle circle.
        if (q.size() == 0) {
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                if (!uf.union(u, v)) return edge; // circle, return
            }
        }

        for (int i = q.size() - 1; i >= 0; i--) {
            int[] tmp = q.get(i);
            uf = new UnionFind(n + 1);
            for (int[] edge : edges) {
                if (tmp == edge) continue;
                if (!uf.union(edge[0], edge[1])) {
                    return q.get(1-i); // exist a circle, return the
                }
            }
        }
        // not a circle, then return the second edge.
        return q.getLast();
    }


    class UnionFind {
        int[] p;
        int[] size;

        public UnionFind(int n) {
            p = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (p[x] != x) p[x] = find(p[x]);
            return p[x];
        }

        boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return false; // same set
            if (size[pa] >= size[pb]) {
                p[pb] = pa;
                size[pa] += size[pb];
            } else {
                p[pa] = pb;
                size[pb] += size[pa];
            }
            return true;
        }
    }
}


