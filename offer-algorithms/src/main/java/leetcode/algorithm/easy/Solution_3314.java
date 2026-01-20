package leetcode.algorithm.easy;

import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3314 {

    public static void main(String[] args) {
        Solution_3314 sol = new Solution_3314();
        System.out.println("==================");
    }

    public int[] minBitwiseArray(List<Integer> nums) {
//        ans[i] OR (ans[i] + 1) == nums[i]
        int n = nums.size();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < nums.size(); i++) {
            int tar = nums.get(i);
            for (int j = 0; j < 1001; j++) {
                int v = j | (j + 1);
                if (tar == v) {
                    ans[i] = j;
                    break;
                }
            }
        }
        return ans;
    }


}


