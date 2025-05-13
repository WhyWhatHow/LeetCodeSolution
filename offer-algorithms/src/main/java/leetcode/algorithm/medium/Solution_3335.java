package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3335 {

    public static void main(String[] args) {
        Solution_3335 sol = new Solution_3335();
        System.out.println(sol.lengthAfterTransformations("avbz", 2));
        System.out.println("==================");
    }

    int mod = 1000_000_007;

    public int lengthAfterTransformations(String s, int t) {
        char[] cs = s.toCharArray();
        int[] nums = new int[26]; //
        for (char c : cs) {
            nums[c - 'a']++;
        }
        nums = dfs(1, t, nums);

        long res = 0;
        for (int num : nums) {
            res += num;
            res = res > mod ? res % mod : res;
        }
        return (int) res;
    }

    /**
     * f(i,c) 表示 第i 次转换, 字符c 的数量.
     * f(i,a) = f(i-1,z) +nums[a]
     * f(i,b) = f(i-1,a) + f(i-1,z)
     * f(i,c) = f(i-1,b) + nums[
     * f(i,d)  =f(i-1,c)
     * f(i,z) = f(i-1,y)
     *
     * @param i
     * @param t
     * @param nums 表示上一次数组取值
     */
    private int[] dfs(int i, int t, int[] nums) {
        if (i == t) return nums;

        int[] a = new int[26];
        a[0] = nums[25];
        a[1] = (nums[0] + nums[25]) % mod;
        for (int j = 2; j < nums.length; j++) {
            a[j] = nums[j - 1];
        }
        nums = a;
        return dfs(i + 1, t, nums);
    }
}


