package leetcode.algorithm.dp;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3202 {

    public static void main(String[] args) {
        Solution_3202 sol = new Solution_3202();
        System.out.println(sol.maximumLength(new int[]{
                1, 4, 2, 3, 1, 4
        },
                3
        ));

        System.out.println("==================");
    }


    /**
     * set f[i][m] means [0,i] ranges, (sub[0]+sub[1])%k = m , max_length ;
     * for j in [0,i) , m = (nums[i]+nums[j]) % k
     * f[i][m] = f[j][m]+1 ;
     * @param nums
     * @param k
     * @return
     */
    public int maximumLength(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % k;
        }
        int[][]f = new int[nums.length][k];
        int res = 0 ;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int m = (nums[i]+nums[j])%k;
                f[i][m] = f[j][m]+1;
                res = Math.max(f[i][m],res);
            }
        }
        // don't forget nums[0] as start.
        return res+1;
    }
}


