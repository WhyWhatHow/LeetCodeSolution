package dsa.graph;

/**
 * @program: LeetCodeSolution
 * @description: 并查集
 * @author: WhyWhatHow
 * @create: 2024-10-28 21:35
 **/
public class UnionFind {
    int[] parent; // parent
    int[] size; // set's size

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    boolean union(int a, int b) {
        int pa = find(a); // a's parent node
        int pb = find(b); // b's parent node
        if (pa == pb) { // same set.
            return false;
        }
        if (size[pa] > size[pb]) { // setA > setB
            parent[pb] = pa;
            size[pa] += size[pb];
        } else {
            parent[pa] = pb;
            size[pb] += size[pa];
        }
        return true;
    }

    public static void main(String[] args) {
        // 初始化 UnionFind 并包含 5 个节点 (0 到 4)
        UnionFind uf = new UnionFind(5);

        // 测试用例：合并不同的节点并检查是否成功
        System.out.println("Union(0, 1): " + uf.union(0, 1)); // 应返回 true
        System.out.println("Union(1, 2): " + uf.union(1, 2)); // 应返回 true
        System.out.println("Union(2, 3): " + uf.union(2, 3)); // 应返回 true
        System.out.println("Union(3, 4): " + uf.union(3, 4)); // 应返回 true
        System.out.println("Union(0, 4): " + uf.union(0, 4)); // 已在同一集合，应返回 false

        // 检查 find 操作：所有节点应有相同的根节点
        int root = uf.find(0);
        System.out.println("Find(0): " + uf.find(0)); // 应返回相同的根节点
        System.out.println("Find(1): " + uf.find(1)); // 应返回相同的根节点
        System.out.println("Find(2): " + uf.find(2)); // 应返回相同的根节点
        System.out.println("Find(3): " + uf.find(3)); // 应返回相同的根节点
        System.out.println("Find(4): " + uf.find(4)); // 应返回相同的根节点

        // 测试路径压缩效果
        System.out.println("Path compression check:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Parent of " + i + ": " + uf.parent[i]); // 所有节点的父节点应被压缩至根节点
        }

        // 检查每个集合的大小
        System.out.println("Size of the set containing node 0: " + uf.size[root]); // 应为 5，因为所有节点已合并至一个集合中

    }
}




