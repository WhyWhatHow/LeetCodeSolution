package leetcode.algorithm.easy;

import java.util.HashSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_762 {

    public static void main(String[] args) {
        Solution_762 sol = new Solution_762();//
        System.out.println(sol.countPrimeSetBits(6, 10));
        System.out.println("==================");
    }

    static HashSet set = new HashSet<Integer>();

    static {
        boolean[] v = new boolean[10000];
//        v[2] =true ;
        for (int i = 2; i < v.length; i++) {
            if (!v[i]) {
                v[i] = true;
                set.add(i);
                for (int j = i + i; j < v.length; j += i) {
                    v[j] = true;
                }
            }
        }
    }

    public int countPrimeSetBits(int left, int right) {
        int res = 0;

        for (int i = left; i <= right; i++) {
            int cnt = Integer.bitCount(i);
            if (set.contains(cnt)) {
                res++;
            }
        }
        return res;
    }

}
