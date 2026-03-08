package leetcode.algorithm.medium;

import java.util.HashSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1980 {

    public static void main(String[] args) {
        Solution_1980 sol = new Solution_1980();//

        System.out.println("==================");
    }

    public String findDifferentBinaryString(String[] nums) {
        // 每一个str, 个取一位, 然后每一个都不同就可以.
        char[] cs = new char[nums[0].length()];
        for (int i = 0; i < nums.length; i++) {
            cs[i] = nums[i].charAt(i) == '0' ? '1' : '0';
        }
        return String.valueOf(cs);
    }

    public String findDifferentBinaryStringStupid(String[] nums) {
        int n = nums[0].length();
        var set = new HashSet<Integer>();
        for (String num : nums) {
            int res = 0;
            for (char c : num.toCharArray()) {
                res = res * 2 + c - '0';
            }
            set.add(res);
        }
        int max = 1 << n;
        String res = "";
        for (int i = 0; i < max; i++) {
            if (set.contains(i)) continue;
            else {
                res = Integer.toBinaryString(i);
                break;
            }
        }
        while (n > res.length()) {
            res = "0" + res;
        }
        return res;
    }

}
