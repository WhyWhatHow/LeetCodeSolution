package leetcode.algorithm.window;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: LeetCodeSolution
 * @description: #binary Indexed Array
 * @author: WhyWhatHow
 **/

public class Solution_2294 {

    public static void main(String[] args) {
        Solution_2294 sol = new Solution_2294();
        System.out.println(sol.partitionArray(new int[]{
//                        3, 6, 1, 2, 5
//                1,2,3
                        2, 2, 4, 5
                },
//                2
//                1
                0
        ));
        System.out.println("==================");


    }

    public int partitionArray(int[] nums, int k) {
//        if (k == 0) {
//            HashSet<Integer> set = new HashSet<>();
//            for (int num : nums) {
//                set.add(num);
//            }
//            return set.size();
//        }
//        if (nums.length == 1) return 1;

        Arrays.sort(nums);
        int res = 0;
        int l = 0, r = 1;
        for (; r < nums.length; r++) {
            if (nums[r] - nums[l] > k) {
                l = r;
                res++;
            }
        }
        return l < r ? res + 1 : res;
    }
}


