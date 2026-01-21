package leetcode.algorithm.medium;

import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3315 {

    public static void main(String[] args) {
        Solution_3315 sol = new Solution_3315();
        System.out.println(sol.getMinBit(5));
        System.out.println("==================");
    }

    // 5 -> 111  左移 ->100|011 去首位
    // 3 -> 11  左移  -> 01| 10 去首位
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < nums.size(); i++) {
            int tar = nums.get(i);
            // 左移判断
            ans[i] = getMinBit(tar);
        }
        return ans;
    }

    private int getMinBit(int tar) {
        char[] cs = Integer.toBinaryString(tar).toCharArray();
        int idx = -1;
        for (int i = cs.length - 1; i >= 0; i--) {
            if (cs[i] == '0') {
                idx = i;
                break;
            }
        }
        if (idx == cs.length - 1) return -1;
//        char[] ts;
        if (idx == -1) cs[0] = '0';
        else cs[idx+1] = '0';
//        else ts = Arrays.copyOfRange(cs, idx, cs.length);

        int res = 0;
        for (char c : cs) {
            res = res * 2 + c - '0';
        }
        return res;
    }

}


