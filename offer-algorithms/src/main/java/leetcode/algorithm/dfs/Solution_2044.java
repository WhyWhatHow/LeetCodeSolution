package leetcode.algorithm.dfs;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2044 {

    public static void main(String[] args) {
        Solution_2044 sol = new Solution_2044();
        System.out.println(sol.countMaxOrSubsets(new int[]{
                2, 2, 2
//                3,2,1,5
        }));

        System.out.println("==================");
    }


    public int countMaxOrSubsets(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(); // k:num, v: cnt
        boolean[] vis = new boolean[nums.length];
        dfs(nums, 0, 0, vis, map);
        int max = nums[0];

        for (Integer i : map.keySet()) {
            max = Math.max(max, i);
        }
        return map.get(max);
    }

    // dfs(i,sum) means [0,i) , 异或和为 sum的数量.
    private void dfs(int[] nums, int i, int sum, boolean[] vis, HashMap<Integer, Integer> map) {
        if (i >= nums.length || vis[i]) return;

        // not use nums[i]
        dfs(nums, i + 1, sum, vis, map);


        // use nums[i] ,
        vis[i] = true;
        map.compute(sum | nums[i], (k, v) -> v == null ? 1 : v + 1);
        dfs(nums, i + 1, sum | nums[i], vis, map);
        vis[i] = false;

    }

}


