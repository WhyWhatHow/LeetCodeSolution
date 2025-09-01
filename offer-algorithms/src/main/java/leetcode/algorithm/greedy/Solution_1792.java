package leetcode.algorithm.greedy;

import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1792 {

    public static void main(String[] args) {
        Solution_1792 sol = new Solution_1792();
        System.out.println(sol.maxAverageRatio(new int[][]{
                        {2, 4}, {3, 9}, {4, 5}, {2, 10}
//                        {1, 2}, {3, 5}, {2, 2}
                },
                4
//                2
        ));
        System.out.println("==================");
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            var va = cal(a);
            var vb = cal(b);
            return Double.compare(vb, va);
        });
        for (int[] aClass : classes) {
            pq.add(aClass);
        }
        while (extraStudents-- > 0) {
            int[] a = pq.poll();
            a[0]++;
            a[1]++;
            pq.add(a);
        }
        double sum = 0;
        while (!pq.isEmpty()) {
            int[] a = pq.poll();
            sum += 1.0d * a[0] / a[1];
        }
        return sum / classes.length;
    }

    double cal(int[] a) {
        // a[0]+1 /a[1]+1 - a[0]/a[1] # hint double 运算不能转换成int比较.
        return 1.0d * (a[0] + 1) / (a[1] + 1) - 1.0d * a[0] / a[1];
    }

}
