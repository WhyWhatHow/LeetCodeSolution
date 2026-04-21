package leetcode.algorithm.unionfind;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1722 {

    public static void main(String[] args) {
        Solution_1722 sol = new Solution_1722();//
//        System.out.println(1 ^ 1);
//        System.out.println(1 ^ 1 ^ 1);
        System.out.println(sol.minimumHammingDistance(
                new int[]{5, 1, 2, 4, 3},
                new int[]{1, 5, 4, 2, 3},
                new int[][]{{0, 4}, {4, 2}, {1, 3}, {1, 4}}
        ));
        System.out.println("==================");
    }


    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UnionFind uf = new UnionFind(n);
        for (int[] a : allowedSwaps) {
            int x = a[0], y = a[1];
            // [1,2,2,3] is error
//            uf.union(source[x], source[y]);
            uf.union(x, y);
        }

        var map = new HashMap<Integer, HashMap<Integer, Integer>>(); // key: roots.id , val{ key: source[i], val : cnt} // 对应值的数量.
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            // 将同一个连通块的 数据放在同一个 hashmap 中. 并统计相同元素的数量 . 
            map.computeIfAbsent(root, j -> new HashMap<>()).merge(source[i], 1, Integer::sum);
        }


        int res = 0;
        for (int i = 0; i < target.length; i++) {
            int root = uf.find(i);
            if (map.get(root).getOrDefault(target[i], 0) > 0) {
                map.get(root).merge(target[i], -1, Integer::sum);
            } else res++;
        }

        return res;
    }

    class UnionFind {
        int[] roots; // parent not
        int[] size;

        public UnionFind(int n) {
            roots = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (roots[x] != x) {
                roots[x] = find(roots[x]);
            }
            return roots[x];
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return false;

            if (size[pa] > size[pb]) {
                roots[pb] = pa;
                size[pa] += size[pb];
            } else {
                roots[pa] = pb;
                size[pb] += size[pa];
            }
            return true;
        }
    }
}
