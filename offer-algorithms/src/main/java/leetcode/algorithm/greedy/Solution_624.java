package leetcode.algorithm.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_624 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(3);
        Solution_624 sol = new Solution_624();
        System.out.println("==================");
    }

    // []+arrays, prev_arrays, and cur_array.
    public int maxDistance(List<List<Integer>> arrays) {
        int max = Integer.MIN_VALUE / 2; // 标记以访问数组中的最大值
        int min = Integer.MAX_VALUE / 2; // 以访问数组中的最小值.
        int n = arrays.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = arrays.get(i).get(0);
            int y = arrays.get(i).getLast();
            ans = Math.max(ans, Math.max(y - min, max - x));
            min = Math.min(min, x);
            max = Math.max(max, y);
        }
        return ans ;
    }

    public int maxDistanceStupid(List<List<Integer>> arrays) {
        int n = arrays.size();
        int max = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> mpq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < arrays.size(); i++) {
            pq.add(new int[]{arrays.get(i).get(0), i});
            mpq.add(new int[]{arrays.get(i).getLast(), i});
        }
        while (!mpq.isEmpty()) {
            if (pq.peek()[1] == mpq.peek()[1]) mpq.poll();
            else max = Math.max(max, mpq.poll()[0] - pq.poll()[0]);
        }
        pq.clear();
        mpq.clear();
        for (int i = 0; i < arrays.size(); i++) {
            pq.add(new int[]{arrays.get(i).get(0), i});
            mpq.add(new int[]{arrays.get(i).getLast(), i});
        }
        while (!pq.isEmpty()) {
            if (pq.peek()[1] == mpq.peek()[1]) pq.poll();
            else max = Math.max(max, mpq.poll()[0] - pq.poll()[0]);
        }
        return max;
    }

}
