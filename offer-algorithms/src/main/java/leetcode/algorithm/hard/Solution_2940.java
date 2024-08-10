package leetcode.algorithm.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2940 {

    public static void main(String[] args) {
        Solution_2940 sol = new Solution_2940();
        System.out.println(sol.leftmostBuildingQueries(new int[]{
                5, 3, 8, 2, 6, 1, 4, 6
//                269985835,760522231,728489527,296712593,519803050,887706924,946304144,519729766,457715600,21283905
//                1, 2, 1, 2, 1, 2
//                999999999, 0, 1, 2, 3, 4, 5, 6, 1000_000_000
        }, new int[][]{
                {0, 7}, {3, 5}, {5, 2}, {3, 0}, {1, 6}
//                {2,1}
//                {1, 2}, {1, 3}, {1, 4}
//                {0, 1}{0, 2}
        }));
        System.out.println("==================");
    }

    /**
     * make sure a<=b
     * if a==b || heights[a] < heights[b] , ans[i] = b
     * if heights[a]>= heights[b], exists index t(t>b), heights[a]< heights[t]
     *
     * @param heights
     * @param queries
     * @return
     */
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        ArrayList<int[]>[] qlist = new ArrayList[heights.length];
        for (int i = 0; i < qlist.length; i++) {
            qlist[i] = new ArrayList<>();
        }
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0]; int b = queries[i][1];
            if (a > b) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            if (a == b || heights[a] < heights[b]) ans[i] = b;
            else {
                qlist[b].add(new int[]{heights[a], i});
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < heights.length; i++) {
            while (!pq.isEmpty() && pq.peek()[0] < heights[i]) {
                ans[pq.poll()[1]] = i;
            }
            pq.addAll(qlist[i]);
        }

        return ans;
    }

    /**
     * wa , case 945
     *
     * @param heights
     * @param queries
     * @return
     */
    public int[] leftmostBuildingQueriesWA(int[] heights, int[][] queries) {
        int[] ans = new int[queries.length];
        int[][] maxLefts = new int[heights.length][2]; // {maxleft,index}
        int idx = heights.length - 1;
        int max = heights[idx];
        Arrays.fill(ans, -1);

        // set maxlefts
        maxLefts[idx][0] = -1;
        maxLefts[idx][1] = -1;
        for (int i = heights.length - 2; i >= 0; i--) {
            if (heights[i] < heights[i + 1]) {
                maxLefts[i][0] = heights[i + 1];
                maxLefts[i][1] = i + 1;

                if (max <= heights[i + 1]) {
                    max = heights[i + 1];
                    idx = i + 1;
                }
            } else {

                if (heights[i] < maxLefts[i + 1][0]) {
                    maxLefts[i] = maxLefts[i + 1];
                    continue;
                }
//                } else if (heights[i] < max) {
//                    maxLefts[i][0] = max;
//                    maxLefts[i][1] = idx;
//            }

                int pos = findMaxLeft(heights[i], i + 1, maxLefts);
                if (pos != -1) {
                    maxLefts[i][0] = heights[pos];
                    maxLefts[i][1] = pos;
                } else {
                    maxLefts[i][0] = -1;
                    maxLefts[i][1] = -1;
                }
            }
        }


        for (int i = 0; i < queries.length; i++) {
            int a = Math.min(queries[i][0], queries[i][1]), b = Math.max(queries[i][0], queries[i][1]);
            if (heights[a] < heights[b] || a == b) {
                ans[i] = b;
            } else {
                ans[i] = findMaxLeft(heights[a], b, maxLefts);
            }
        }

        return ans;
    }

    private int findMaxLeft(int height, int start, int[][] maxLefts) {
//        if (height < maxLefts[start][0]) return start;
        boolean yes = true;
        while (maxLefts[start][0] < height && start < maxLefts.length) {
            start = maxLefts[start][1];
            if (start == -1 || maxLefts[start][0] == -1) {
                yes = false;
                break;
            }
        }
        if (start != -1 && maxLefts[start][0] <= height) yes = false;
        return !yes ? -1 : maxLefts[start][1];
    }

}


