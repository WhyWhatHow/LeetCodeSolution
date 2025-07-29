package leetcode.algorithm.medium;

import java.util.ArrayList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2419 {

    public static void main(String[] args) {
        Solution_2419 sol = new Solution_2419();
        System.out.println(sol.longestSubarray(new int[]{
//                1, 2, 3, 3, 2, 2
                96317, 96317, 96317, 96317, 96317, 96317, 96317, 96317, 96317, 279979
        }));
        System.out.println("==================");
    }

    // 统计最大值的出现次数, &次数越多,数越小.
    public int longestSubarray(int[] nums) {

        ArrayList<int[]> list = new ArrayList<>();
        int cnt = 1;
        // count repeat number.
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) cnt++;
            else {
                list.add(new int[]{nums[i - 1], cnt});
                cnt = 1;
            }
        }
        list.add(new int[]{nums[nums.length - 1], cnt});

        int max = 1;
        int len = 1;
        for (int i = 0; i < list.size(); i++) {
            int r = i + 1;
            int tmp = list.get(i)[0];
            int tlen = list.get(i)[1];
            while (r < list.size() && (tmp & list.get(r)[0]) >= tmp) {
                tmp = tmp & list.get(r)[0];
                tlen += list.get(r)[1];
                r++;
            }
            if (max == tmp) {
                len = Math.max(len, tlen);
            }
            if (max < tmp) {
                max = tmp;
                len = tlen;
            }

        }
        return len;
    }
}


