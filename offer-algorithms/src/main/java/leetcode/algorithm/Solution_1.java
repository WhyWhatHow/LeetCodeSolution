package leetcode.algorithm;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-08-26 03:21
 **/
public class Solution_1 {
    //    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
//    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();


        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = target - nums[i];
            int first = map.get(temp);
            if (map.containsKey(temp) && first != i) {
                Integer integer = map.get(temp);
                res[0] = i;
                res[1] = integer;
                break;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Solution_1 sol = new Solution_1();
        int[] ints = sol.twoSum(new int[]{3, 2, 4}, 6);
    }
}
