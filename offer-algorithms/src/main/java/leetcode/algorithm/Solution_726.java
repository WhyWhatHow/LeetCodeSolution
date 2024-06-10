package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_726 {

    public int pivotIndex(int[] nums) {
        if (nums.length==0) {
            return -1 ;
        }
        int[] pre = new int[nums.length];
        int index = -1;
        pre[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
        int k = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (pre[i] == (pre[k] - pre[i] + nums[i])) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        int[] nums = new int[]{28, 54, 7, -70, 22, 65, -6};
        int[] nums = new int[]{1, 1, 1};
        int k = 2;

//        System.out.println( sol.isValid("()"));
    }
}


