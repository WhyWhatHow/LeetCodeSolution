package leetcode.algorithm.easy;

import java.util.LinkedList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_2553 {

    public static void main(String[] args) {
        Solution_2553 sol = new Solution_2553();//
        System.out.println("==================");
    }

    public int[] separateDigits(int[] nums) {
        var list = new LinkedList<Integer>();
        for (int num : nums) {
            var tmpList = new LinkedList<Integer>();
            while (num > 0) {
                tmpList.addFirst(num % 10);
                num /= 10;
            }
            list.addAll(tmpList);
        }
        int[] a = new int[list.size()];
        int cnt = 0;
        for (Integer i : list) {
            a[cnt++] = i;
        }
        return a;
    }

}
