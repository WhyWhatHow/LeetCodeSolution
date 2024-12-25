package leetcode.algorithm.hard;

import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3219 {

    public static void main(String[] args) {
        Solution_3219 sol = new Solution_3219();
        System.out.println(sol.minimumCost(3, 2,
                new int[]{
                        1, 3
                }, new int[]{
                        5
                }));
        System.out.println("==================");
    }

    // m -> h  , v->n

    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        long res = 0;
        int ch = 1, cv = 1;// cv = count n , ch = count m.
        PriorityQueue<Integer> pqV = new PriorityQueue<>((a, b) -> b - a); // row's max  ==> int[]{v[i], i}
        PriorityQueue<Integer> pqH = new PriorityQueue<>((a, b) -> b - a); // col's max  ==> int[]{h[i], i}
        for (int i : verticalCut) {
            pqV.add(i);
        }
        for (int i : horizontalCut) {
            pqH.add(i);
        }
        while (!pqH.isEmpty() && !pqV.isEmpty()) {
            if (pqH.peek() < pqV.peek()) {
                int a = pqV.poll();
                cv++;
                res += ch * a;
            } else {
                int a = pqH.poll();
                ch++;
                res += cv * a;
            }
        }
        while (!pqH.isEmpty()) {
            int a = pqH.poll();
            ch++;
            res += cv * a;
        }
        while (!pqV.isEmpty()) {
            cv++;
            res += ch * pqV.poll();
        }
        return res;

    }

}


