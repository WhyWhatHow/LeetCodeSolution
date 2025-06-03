package leetcode.algorithm.bfs;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1298 {

    public static void main(String[] args) {
        Solution_1298 sol = new Solution_1298();

        System.out.println("==================");
    }

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]); // {boxId, boxStatus}
        int res = 0; // means candies number .
        HashSet<Integer> ks = new HashSet<>(); // 表示当前有的key.
        for (int i : initialBoxes) {
            q.add(new int[]{i, status[i]});
        }

        while (!q.isEmpty()) {
            int[] polled = q.poll();
            int cur = polled[0];
            if (!ks.contains(cur) && polled[1] == 0) break;

            res += candies[cur];

            // 处理box
            for (int i : keys[cur]) {
                ks.add(i);
            }
            for (int i : containedBoxes[cur]) {
                q.add(new int[]{i, status[i]});
            }
        }
        return res;

    }

}


