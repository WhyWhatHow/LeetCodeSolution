package leetcode.algorithm.dfs;

import java.util.HashSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_869 {

    public static void main(String[] args) {
        Solution_869 sol = new Solution_869();
//        for (int i = 1; i < 100; i++) {
//            System.out.println(sol.reorderedPowerOf2(i));
//
//        }
        System.out.println(sol.reorderedPowerOf2(
                46
        ));
        System.out.println("==================");
    }

    static HashSet<Integer> set = new HashSet<>();

    static {
        for (int i = 0; i <= 32; i++) {
            long val = 1l << i;
            if (val < 1000_000_001)
                set.add(1 << i);
        }
    }

    public boolean reorderedPowerOf2(int n) {
        if (set.contains(n)) return true;
        // n -> 重排序
        char[] cs = String.valueOf(n).toCharArray();
        int[] nums = new int[10];
        for (char c : cs) {
            nums[c - '0']++;
        }
        return dfs(0, 0, cs.length, nums);
//        return false;
    }

    /**
     * @param i    表示当前的位置
     * @param val
     * @param nums
     */
    private boolean dfs(int i, int val, int len, int[] nums) {
        if (i == len) {
            return set.contains(val);
        }
        boolean res = false;
        int tmp = val;
        if (i == 0) {
            for (int k = 1; k < nums.length; k++) {
                if (nums[k] > 0) {

                    val = val * 10 + k;
                    nums[k]--;
                    res = res || dfs(i + 1, val, len, nums);
                    nums[k]++;
                    val = tmp;
                    if (res) return res;
                }
            }
        } else {
            for (int k = 0; k < nums.length; k++) {
                if (nums[k] > 0) {
                    val = val * 10 + k;
                    nums[k]--;
                    res = res || dfs(i + 1, val, len, nums);
                    val = tmp;
                    nums[k]++;
                }
            }
        }
        return res;
    }
}


