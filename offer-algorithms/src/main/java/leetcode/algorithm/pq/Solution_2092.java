package leetcode.algorithm.pq;

import java.util.*;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2092 {

    public static void main(String[] args) {
        Solution_2092 sol = new Solution_2092();
        System.out.println(sol.findAllPeople(6,
                new int[][]{{0, 2, 1}, {1, 3, 1}, {4, 5, 1}},
                1));
        System.out.println("==================");
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // init graph
        ArrayList<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] m : meetings) {
            int x = m[0], y = m[1], t = m[2];
            g[x].add(new int[]{y, t});
            g[y].add(new int[]{x, t});
        }
        // init  0-> firstPerson
        g[0].add(new int[]{firstPerson, 0});
        g[firstPerson].add(new int[]{0, 0});

        var q = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        q.add(new int[]{firstPerson, 0});
        var set = new HashSet<Integer>();
//        set.add(0);
        while (!q.isEmpty()) {
            int[] polled = q.poll();

            int id = polled[0], cost = polled[1];
            if (set.contains(id))
                continue;
            set.add(id);
            for (int[] a : g[id]) {
                int to = a[0], val = a[1];
                if (val < cost || set.contains(to)) continue;
                q.add(new int[]{to, val});
            }
        }
        return set.stream().toList();
    }
}


