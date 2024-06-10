package leetcode.algorithm;

import java.util.Scanner;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-27 09:03
 **/
public class Main2 {
    public static int min = Integer.MAX_VALUE;
    public boolean vis[] = new boolean[10089];

    boolean check(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                return true;
        }
        return false;
    }

    public void dfs(int[] nums, int count) {
        if (count > min) {
            return;
        }
        if (check(nums)) {
            int i = 0;
            while (nums[i] == 0) i++;
            if (nums[i] > 0) {
                nums[i]--;
                dfs(nums, count + 1);
                nums[i]++;
            }
            if (nums[i] > 1) {
                nums[i] -= 2;
                dfs(nums, count + 1);
                nums[i] += 2;
            }
            if (i + 5 <=nums.length &&
                    nums[i] > 0 &&
                    nums[i + 1] > 0 &&
                    nums[i + 2] > 0 &&
                    nums[i + 3] > 0 &&
                    nums[i + 4] > 0
            ) {
                for (int j = 0; j < 5; j++) {
                    nums[i + j]--;
                }
                dfs(nums, count + 1);
                for (int j = 0; j < 5; j++) {
                    nums[i + j]++;
                }
            }
            if (i + 3 <= nums.length && nums[i] > 1 && nums[i + 1] > 1 && nums[i + 2] > 1) {
                for (int j = 0; j < 3; j++) {
                    nums[i + j] -= 2;
                }
                dfs(nums, count + 1);
                for (int j = 0; j < 3; j++) {
                    nums[i + j] += 2;
                }
            }
        } else {
            if (count < min) {
                min = count;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 2, 2, 2, 1, 1};
        Main2 sol = new Main2();
        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//
//        }

        sol.dfs(nums, 0);
        System.out.println(min);
    }
}


