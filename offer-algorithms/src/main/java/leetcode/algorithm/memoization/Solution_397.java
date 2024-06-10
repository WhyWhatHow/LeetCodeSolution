package leetcode.algorithm.memoization;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_397 {

    public static void main(String[] args) {
        Solution_397 sol = new Solution_397();
        for (int i = 1; i < 10; i++) {
            System.out.println("i: " + i + " , " + sol.integerReplacement(i));
        }
        System.out.println(sol.integerReplacement(65535));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(sol.integerReplacement(2147483647));
        System.out.println("==================");
    }

    HashMap<Integer, Integer> map = new HashMap<>();

    public int integerReplacement(int n) {
        if (n <= 1) return 0;
        if (n == Integer.MAX_VALUE) return 32;
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int val;
        // even
        if ((n & 1) == 0) {
            val = integerReplacement(n / 2) + 1;
        } else {
            // odd
            val = Math.min(integerReplacement(n - 1), integerReplacement(n + 1)) + 1;
        }
        map.put(n, val);

        return val;
    }
}


