package leetcode.algorithm.dp;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1387 {

    public static void main(String[] args) {
        Solution_1387 sol = new Solution_1387();
//        System.out.println(sol.getKth(12, 15, 2));
        System.out.println(sol.getKth(1, 1000, 777));
        System.out.println("==================");
    }

    //    int[] f = new int[113003]; // f[i] means i's degree.
        HashMap<Integer, Integer> map;

        public int getKth(int lo, int hi, int k) {
            map = new HashMap<>();
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[1] != b[1]) return a[1] - b[1];
                else return a[0] - b[0];
            });
            for (int i = lo; i <= hi; i++) {
                int degree = getDegree(i);
                pq.add(new int[]{i, degree});
    //            System.out.println(i + ":" + f[i]);
            }
            int res = 0;
            while (k-- > 0) {
                res = pq.poll()[0];
            }
            return res;

        }

        private int getDegree(int i) {
            if (i <= 1) {
                map.put(i, 0);
                return 0;
            }
            if (map.containsKey(i)) return map.get(i);
    //        int res = 0;
    //        System.out.println(i);
            int res;
            if (isOdd(i)) res = getDegree(i * 3 + 1) + 1;
            else res = getDegree(i / 2) + 1;
            map.put(i, res);
            return res;
        }

        boolean isOdd(int x) {
            return (x & 1) == 1;
        }
}


