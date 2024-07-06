package leetcode.algorithm.dp;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3101 {

    public static void main(String[] args) {
        Solution_3101 sol = new Solution_3101();
        System.out.println(sol.countAlternatingSubarrays(new int[]{
                1,0,1,0
        }));
        System.out.println("==================");

    }

    /**
     * f[i] means [0,i]  i index as end index .
     * nums[i] != nums[i-1], f[i] =f[i-1] + 1 ;
     * nums[i] == nums[i-1] f[i] = 1;
     * @param nums
     * @return
     */
    public long countAlternatingSubarrays(int[] nums) {
        long[] f = new long[nums.length + 1];
        f[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                f[i] = f[i - 1] + 1;
            } else {
                f[i] =  1;
            }
        }
        long res = 0 ;
        for (long l : f) {
            res+=l;
        }
        return res;
    }
}


