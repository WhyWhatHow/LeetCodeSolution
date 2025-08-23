package leetcode.algorithm.medium;

import java.util.ArrayList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1493 {

    public static void main(String[] args) {
        Solution_1493 sol = new Solution_1493();
        System.out.println(sol.longestSubarray(new int[]{
//                0, 1, 1, 1, 0, 1, 1, 0, 1
//                1, 1, 0, 0, 1, 1, 1, 0, 1
                1, 0, 0, 0
        }));
        System.out.println("==================");
    }

    public int longestSubarray(int[] nums) {

        ArrayList<int[]> list = new ArrayList<>();// cnt, st,end
        int cnt = 0;
        int st = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cnt++;
            } else {
                if (cnt == 0) {
                    st = i;
                    continue;
                }
                list.add(new int[]{cnt, st, i});
                st = i;
                cnt = 0;
            }
        }
        if (cnt != 0)
            list.add(new int[]{cnt, st, nums.length});

        if (list.size() == 0) return 0;

        int res = 0;
        if (list.getFirst()[2] == nums.length && list.getFirst()[1] == -1) return list.getFirst()[0] - 1;
        else res = Math.max(list.getFirst()[0], list.getLast()[0]);
        for (int i = 1; i < list.size(); i++) {
            int[] prev = list.get(i - 1);
            int[] cur = list.get(i);
            if (prev[2] == cur[1])
                res = Math.max(prev[0] + cur[0], res);
            else
                res = Math.max(res, Math.max(cur[0], prev[0]));

        }
        return res;
    }
}


