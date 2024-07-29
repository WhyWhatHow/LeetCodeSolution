package leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2961 {

    public static void main(String[] args) {
        Solution_2961 sol = new Solution_2961();

        System.out.println("==================");
    }

    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> resList = new ArrayList<>();
        int cnt = 0;
        for (int[] a : variables) {
            if (a[0] > 10) a[0] %= 10;
            if (pow(pow(a[0], a[1], 10), a[2], a[3]) == target) {
                resList.add(cnt);
            }
            cnt++;
        }
        return resList;

    }

    int pow(int a, int n, int mod) {
        if (n == 0) {
            return 1;
        }
        int ans = 1, base = a;
        while (n != 0) {
            if ((n & 1) == 1) {// odd
                ans *= base;
                ans %= mod;
            }
            n >>= 1;
            base *= base;
            base %=mod;
        }
        return ans;
    }

}


