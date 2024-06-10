package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_2562 {

    public static void main(String[] args) {
        Solution_2562 sol = new Solution_2562();

        System.out.println("==================");
        System.out.println(sol.findTheArrayConcVal(new int[]{
                5, 14, 13, 8, 12
        }));
    }

    public long findTheArrayConcVal(int[] nums) {
        long[] arr = new long[nums.length];
        int cnt = 0;
        int i;
        for (i = 0; i < (nums.length / 2); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(nums[i]).append(nums[nums.length - i - 1]);
            arr[cnt++] = Long.valueOf(sb.toString());

        }
        if (nums.length % 2 != 0) {
            StringBuilder sb = new StringBuilder();
            arr[cnt++] = Long.valueOf(sb.append(nums[i]).toString());
        }
        long res = 0;
        for (i = 0; i < cnt; i++) {
            res += arr[i];
        }
        return res;
    }
}


