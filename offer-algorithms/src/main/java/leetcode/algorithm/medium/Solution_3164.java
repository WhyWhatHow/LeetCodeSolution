package leetcode.algorithm.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3164 {

    public static void main(String[] args) {
        Solution_3164 sol = new Solution_3164();
        System.out.println(3 << 1);
        System.out.println(sol.numberOfPairs(new int[]{
//                1, 3, 4
                        1, 5, 18
                }, new int[]{
//                1, 3, 4
                        1, 19, 16
                },
//                1
                2
        ));

        System.out.println("==================");
    }

    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        long res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums1) {
            map.compute(i, (key, v) -> v == null ? 1 : v + 1);
        }
        HashMap<Integer, Integer> mm = new HashMap<>();
        for (int i : nums2) {
            mm.compute(i, (key, v) -> v == null ? 1 : v + 1);
        }

        Arrays.sort(nums1);
        int max = nums1[nums1.length - 1];
        List<Integer> ss = mm.keySet().stream().sorted().toList();
        for (Integer i : ss) {
            int base = i * k;
            int tmp = base;
            int cnt = 0;
            while (base <= max) {
                cnt += map.getOrDefault(base, 0);
                base += tmp;
            }
            res += (long) cnt * mm.get(i);
        }
        return res;
    }

}


