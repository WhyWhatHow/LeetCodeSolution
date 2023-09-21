package leetcode.algorithm.demo;

import java.util.HashSet;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_128 {

    public static void main(String[] args) {
        Solution_128 sol = new Solution_128();
        System.out.println("==================");
        sol.longestConsecutive(new int[]{1, 2, 3, 4, 100, 200});
    }

    /**
     * -1000000,1,8,0,
     * o(n) time request
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet();

        for (int num : nums) {
            set.add(num);
        }
        int max = -1;
        //  cnt, start

        for (Integer integer : set) {
            // remove repeat computing
            if (set.contains(integer - 1)) continue;
            int res = 0;
            res += 1;
            while (set.contains(integer + res)) {
                res += 1;
            }
//            map.put(integer,res);
            max = Math.max(res, max);
        }
        return max;
    }

}


