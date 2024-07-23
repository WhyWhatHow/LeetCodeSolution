package leetcode.algorithm.dp;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #hard #dp
 * @author: WhyWhatHow
 **/

public class Solution_3098 {

    public static void main(String[] args) {
        Solution_3098 sol = new Solution_3098();
        System.out.println(sol.sumOfPowers(new int[]{1, 2, 3, 4}, 3));
        System.out.println("==================");
    }


    int mod = 1000000000 + 7;
    // for tle
    HashMap<String, Integer> map = new HashMap<>();
//    HashMap<Long, Integer> map = new HashMap<>();

    public int sumOfPowers(int[] nums, int k) {
        Arrays.sort(nums);
        int res = dfs(0, nums.length, k, Integer.MAX_VALUE / 2, nums);
        return res;


    }

    /**
     * @param i      current handle element's idx
     * @param pre    pre element
     * @param k      last k nums elements that need handle.
     * @param minVal cur's power number .
     * @param nums
     * @return
     */
    private int dfs(int i, int pre, int k, int minVal, int[] nums) {
        // no element need to handle
        if (k == 0) {
            return minVal;
        }

        // check Array's boundary
        if (i >= nums.length) {
            return 0 ;
        }
        // don't have enough element.
        if (nums.length - i < k) return 0;


        // i, pre 's range=[0,50] <2^6, so
//        long key = (1L * minVal) << 18 | (i << 12) | (pre << 6) | k;
        String key = i + "," + pre + ","+ k + "," + minVal;
        if (map.containsKey(key)) return map.get(key);

        int no = dfs(i + 1, pre, k, minVal, nums);
        int yes = 0;
        if (pre == nums.length) { // avoid Array out of bound exception .
            yes = dfs(i + 1, i, k - 1, minVal, nums);
        } else {
            yes = dfs(i + 1, i, k - 1, Math.min(minVal, Math.abs(nums[pre] - nums[i])), nums);
        }

        int val = (no + yes) % mod;
        map.put(key, val);
        return val;
    }

}


