package leetcode.algorithm.easy;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1752 {

    public static void main(String[] args) {


        Solution_1752 sol = new Solution_1752();//
        System.out.println(sol.check(new int[]{10, 1, 1, 10}));
        System.out.println("==================");
    }

    public boolean check(int[] nums) {
        // 枚举分割点
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        for (int i = 0; i < nums.length; i++) {
            if (check(nums, arr, i)) return true;
        }
        return false;

    }

    private boolean check(int[] nums, int[] arr, int i) {
        int n = nums.length;
        int a = i;
        int k = 0;
        while (a < n) {
            if (nums[a] != arr[k]) return false;
            a++;
            k++;
        }
        for (int j = 0; j < i; j++) {
            if (nums[j] != arr[k++]) return false;
        }
        return true;
    }


}
