package leetcode.algorithm.demo;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_347 {

    public static void main(String[] args) {
        Solution_347 sol = new Solution_347();
        System.out.println("==================");
        System.out.println(sol.topKFrequent(new int[]{
                1, 1, 1, 2, 2, 3, 3, 3
        }, 2));
    }

    public int[] topKFrequent(int[] nums, int k) {

        int[] ans = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((b, a) -> a.cnt - b.cnt);

        map.forEach((key, v) -> pq.add(new Pair(key, v)));

        int cnt = 0;
        while (!pq.isEmpty()) {
            ans[cnt++] = pq.poll().k;
            if (cnt == k) break;
        }

        return ans;
    }
}

class Pair {
    int k, cnt = 0;

    Pair(int k, int cnt) {
        this.k = k;
        this.cnt = cnt;
    }
}
