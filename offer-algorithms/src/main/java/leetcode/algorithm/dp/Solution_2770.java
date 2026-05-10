package leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_2770 {

    public static void main(String[] args) {
        Solution_2770 sol = new Solution_2770();//
        System.out.println(sol.maximumJumps(
//                new int[]{1, 3, 6, 4, 1, 2},
//                2
////                0
//                new int[]{0, 3, 2, 1},
//                1
                new int[]{758043978, 79060681, 785252849, 287889790, -983845055, 224430896, -477101480},
                1769097904
        ));
        System.out.println("==================");
    }

    //set f(i) means [0,i) as maxJumps.
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] f = new int[n];
        Arrays.fill(f, -1);
        dfs(f, target, nums, n - 1);
        return f[n - 1];
    }


    //set f(i) means [0,i) as maxJumps.
    private int dfs(int[] f, int target, int[] nums,
                    int i) {
        if (i == 0) return f[i] = 0;
        if (f[i] != -1) return f[i];

        long down = 0l + nums[i] - target;
        long up = 0l + nums[i] + target;
        int res = 0;
        int cnt = 0;
        for (int j = 0; j < i; j++) {
            if (nums[j] <= up && nums[j] >= down) {
                int t = dfs(f, target, nums, j);
                if (t != -1) {
                    res = Math.max(res, t + 1);
                    cnt++;
                }
            }
        }

        return f[i] = cnt == 0 ? -1 : res;
    }


}
