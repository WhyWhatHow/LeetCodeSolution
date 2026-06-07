package leetcode.algorithm.medium;

import java.util.ArrayList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_2161 {

    public static void main(String[] args) {


        Solution_2161 sol = new Solution_2161();//
        System.out.println("==================");
    }

    public int[] pivotArray(int[] nums, int pivot) {
        var q = new ArrayList<Integer>();
        var gq = new ArrayList<Integer>();
        int cnt = 0;
        for (int num : nums) {
            if (num < pivot) {
                q.addLast(num);
            } else if (num > pivot) gq.addLast(num);
            else cnt++;
        }
        int k = 0;
        int[] rs = new int[nums.length];
        for (Integer i : q) {
            rs[k++] = i;
        }
        while (cnt-- > 0) rs[k++] = pivot;
        for (Integer i : gq) {
            rs[k++] = i;
        }
        return rs;
    }


}
