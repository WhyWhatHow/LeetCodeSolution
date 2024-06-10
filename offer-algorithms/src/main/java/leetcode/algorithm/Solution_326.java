package leetcode.algorithm;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_326 {
    static int ans[] = new int[20];

    static {
        ans[0] = 1;
        ans[1] = 3;
        for (int i = 2; i < ans.length; i++) {
            ans[i] = ans[i - 1] * 3;
            System.out.println(i+", "+ ans[i]);
        }
    }

    public boolean isPowerOfThree(int n) {
        if (n==0) {
            return false;
        }
        int i = Arrays.binarySearch(ans, n);
        return i >=0;
    }

    public static void main(String[] args) {
        Solution_326 sol = new Solution_326();
        boolean powerOfThree = sol.isPowerOfThree(27);
        System.out.println("=================="+powerOfThree);
    }
}


