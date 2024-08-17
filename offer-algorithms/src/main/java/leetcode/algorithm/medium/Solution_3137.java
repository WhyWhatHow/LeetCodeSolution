package leetcode.algorithm.medium;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3137 {

    public static void main(String[] args) {
        Solution_3137 sol = new Solution_3137();
        System.out.println(sol.minimumOperationsToMakeKPeriodic(
//                "leetcodeleet",
                "hnccccajbwccajut",
//                4
                2
        ));
        System.out.println("==================");
    }

    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        char[] chars = word.toCharArray();
        // count
        for (int i = 0; i <= chars.length - k; i+=k) {
            String key = new String(chars, i, k);
            map.compute(key, (kk, v) -> v == null ? 1 : v + 1);
        }
        int max = chars.length / k;
        int res = max;
        for (Integer value : map.values()) {
            res = Math.min(res, max - value);
        }
        return res;

    }

}


