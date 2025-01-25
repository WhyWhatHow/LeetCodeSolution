package leetcode.algorithm.hard;

import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2412 {

    public static void main(String[] args) {
        Solution_2412 sol = new Solution_2412();
        System.out.println(sol.minimumMoney(new int[][]{
                {5, 0}, {2, 1}, {4, 2}
                /////////////////
//                {3, 9},
//                {0, 4},
//                {7, 10},
//                {3, 5},
//                {0, 9},
//                {9, 3},
//                {7, 4},
//                {0, 0},
//                {3, 3},
//                {8, 0}
/////////////////////////////////////////////////////////
//                {91, 38},
//                {79, 43},
//                {45, 5},
//                {46, 1},
//                {6, 80},
//                {51, 5},
//                {16, 88},
//                {53, 99},
//                {46, 32},
//                {29, 38},
//                {9, 42},
//                {53, 77},
//                {13, 62},
//                {76, 10},
//                {1, 36},
//                {33, 73},
//                {97, 19},
//                {12, 8},
//                {39, 25},
//                {90, 54},
//                {23, 64},
//                {21, 43},
//                {20, 67},
//                {16, 22},
//                {59, 46},
//                {64, 55},
//                {4, 30},
//                {53, 100},
//                {9, 31},
//                {41, 100},
//                {19, 21},
//                {6, 20},
//                {49, 92},
//                {54, 32},
//                {91, 36},
//                {63, 30},
//                {86, 25},
//                {2, 81},
//                {54, 42},
//                {37, 38},
//                {93, 95},
//                {87, 34},
//                {6, 12},
//                {84, 73},
//                {12, 5},
//                {39, 98},
//                {50, 89},
//                {28, 35},
//                {75, 77},
//                {7, 72},
//                {30, 17},
//                {34, 7},
//                {39, 98},
//                {61, 39},
//                {0, 82},
//                {87, 13},
//                {18, 16},
//                {37, 76}
        }));
        System.out.println("==================");
    }

    // two case :
    //1.  cost< cashback : cashbark asc
    //2. cost >= cashback : cost desc
    public long minimumMoney(int[][] transactions) {
        boolean[] vis = new boolean[transactions.length];
        // handle all lose money case .
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        }); // pay >earn
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i][0] > transactions[i][1]) {
                pq.add(transactions[i]);
                vis[i] = true;
            }
        }
        long res = 0;
        long remain = 0;

        while (!pq.isEmpty()) {
            if (pq.peek()[0] > pq.peek()[1]) {
                int[] a = pq.poll();
                res += a[0] - remain;
                remain = a[1];
            } else
                break;
        }

        // handle pay <=earn , so we chose pay more case.
        PriorityQueue<int[]> pqq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < transactions.length; i++) {
            if (!vis[i]) pqq.add(transactions[i]);
        }

        while (!pqq.isEmpty()) {
            int[] a = pqq.poll();
            if (remain >= a[0]) {
                remain = remain - a[0] + a[1];
                continue;
            }
            res += a[0] - remain;
            remain = a[1];
        }

        return res;
    }

}
