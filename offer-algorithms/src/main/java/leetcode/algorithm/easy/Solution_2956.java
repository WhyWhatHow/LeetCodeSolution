package leetcode.algorithm.easy;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2956 {

    public static void main(String[] args) {
        Solution_2956 sol = new Solution_2956();
        System.out.println("==================");
    }

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            mp.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
            if (mp.containsKey(nums1[i])) {
                res[0]++;
            }
        }
        for (int i : nums2) {
            if (map.containsKey(i))
                res[1]++;
        }
        return res;
    }
}


