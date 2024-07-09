package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_724 {

    public static void main(String[] args) {
        Solution_724 sol = new Solution_724();
        System.out.println(sol.pivotIndex(new int[]{
//                2, 1, -1
                -1, -1, 0, 1, 1, 0
        }));
        ;
        System.out.println("==================");
    }

    /**
     * f[i] means [0,i) sum
     * so f[0] -->[0,0) f[0] = 0
     * f[i] = f[i-1] +nums[i-1]; // [0,i)
     * index i's left sum : f[ i-1 ]
     * index i's right sum : f[n] -f[i]
     *
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int res = -1;
        int[] f = new int[nums.length + 1]; // [0,i-1] sum
        int n = nums.length;
        for (int i = 1; i <= nums.length; i++) {
            f[i] = f[i - 1] + nums[i - 1];
        }
        int lsum = 0, rsum = 0;
        for (int i = 1; i < f.length; i++) {
            lsum = f[i - 1];
            rsum = f[n] - f[i];
            if (lsum == rsum) {
                res = i - 1;
                break;
            }
        }

        return res;
    }

}


