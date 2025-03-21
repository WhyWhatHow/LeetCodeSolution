package leetcode.algorithm.greedy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2680 {

    public static void main(String[] args) {
        Solution_2680 sol = new Solution_2680();
        System.out.println(sol.maximumOr(new int[]{
//                        8, 1, 2
                        12, 9
                },
//                2
                1
        ));
        System.out.println("==================");
    }

    public long maximumOr(int[] nums, int k) {
        long res = 0;
        int n = nums.length;
        long[] pres = new long[n]; // [0,i)  或和
        long[] sufs = new long[n];//  (i, n) 或和
        pres[0] = 0;
        sufs[n - 1] = 0;
        long ans = 0;
        for (int i = 1; i < nums.length; i++) {
            pres[i] = nums[i - 1] | pres[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            sufs[i] = sufs[i + 1] | nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            long tmp = (long)nums[i] << k;
            tmp = tmp | pres[i] | sufs[i];
            res = Math.max(res,tmp);
        }
        return res;
    }

}


