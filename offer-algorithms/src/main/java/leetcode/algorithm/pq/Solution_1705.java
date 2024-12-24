package leetcode.algorithm.pq;

import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1705 {

    public static void main(String[] args) {
        Solution_1705 sol = new Solution_1705();
        System.out.println(sol.eatenApples(new int[]{
//                1, 2, 3, 5, 2
//                2, 1, 1, 4, 5
                3,1,1,0,0,2
        }, new int[]{
//                3, 2, 1, 4, 2
//                10, 10, 6, 4, 2
                3,1,1,0,0,2
        }));
        System.out.println("==================");
    }

    public int eatenApples(int[] apples, int[] days) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {       // int[] -> {i+day[i], apples[i] }
            if (a[0] != b[0]) return a[0] - b[0]; // eat
            else return a[1] - b[1];
        });
//        HashMap<Integer, Integer> map = new HashMap<>();
        int n = apples.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (apples[i] > 0) {
                pq.add(new int[]{i + days[i], apples[i]});
            }
            while (!pq.isEmpty()) {
                int[] a = pq.poll();
                if (i >= a[0]) continue;
                a[1]--;
                cnt++;
                if (a[1] > 0) pq.add(a); break;
            }
        }
        int day = n;
        while (!pq.isEmpty()) {
            int[] a = pq.poll(); // {lastDay,nums}
            while (day < a[0] && a[1] > 0) {
                a[1]--;
                day++;
                cnt++;
            }
        }

        return cnt;
    }

}


