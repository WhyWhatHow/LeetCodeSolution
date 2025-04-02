package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2873 {

    public static void main(String[] args) {
        Solution_2873 sol = new Solution_2873();
        System.out.println("==================");
    }

    public long maximumTripletValue(int[] nums) {
//         i < j < k 的下标三元组 (i, j, k) , (nums[i] - nums[j]) * nums[k]
        long res = 0;
        int[] mxs = new int[nums.length]; // [i,nums.length) 最大值
        mxs[nums.length - 1] = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            mxs[i] = Math.max(mxs[i + 1], nums[i]);
        }


        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length-1; j++) {
                if (nums[i] < nums[j]) continue;
                res = Math.max(res, (long) (nums[i] - nums[j]) * mxs[j+1]);
            }
        }
        return res;
    }

}


