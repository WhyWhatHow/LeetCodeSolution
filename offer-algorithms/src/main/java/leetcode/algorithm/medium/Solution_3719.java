package leetcode.algorithm.medium;

import java.util.HashSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3719 {

    public static void main(String[] args) {
        Solution_3719 sol = new Solution_3719();//
        System.out.println(sol.longestBalanced(new int[]{
                1, 2, 3, 2
        }));
        System.out.println("==================");
    }

    public int longestBalanced(int[] nums) {
        int res = 0;
        int cnt = 0;// 偶数++ , odd--
        var oddset = new HashSet<Integer>();
        var evenset = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (isOdd(nums[j])) {
                    oddset.add(nums[j]);
                } else {
                    evenset.add(nums[j]);
                }
                if (oddset.size() == evenset.size()) res = Math.max(j - i + 1, res);
            }
            oddset.clear();
            evenset.clear();

        }
        return res;
    }

    boolean isOdd(int x) {
        return (x & 1) == 1;
    }
}
