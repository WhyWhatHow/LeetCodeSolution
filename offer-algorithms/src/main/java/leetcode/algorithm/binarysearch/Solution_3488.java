package leetcode.algorithm.binarysearch;

import java.util.*;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3488 {

    public static void main(String[] args) {
        Solution_3488 sol = new Solution_3488();//
        System.out.println(sol.solveQueries(
//                new int[]{1, 3, 1, 4, 1, 3, 2},
//                new int[]{0, 3, 5}
//                new int[]{14, 14, 4, 2, 19, 19, 14, 19, 14},
//                new int[]{2, 4, 8, 6, 3}
                new int[]{6, 12, 17, 9, 16, 7, 6},
                new int[]{5, 6, 0, 4}
        ));
        System.out.println("==================");
    }

    //  num ->2 num -> 3 num
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> resList = new ArrayList<>();

        int n = nums.length;
        var map = new HashMap<Integer, TreeSet<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> ss = Set.of(i, i + n, i + 2 * n);
            map.computeIfAbsent(nums[i], j -> new TreeSet<>()).addAll(ss);
        }
//        for (Integer k : map.keySet()) {
//            TreeSet<Integer> set = map.get(k);
//            Integer f = set.getFirst();
//            set.add(f-n); // lower
//            set.add(f+n); // higher
//        }


        for (int q : queries) {
            int tar = nums[q];
            if (map.getOrDefault(tar, new TreeSet<>()).size() <= 3) {
                resList.add(-1);
                continue;
            }
            TreeSet<Integer> set = map.get(tar);
            Integer lower = set.lower(q + n);
            Integer higher = set.higher(q + n);
            int tmp = n;

            tmp = Math.min(q + n - lower, higher - q - n);
            resList.add(tmp);
        }
        return resList;
    }


}
