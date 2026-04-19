package leetcode.algorithm.medium;

import java.util.TreeMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1855 {

    public static void main(String[] args) {
        Solution_1855 sol = new Solution_1855();//

        System.out.println("==================");
    }

    // 非递增.
//同时满足 i <= j 且 nums1[i] <= nums2[j] ，则称之为 有效 下标对，该下标对的 距离 为
    public int maxDistance(int[] nums1, int[] nums2) {

        var map = new TreeMap<Integer, Integer>(); // key nums2[i], val: lastIdx
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            Integer key = map.ceilingKey(nums1[i]);

            if (key != null && map.get(key) >= i) res = Math.max(res, map.get(key) - i);
        }
        return res;
    }
}
