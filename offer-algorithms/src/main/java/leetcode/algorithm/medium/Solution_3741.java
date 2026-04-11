package leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3741 {

    public static void main(String[] args) {

        System.out.println("==================");
    }

    public int minimumDistance(int[] nums) {

        var map = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], j -> new ArrayList<Integer>()).add(i);
        }
        boolean yes = false;
        int res = Integer.MAX_VALUE;
        for (ArrayList<Integer> list : map.values()) {
            if (list.size() < 3) continue;
            res = Math.min(res, getMinDistance(list));
            yes = true;
        }
        if (!yes) return -1;
        return res;
    }

    // list 中选三个点, 之间的差值最小.  a,b,c  b-a, c-b, c-a,
    private int getMinDistance(ArrayList<Integer> list) {
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < list.size() - 1; i++) {
            int tmp = 2 * (list.get(i + 1) - list.get(i - 1));
            res = Math.min(res, tmp);
        }
        return res;
    }

}
