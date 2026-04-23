package leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_2615 {

    public static void main(String[] args) {
        Solution_2615 sol = new Solution_2615();//
        System.out.println(sol.distance(
//                new int[]{1, 3, 1, 1, 2}
                new int[]{1,1,1,1,1}
        ));
        System.out.println("==================");
    }

    public long[] distance(int[] nums) {
        long[] rs = new long[nums.length];
        var map = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], j -> new ArrayList<>()).add(i);
        }

        for (ArrayList<Integer> list : map.values()) {
            if (list.size() == 1) continue;

            long[] pres = new long[list.size() + 1];
            long[] sufs = new long[list.size() + 1];
            // init
            for (int i = 0; i < list.size(); i++) {
                pres[i + 1] = pres[i] + list.get(i);
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                sufs[i] = sufs[i + 1] + list.get(i);
            }
            // fill others
            for (int i = 0; i < list.size(); i++) {
                int cur = list.get(i);
                int time = list.size() - 1 - i;
                long tmp = sufs[i+1] - (long) time * cur + (long) i * cur - pres[i];
                rs[cur] = tmp;
            }
        }
        return rs;
    }


}
