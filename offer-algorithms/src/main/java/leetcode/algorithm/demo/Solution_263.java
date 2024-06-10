package leetcode.algorithm.demo;

import java.util.HashSet;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_263 {

    public static void main(String[] args) {
        Solution_263 sol = new Solution_263();
        System.out.println("==================");
        System.out.println(sol.isUgly(14));
        System.out.println(sol.isUgly(8));
        System.out.println(sol.isUgly(18));
        System.out.println(sol.isUgly(0));
    }

    public boolean isUgly(int n) {
        // 2,3,5
        if (n == 0) return false;
        if (n == 1) return true;

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(5);
        int temp;
        if (n % 2 == 0) n = handle(n, 2, set);
        if (n % 3 == 0) n = handle(n, 3, set);
        if (n % 5 == 0) n = handle(n, 5, set);
        return set.contains(n);
    }

    int handle(int n, int k, HashSet set) {
        while (n % k == 0) {
            n = n / k;
        }
        return n;
    }

}


