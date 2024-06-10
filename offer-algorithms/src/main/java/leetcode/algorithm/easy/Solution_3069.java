package leetcode.algorithm.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_3069 {

    public static void main(String[] args) {
        Solution_3069 sol = new Solution_3069();

        System.out.println("==================");
    }


    public int[] resultArray(int[] nums) {
        List<Integer> list = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        list.add(nums[0]);
        list2.add(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (list.getLast() > list2.getLast()) {
                list.add(nums[i]);
            } else {
                list2.add(nums[i]);
            }
        }
        int[] ans = new int[nums.length];
        int cnt = 0;
        for (Integer i : list) {
            ans[cnt++] = i;
        }
        for (Integer i : list2) {
            ans[cnt++] = i;
        }
        return ans;
    }

}


