package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3577 {

    public static void main(String[] args) {
        Solution_3577 sol = new Solution_3577();
        System.out.println("==================");
    }

    int mod = 1000_000_007;

    public int countPermutations(int[] complexity) {

        // check we have answer or not
        int tar = complexity[0];
        for (int i = 1; i < complexity.length; i++) {
            if (tar >= complexity[i]) return 0;
        }

        // calculate the ans.
        long res = 1;
        long n = complexity.length - 1;
        for (long l = n; l > 0; l--) {
            res *= l;
            res %= mod;
        }
        return (int) res;
    }
}


