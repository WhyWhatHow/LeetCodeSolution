package dsa.graph;

import java.util.*;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2023-10-09 11:27
 **/
public class TopologicalSort {

    public static List<Integer> topologicalSort(List<List<Integer>> graph) {
        int n = graph.size();

        // 计算每个节点的入度
        int[] inDegree = new int[n];
        for (List<Integer> neighbors : graph) {
            for (int neighbor : neighbors) {
                inDegree[neighbor]++;
            }
        }

        // 使用队列保存入度为0的节点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();

        // 拓扑排序
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            // 更新邻接节点的入度
            for (int neighbor : graph.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (result.size() != n) {
            // 图中存在环，无法进行拓扑排序
            return new ArrayList<>();
        }

        return result;
    }

    public static void main(String[] args) {
        // 构建有向图的邻接链表表示
        int n = 7; // 节点数量
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(1).add(4);
        graph.get(2).add(5);
        graph.get(2).add(6);

        List<Integer> result = topologicalSort(graph);
        if (result.isEmpty()) {
            System.out.println("有环,不能进行拓扑排序");
        } else {
            System.out.println("拓扑排序结果:" + result);
        }
        System.out.println("///////////////////////////////////");
        testTopologicalSort_CorrectCase();
        System.out.println("--------------------------------------");
        testTopologicalSort_CycleCase();
    }
    public static void testTopologicalSort_CorrectCase() {
        // 构建有向图的邻接链表表示
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(Arrays.asList(1, 2));  // 节点0的邻接节点为1和2
        graph.add(Arrays.asList(3));     // 节点1的邻接节点为3
        graph.add(Arrays.asList(4));     // 节点2的邻接节点为4
        graph.add(Arrays.asList(5));     // 节点3的邻接节点为5
        graph.add(Arrays.asList(5));     // 节点4的邻接节点为5
        graph.add(new ArrayList<>());    // 节点5没有邻接节点

        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4, 5);

        List<Integer> result = TopologicalSort.topologicalSort(graph);

        System.out.println(result.isEmpty());
    }

    public  static void testTopologicalSort_CycleCase() {
        // 构建有环图的邻接链表表示
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(Arrays.asList(1));     // 节点0的邻接节点为1
        graph.add(Arrays.asList(2));     // 节点1的邻接节点为2
        graph.add(Arrays.asList(3));     // 节点2的邻接节点为3
        graph.add(Arrays.asList(4));     // 节点3的邻接节点为4
        graph.add(Arrays.asList(5));     // 节点4的邻接节点为5
        graph.add(Arrays.asList(2));     // 节点5的邻接节点为2，形成循环

        List<Integer> expected = new ArrayList<>();

        List<Integer> result = TopologicalSort.topologicalSort(graph);

        System.out.println(result.isEmpty());
    }
}
