package leetcode.algorithm.pq;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_2462 {

    public static void main(String[] args) {
        Solution_2462 sol = new Solution_2462();
//        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
//        for (int i = 0; i < 10; i++) {
//            pq.add(i);
//        }
//        System.out.println(pq.peek());
        int[] costs = new int[]{
//                17,12,10,2,7,2,11,20,8
//                211, 169, 4359, 2335, 3956, 658, 1371, 1516, 4637, 2588, 4166, 250, 4866, 3122, 1197, 61, 292, 1616, 4857, 4067, 1428, 4912, 3071, 3108, 2221, 1932, 4183, 4101, 727, 2715, 64, 357, 1186, 2444, 3766, 3978, 1962, 1648, 871, 2961, 1164, 4792, 1528, 2064, 2653, 179, 2780, 3732, 2881, 1165, 623, 362, 2371, 1353, 4219, 4438, 3765, 4567, 1372, 4669, 1496, 3353, 4147, 33, 4378, 4634, 1331, 3014, 3723, 3271, 433, 1065, 2345, 4445, 4077, 2708, 1303, 2666, 3311, 1546, 3078, 4467, 1683, 414, 4282, 3510, 478, 2858, 4805, 1113, 783, 3999, 2685, 1025, 3111, 2394, 2985, 2693, 1068, 1806, 690, 4867, 4178, 1726, 1680, 1860, 155, 96, 1500, 4250, 286, 4145, 771, 1728, 2677, 353, 1163, 4876, 2066, 3910, 2578, 1298, 3321, 3236, 1152, 3140, 2294, 2200, 69, 3027, 3675, 3594, 74, 3575, 2279, 4874, 1071, 3085, 1786, 4596, 1584, 42, 411, 3962, 2704, 4411, 1926, 1300, 4533, 2119, 3924, 1034, 128, 911, 4717, 4767, 1669, 3669, 2936, 2099, 3395, 2487, 2539, 4722, 122, 642, 4680, 4813, 708, 4938, 4156, 1152, 2789, 699, 4724, 4159, 1766, 2662, 492, 2612, 330, 2010, 458, 161, 794, 2062, 4281, 717, 3486, 3331, 474, 4734, 1869, 4817, 2796, 1511, 146, 3857, 3471, 3674, 45, 519, 3035, 3830, 4566, 957, 4705, 3194, 1524, 2668, 903, 2833, 2118, 929, 266, 1177, 3297, 1681, 400, 2635, 1962, 1682, 2116, 603, 1521
                25, 65, 41, 31, 14, 20, 59, 42, 43, 57, 73, 45, 30, 77, 17, 38, 20, 11, 17, 65, 55, 85, 74, 32, 84
        };
        System.out.println(costs.length);
        System.out.println(Arrays.stream(costs).sum());
        System.out.println(sol.totalCost(costs,
//                3,4
//                222, 2
                24,8
        ));
        System.out.println("==================");
    }


    public long totalCostBetter(int[] costs, int k, int candidates) {
        // [][]
        long  res = 0 ;


        return res ;
    }
    /**
     * 维护两个min_heap, 然后遍历整个数组, 模拟整个操作过程, 需要注意避免下标越界的情况. 对数据进行筛选即可.
     * @param costs
     * @param k
     * @param candidates
     * @return
     */
    public long totalCost(int[] costs, int k, int candidates) {

        long res = 0;
        boolean[] vis = new boolean[costs.length];
        int l = 0, r = costs.length - 1;
        // int[] int[0] = idx , int[1] val
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        PriorityQueue<int[]> pqEnd = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        while (k > 0) {

            // add
            // top
            while (l <= r && pq.size() < candidates && !vis[l]) {
                pq.add(new int[]{l, costs[l]});
                l++;
            }
            //end
            while (l <= r && pqEnd.size() < candidates && !vis[r]) {
                pqEnd.add(new int[]{r, costs[r]});
                r--;
            }

            // 排除已访问的元素
            while (!pq.isEmpty() && vis[pq.peek()[0]]) {
                pq.poll();
            }
            while (!pqEnd.isEmpty() && vis[pqEnd.peek()[0]]) {
                pqEnd.poll();
            }

            // 排除 pq &&  pqEnd 为空的情况.
            if (pq.isEmpty() && pqEnd.isEmpty()) {
                continue;
//                break;
            }

            int[] top = pq.isEmpty() ? null : pq.peek();
            int[] end = pqEnd.isEmpty() ? null : pqEnd.peek();

            // pq or pqEnd one null
            if (top == null) {
                res += end[1];
                vis[end[0]] = true;
                pqEnd.poll();
                k--;
                continue;
            }
            if (end == null) {
                res += top[1];
                pq.poll();
                vis[top[0]] = true;
                k--;
                continue;
            }
            // 排除相同下标元素
            if (top[0] == end[0]) {
                res += top[1];
                k--;
                pq.poll();
//                pqEnd.poll();
                vis[top[0]] = true;
                continue;
            }

            // pq && pqEnd  not null
            if (top[1] <= end[1]) {
                pq.poll();
                res += top[1];
                vis[top[0]] = true;
                k--;
            }
//            else if (top[1] == end[1]) {
//                pq.poll();
//                res += top[1];
//                vis[top[0]] = true;
//                k--;
//            }
            else {
                pqEnd.poll();
                res += end[1];
                vis[end[0]] = true;
                k--;
            }

        }
        return res;
    }


}


