package leetcode.algorithm.easy;

import java.util.Set;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3541 {

    public static void main(String[] args) {
        Solution_3541 sol = new Solution_3541();
        System.out.println("==================");
    }

    public int maxFreqSum(String s) {
        char[] cs = s.toCharArray();
        int[] a = new int[255];
        var set = Set.of('a', 'e', 'i', 'o', 'u');

        int max = 0;
        int  mm = 0 ;
        for (char c : cs) {
            a[c]++;
            if(set.contains(c)){
                max = Math.max(max, a[c]);
            }else {
                mm = Math.max(mm, a[c]);
            }
        }
        return mm +max;
        // find the max aeiou
//        for (char c : cs) {
//            if (set.contains(c)) {
//                max = Math.max(max, a[c]);
//            }
//        }
//        int mm = 0;
//        for (char c : cs) {
//            if (!set.contains(c)) {
//                mm = Math.max(mm, a[c]);
//            }
//        }
    }

}


