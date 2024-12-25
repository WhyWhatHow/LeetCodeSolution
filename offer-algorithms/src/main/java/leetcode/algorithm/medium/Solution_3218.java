package leetcode.algorithm.medium;

import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3218 {

    public static void main(String[] args) {
        Solution_3218 sol = new Solution_3218();
        System.out.println(sol.minimumCost(3, 2,
                new int[]{
                        1, 3
                }, new int[]{
                        5
                }));
        System.out.println("==================");
    }

    // m -> h  , v->n
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int res = 0;
        int ch = 1, cv = 1;// cv = count n , ch = count m.
        PriorityQueue<int[]> pqV = new PriorityQueue<>((a, b) -> b[0] - a[0]); // row's max  ==> int[]{v[i], i}
        PriorityQueue<int[]> pqH = new PriorityQueue<>((a, b) -> b[0] - a[0]); // col's max  ==> int[]{h[i], i}
        for (int i = 0; i < verticalCut.length; i++) {
            pqV.add(new int[]{verticalCut[i], i});
        }
        for (int i = 0; i < horizontalCut.length; i++) {
            pqH.add(new int[]{horizontalCut[i], i});
        }
        while (!pqH.isEmpty() && !pqV.isEmpty()) {
            if (pqH.peek()[0] < pqV.peek()[0]) {
                int[] a = pqV.poll();
                cv++;
                res += ch * a[0];
            } else {
                int[] a = pqH.poll();
                ch++;
                res += cv * a[0];
            }
        }
        while (!pqH.isEmpty()) {
            int[] a = pqH.poll();
            ch++;
            res += cv * a[0];
        }
        while (!pqV.isEmpty()) {
            cv++;
            res += ch * pqV.poll()[0];
        }
        return res;
    }

}


