package leetcode.algorithm.medium;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2070 {

    public static void main(String[] args) {
        Solution_2070 sol = new Solution_2070();
        System.out.println(sol.maximumBeauty(new int[][]{
                {193, 732}, {781, 962}, {864, 954}, {749, 627}, {136, 746},
                {478, 548}, {640, 908}, {210, 799}, {567, 715}, {914, 388},
                {487, 853}, {533, 554}, {247, 919}, {958, 150}, {193, 523},
                {176, 656}, {395, 469}, {763, 821}, {542, 946}, {701, 676}
        }, new int[]{
                885, 1445, 1580, 1309, 205, 1788, 1214, 1404, 572, 1170, 989, 265, 153, 151, 1479, 1180, 875, 276, 1584
        }));
        ;
        System.out.println("==================");
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]); // price asc
        TreeMap<Integer, Integer> map = new TreeMap<>(); // k,v->{price, maxBeauty}
        map.put(0, 0);
        int max = 0;
        for (int[] item : items) {
            max = Math.max(item[1], max);
            int finalMax = max;
            map.compute(item[0], (k, v) -> v == null ? finalMax : Math.max(finalMax, v));
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Integer j = map.floorKey(queries[i]);
            ans[i] = map.get(j);
        }


        return ans;
    }

}


