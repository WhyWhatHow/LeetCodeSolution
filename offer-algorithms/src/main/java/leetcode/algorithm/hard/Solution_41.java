package leetcode.algorithm.hard;

import java.util.HashSet;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_41 {

    public static void main(String[] args) {
        Solution_41 sol = new Solution_41();
        System.out.println(sol.firstMissingPositive(new int[]{
//                1, 2, 0
                1, 2, 3, 10, 2147483647, 9
        }));
        ;
        System.out.println("==================");
    }


    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE, max = -1;
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
        }
        if (min > 1) return 1;
        int ans = 0;
        for (int i = min + 1; i < max; i++) {
            if (!set.contains(i)) {
                ans = i;
                break;
            }
        }
        // right check
        if (ans == 0) ans = max + 1;
        return ans;
    }
}


