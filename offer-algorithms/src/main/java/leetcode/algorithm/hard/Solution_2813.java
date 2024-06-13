package leetcode.algorithm.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #binary Indexed Array
 * @author: WhyWhatHow
 **/

public class Solution_2813 {

    public static void main(String[] args) {
        Solution_2813 sol = new Solution_2813();
        System.out.println(sol.findMaximumElegance(new int[][]{
//                        {3, 2}, {5, 1}, {10, 1}
//                        {3, 1}, {3, 2}
//                        {8, 1}, {1, 2}, {1, 4}, {9, 1}
                        {10, 1}, {10, 1}, {10, 1}, {10, 1}, {10, 1}, {10, 1}, {10, 1}, {10, 1}, {10, 1}, {10, 1}, {3, 2}, {3, 3}, {3, 4}, {3, 5}, {3, 6}, {3, 7}, {3, 8}, {3, 9}, {3, 10}, {3, 11}

                },
//                2
//                1
//                3
                10
        ));
        ;
        System.out.println("==================");
    }

    /**
     * 两种情况:
     * 选相同种类的item k个, sum()+1, 与item 顺序无关.
     * 选不同种类的 item k 个,  sum() + k^2 , 与item 顺序无关.
     * 所以可以先排序.
     *
     * @param items
     * @param k
     * @return
     */
    public long findMaximumElegance(int[][] items, int k) {
        Arrays.sort(items, (a, b) -> b[0] - a[0]);
        long max = 0;
        long sum = 0;
        long size = 0;
        HashSet<Integer> set = new HashSet<>();
        LinkedList<Integer> list = new LinkedList<>();  // dup category

        // [0,k)
        for (int i = 0; i < k; i++) {
            int profit = items[i][0];
            int category = items[i][1];
            if (set.contains(category)) {
                list.push(profit);
            } else set.add(category);
            sum += profit;
        }
        size = set.size();
        max = sum + size * size;

        // [k,items.length-1]
        for (int i = k; i < items.length; i++) {
            int profit = items[i][0];
            int category = items[i][1];

            // replace repeated category low profit goods
            if (!list.isEmpty() && !set.contains(category)) {
                sum += profit - list.poll();
                set.add(category);
            }

            size = set.size();
            max = Math.max(max, sum + size * size);
        }

        return max;
    }

    /**
     * 两种情况:
     * 选相同种类的item k个, sum()+1, 与item 顺序无关.
     * 选不同种类的 item k 个,  sum() + k^2 , 与item 顺序无关.
     * 所以可以先排序.
     *
     * @param items
     * @param k
     * @return
     */
    public long findMaximumElegancelower(int[][] items, int k) {
        Arrays.sort(items, (a, b) -> b[0] - a[0]);
        long max = 0;
        long sum = 0;
        long size = 0;
        HashSet<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 只存 重复 category的item,

        // init handle [0,k) val
        for (int i = 0; i < k; i++) {
            sum += items[i][0];
            if (set.contains(items[i][1])) { //  category 已经计算过.
                pq.add(items[i][0]);
            } else {
                set.add(items[i][1]);
            }
        }
        size = set.size();
        max = Math.max(max, sum + size * size);

        // [k, items.length)
        for (int i = k; i < items.length; i++) {
            int[] arr = items[i];
            if (!set.contains(arr[1]) && !pq.isEmpty()) {
                sum = sum - pq.poll() + arr[0];
                set.add(arr[1]);
                max = Math.max(max, sum + (long) set.size() * set.size());
            }
        }

        return max;
    }
//
//    /**
//     * @param items items[i] = [profit_i, category_i]
//     * @param k
//     * @return
//     */
//    public long findMaximumEleganceNotUse(int[][] items, int k) {
//        HashMap<Integer, PriorityQueue> map = new HashMap<>();
//        // init
//        for (int[] item : items) {
//            if (map.containsKey(item[1])) {
//                PriorityQueue tempPq = map.get(item[1]);
//                tempPq.add(item[0]);
//                map.put(item[1], tempPq);
//            } else {
//                PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//                pq.add(item[0]);
//                map.put(item[1], pq);
//            }
//        }
//        long max = -1;
//        // category_cnt  > 1
//        Arrays.sort(items, (a, b) -> {
//            if (a[0] != b[0]) return b[0] - a[0];
//            else return a[1] - b[1];
//        });
//        HashSet<Integer> set = new HashSet<>();
//        int step = 0;
//        long sum = 0;
//        for (int[] item : items) {
//            if (set.contains(item[1])) {
//                sum += item[0];
//            }
//            if (++step == k) {
//                max = Math.max(max, sum + set.size() * set.size());
//            }
//        }
//
//        // category_cnt ==1  if item[1] nums >=k , chose max
//        for (PriorityQueue<Integer> pq : map.values()) {
//            if (pq.size() >= k) {
//                sum = 0;
//                int cnt = 0;
//                while (!pq.isEmpty()) {
//                    sum += pq.poll();
//                    if (++cnt == k) break;
//                }
//                max = Math.max(sum, max);
//            }
//        }
//
//        return max;
//    }
}


