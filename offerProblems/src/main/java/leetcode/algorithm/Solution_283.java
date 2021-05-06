package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_283 {
    public void moveZeroes(int[] nums) {
        int[] arr = new int[nums.length];
        int cnt = 0;
        for (int num : nums) {
            if (num != 0) {
                arr[cnt++] = num;
            }
        }
        for (int i = cnt; i < nums.length; i++) {
            arr[i] = 0;
        }
        int step = 0;
        for (int i : arr) {
            nums[step++] = i;
        }
//        System.out.println();
//        nums = arr;
    }

    public static void main(String[] args) {
        Solution_283 sol = new Solution_283();
        sol.moveZeroes(new int[]{
                0, 1, 0, 3, 12
        });
        System.out.println("==================");
    }
}


