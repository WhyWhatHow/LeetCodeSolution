package leetcode.algorithm.dfs;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2597 {

    public static void main(String[] args) {
        Solution_2597 sol = new Solution_2597();
        System.out.println(sol.beautifulSubsets(new int[]{
//                2, 4, 6
                        4, 2, 5, 9, 10, 3
                },
//                2
                1
        ));
        System.out.println("==================");
    }


    int cnt = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        dfs(nums, 0, k);
        return cnt-1;
    }

    private void dfs(int[] nums, int i, int k) {
        if (i == nums.length) {
            cnt++;
            return;
        }
        // not chose
        dfs(nums, i + 1, k);


        // chose  nums[i] && nums[i] can be used.
        int cur = nums[i];
        if (map.getOrDefault(cur - k, 0) == 0 && map.getOrDefault(cur + k, 0) == 0) {  // nums[i] can be used.
            Integer val = map.compute(cur, (kk, v) -> v == null ? 1 : v + 1);
            dfs(nums, i + 1, k);
            map.put(cur, val - 1);
        }

    }


}


