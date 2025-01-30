package leetcode.algorithm.easy;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_350 {

    public static void main(String[] args) {
        Solution_350 sol = new Solution_350();
        System.out.println(sol.intersect(new int[]{1, 1}, new int[]{1, 2, 3}));
        System.out.println("==================");
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int m = nums2.length;
        if (n <= m) {
            return doIntersect(nums1, nums2);
        } else return doIntersect(nums2, nums1);
    }

    private int[] doIntersect(int[] nums1, int[] nums2) {
        LinkedList<Integer> list = new LinkedList<>();
        int cur = 0;
        for (int i : nums1) {
            for (int j = cur; j < nums2.length; j++) {
                if (nums2[j] < i) continue;
                else if (nums2[j] == i) {
                    list.add(i);
                    cur = j + 1;
                    break;
                } else break;
            }

        }
        int[] a = new int[list.size()];
        int cnt = 0;
        for (Integer i : list) {
            a[cnt++] = i;
        }
        return a;
    }

}
