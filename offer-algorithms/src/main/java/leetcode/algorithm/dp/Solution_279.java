package leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_279 {

    public static void main(String[] args) {
        Solution_279 sol = new Solution_279();
        System.out.println("==================");
    }

    int[] arr = new int[101];

    void init() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * i;
        }
    }

    public int numSquares(int n) {
        init();
        int[] f = new int[n + 1];// means n = idx min number usage.
        Arrays.fill(f, n);
        f[1] = 1;
        f[0] = 0; // n !=0
        for (int i : arr) {
            if (i <= n) f[i] = 1;
        }
        for (int i = 1; i < f.length; i++) {
            for (int a : arr) {
                if (i >= a) {
                    f[i] = Math.min(f[i], f[i - a] + 1);
                }
            }
        }
        return f[n];
    }

}
