package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2874 {

    public static void main(String[] args) {
        Solution_2874 sol = new Solution_2874();
        System.out.println("==================");
    }

    public long maximumTripletValue(int[] nums) {
//         i < j < k 的下标三元组 (i, j, k) , (nums[i] - nums[j]) * nums[k]
        long res = 0;
        int[] lMaxs = new int[nums.length]; // [0,i] 范围最大值
        lMaxs[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            lMaxs[i] = Math.max(lMaxs[i - 1], nums[i]);
        }
        int[] rMaxs = new int[nums.length];     //[i,nums.length) 最大值
        rMaxs[nums.length - 1] = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            rMaxs[i] = Math.max(rMaxs[i + 1], nums[i]);
        }

        for (int i = 1; i < nums.length - 1; i++) {
            res = Math.max((long)(lMaxs[i - 1] - nums[i]) * rMaxs[i + 1],res);
        }
        return res;
    }

}


