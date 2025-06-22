package leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3085 {

    public static void main(String[] args) {
        Solution_3085 sol = new Solution_3085();
        System.out.println(Integer.valueOf('z'));
        System.out.println(Integer.valueOf('Z'));
//        System.out.println(sol.minimumDeletions("itatwtiwwi", 1));
        System.out.println(sol.minimumDeletions("vvnowvov", 2));

        System.out.println("==================");
    }

    /**
     *
     * @param word
     * @param k
     * @return
     */
    public int minimumDeletions(String word, int k) {
        char[] cs = word.toCharArray();
        int[] a = new int[128];
        for (char c : cs) {
            a[c]++;
        }
        Arrays.sort(a);

        int res = cs.length;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) continue;
            int base = a[i]; //  枚举 表示最少可以保存的数量.
            int maxSave = a[i]; // 表示最多可以保存的字母数量
            for (int j = i + 1; j < a.length; j++) {
                maxSave += a[j] < base + k ? a[j] : base + k;
            }
            res = Math.min(res, cs.length - maxSave);
        }
        return res;
    }

//    public int minimumDeletions(String word, int k) {
//        char[] cs = word.toCharArray();
//        int[] a = new int[128];
//        for (char c : cs) {
//            a[c]++;
//        }
//        PriorityQueue<Integer> minpq = new PriorityQueue<>();
//        PriorityQueue<Integer> maxpq = new PriorityQueue<>((aa, b) -> b - aa);
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] == 0) continue;
//            minpq.add(a[i]);
//            maxpq.add(a[i]);
//        }
//        int res = func(k, new PriorityQueue<>(minpq), new PriorityQueue<>(maxpq), true);
//        res = Math.min(res, func(k, minpq, maxpq, false));
//        return res;
//
//    }
//
//    private static int func(int k, PriorityQueue<Integer> minpq, PriorityQueue<Integer> maxpq, boolean yes) {
//        int res = 0;
//        while (!minpq.isEmpty() && !maxpq.isEmpty()) {
//            Integer min = minpq.poll();
//            Integer max = maxpq.poll();
//            if (max - min > k) {
//                // max > (min+k) ==> max = min+k
//                if (max - min - k < min) {
//                    res += max - min - k;
//                    max = min + k;
//                    minpq.add(min);
//                    maxpq.add(max);
//                } else if (max - min - k == min) {
//                    if (yes) {
//                        res += max - min - k;
//                        max = min + k;
//                        minpq.add(min);
//                        maxpq.add(max);
//                    } else {
//                        res += min;
//                        maxpq.add(max);
//                    }
//                } else { // 干掉最小的.
//                    res += min;
//                    maxpq.add(max);
//                }
//            } else {
//                break;
//            }
//        }
//        return res;
//    }

}


