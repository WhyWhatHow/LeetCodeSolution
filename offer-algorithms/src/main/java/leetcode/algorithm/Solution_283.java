package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description: #array #Two pointers
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
        sol.moveZeroes2(new int[]{
                0, 1, 0, 3, 12
        });
        System.out.println("==================");
    }

    public void moveZeroes2(int[] nums) {
        int i = 0, j = 0;
        while (i < nums.length && j < nums.length) {
            if (nums[i] == 0) {
                i++;
            } else {
                nums[j++] = nums[i++];
            }
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }
        System.out.println(nums);
    }
}


