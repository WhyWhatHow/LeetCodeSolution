package leetcode.algorithm.dp;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3850 {

    public static void main(String[] args) {
        Solution_3850 sol = new Solution_3850();//
        System.out.println("==================");
    }

    record Pair(int i, long x, long y) {  // x/y

    }

    HashMap<Pair, Integer> map = new HashMap<>();
    // set f (i, j) means [0,i] range ,val ==j 's cnt.

    public int countSequences(int[] nums, long k) {
        long max = 1;
        for (int num : nums) {
            max *= num;
        }
        if (max < k) return 0;

        map.put(new Pair(0, nums[0], 1), 1);
        map.compute(new Pair(0, 1, nums[0]), (kk, v) -> v == null ? 1 : v + 1);
        map.compute(new Pair(0, 1, 1), (kk, v) -> v == null ? 1 : v + 1);

        return dfs(nums.length - 1, k, 1, nums);

    }

    private int dfs(int i, long k, long fm, int[] nums) {
        if (i < 0) return 0;
        var key = new Pair(i, k, fm);
        if (map.containsKey(key)) return map.get(key);

        int res = 0;
        // no operation
        res += dfs(i - 1, k, fm, nums);
        // mut
        long gcd = gcd(k * nums[i], fm);
        res += dfs(i - 1, k * nums[i] / gcd, fm / gcd, nums);
        // div
        long gg = gcd(k, fm * nums[i]);
        res += dfs(i - 1, k / gg, fm * nums[i] / gg, nums);
        map.put(key, res);

        return res;
    }

    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
