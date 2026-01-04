package leetcode.algorithm.medium;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1390 {

    public static void main(String[] args) {
        Solution_1390 sol = new Solution_1390();
        System.out.println(sol.sumFourDivisors(new int[]{21, 4, 7, 8}));
        System.out.println("==================");
    }

    public int sumFourDivisors(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int num : nums) {
            res += getSum(num);
        }
        return res;
    }

    private int getSum(int num) {

        int mid = num / 2;
        var set = new HashSet<Integer>();
        set.add(1);
        set.add(num);
        for (int i = 2; i <= mid; i++) {
            if (num % i == 0) {
                set.add(i);
                set.add(num / i);
            }
            if (set.size() > 4) return 0;
        }
        if (set.size() != 4) return 0;
        int res = 0;
        for (Integer i : set) {
            res += i;
        }
        return res;
    }
}


