package leetcode.algorithm;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_27 {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            if (nums[0] == val) {
                nums = null;
                return 0;
            } else {
                return 1;
            }
        }
        int cnt = 0;
        int start = -1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                if (start == -1) {//设置七起点位置
                    start = i;
                }
                cnt++;
            }
        }
        if (cnt==0) {
            return nums.length;
        }
        for (int i = start; i < nums.length - cnt; i++) {
            nums[i] = nums[i + cnt];
        }
        nums = Arrays.copyOfRange(nums, 0, nums.length - cnt);
//        for (int num : nums) {
//            System.out.println(num);
//        }
        return nums.length;
    }

    /**
     * sol 28
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        Solution_27 sol = new Solution_27();
//        int i = sol.removeElement(new int[]{2, 2, 3, 3}, 2);
//        int i = sol.removeElement(new int[]{2}, 3);
        int i = sol.removeElement(new int[]{3, 3}, 5);
        System.out.println(i);
        System.out.println("==================");
    }
}


