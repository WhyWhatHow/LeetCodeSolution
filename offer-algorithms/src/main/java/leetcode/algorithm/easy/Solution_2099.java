package leetcode.algorithm.easy;

import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2099 {

    public static void main(String[] args) {
        Solution_2099 sol = new Solution_2099();

        System.out.println("==================");
    }

    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> nums[b] - nums[a]);
        boolean[] v = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pq.add(i);
        }
        int n = k;
        while (k-- > 0) {
            v[pq.poll()] = true;
        }
        int[] ans = new int[n];
        int cnt = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i]) {
                ans[cnt++] = nums[i];
            }
        }
        return ans;
    }
}


