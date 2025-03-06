package leetcode.algorithm.prefix;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/
public class Solution_560 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // key :sum(nums[0,i]) , value : cont
        int sum = 0;
        int cnt = 0;
        map.put(sum, 1); // s[0]
        for (int num : nums) {
            sum += num;
            int tmp = sum - k;
            cnt += map.getOrDefault(tmp, 0);
            map.compute(sum, (key, v) -> v == null ? 1 : v + 1);

        }
        return cnt;
    }


    public int sum3(int[] nums, int k) {
        int cnt = 0;
        int pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        // pre -k = 0
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                cnt += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution_560 sol = new Solution_560();
//        int[] nums = new int[]{28, 54, 7, -70, 22, 65, -6};
        int[] nums = new int[]{1, 1, 1};
        int k = 2;
        System.out.println(sol.subarraySum(new int[]{
                1, 1, 1
        }, 2));
//        System.out.println( sol.isValid("()"));
    }
}
