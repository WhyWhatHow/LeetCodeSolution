package leetcode.algorithm.easy;

import java.util.ArrayList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2595 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(3);
        Solution_2595 sol = new Solution_2595();
        sol.evenOddBit(50);
        System.out.println("==================");
    }

    public int[] evenOddBit(int n) {
        char[] cs = Integer.toBinaryString(n).toCharArray();
        int even = 0, odd = 0;
        int cnt = 0;
        for (int i = cs.length - 1; i >= 0; i--) {
            if (cs[i] == '1') {
                if ((cnt & 1) == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            cnt++;
        }

        return new int[]{even, odd};
    }

}
