package leetcode.algorithm.greedy;

import java.util.TreeMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3397 {

    public static void main(String[] args) {
        Solution_3397 sol = new Solution_3397();
        System.out.println(sol.maxDistinctElements(new int[]{
                1, 1, 1, 2, 2, 2, 4, 4, 4, 4
        }, 2));
        System.out.println("==================");
    }

    // 尽可能 像 左侧放数字.
    public int maxDistinctElements(int[] nums, int k) {
//        Arrays.sort(nums);

        TreeMap<Integer, Integer> map = new TreeMap<>(); // key: num , val :  cnt
        for (int num : nums) {
            map.compute(num, (kk, v) -> v == null ? 1 : v + 1);
        }

//        int prev = 0;
        // like a queue.
        int l, r = -k; // means right board limitation .
        int res = 0;
        int len = 2 * k + 1;
        for (Integer key : map.keySet()) {
            int cnt = map.get(key);
            if (len >= cnt) {
                l = Math.max(r + 1, key - k);
                r = Math.min(l + cnt - 1, key + k);
            } else { // k < cnt
                l = Math.max(r + 1, key - k);
                r = Math.min(l + len, key + k);
            }
            res += r - l + 1;
        }
        return res;

    }

}


