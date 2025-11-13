package leetcode.algorithm.array;

import java.math.BigInteger;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2654 {

    public static void main(String[] args) {
        Solution_2654 sol = new Solution_2654();
        System.out.println(sol.minOperations(new int[]{6, 10, 15}));
        System.out.println("==================");
    }

    public int minOperations(int[] nums) {
        //check has 1 or not;
        int cnt = 0;
        for (int num : nums) {
            if (num == 1) {
                cnt++;
            }
        }
        if (cnt > 0) return nums.length - cnt;

        // check subArray has 1 or not, use the minLen subArray as result.
        int minLen = nums.length;
        int sc = Integer.MAX_VALUE ; //subarray count
        for (int i = 0; i < nums.length; i++) {
            int g = gcd(nums[i], 0);
            int tmp = 0;
            for (int j = i + 1; j < nums.length; j++) {
                tmp++;
                g = gcd(nums[j], g);
                if (g == 1) {
                    sc = Math.min(sc, tmp);
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        if (sc== Integer.MAX_VALUE) return -1; // no gcd(a,b)==1 in array==> no answer .

        return nums.length  -1 +sc;

    }

    int gcd(int a, int b) {
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
//        if(b == 0) return a;
//        return gcd(b, a%b);
    }
}


