package leetcode.algorithm;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/
public class Solution_560 {
    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = k;
            for (int j = i; j < nums.length; j++) {
                temp -= nums[j];
                if (temp == 0) {
                    cnt++;
                    break;
                }
            }


        }
        return cnt;
    }

    public int subarraySum2(int[] nums, int k) {
        int cnt = 0;
        int pre[] = new int[nums.length];
        pre[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (pre[i] == k) cnt++;
            for (int j = i + 1; j < nums.length; j++) {
                if (pre[j] - pre[i] == k) {
                    cnt++;
                }
            }
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
            map.put(pre, map.getOrDefault(pre, 0)+1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution_560 sol = new Solution_560();
//        int[] nums = new int[]{28, 54, 7, -70, 22, 65, -6};
        int[] nums = new int[]{1,1,1};
        int k = 2;
        int i = sol.subarraySum(nums, k);
        int i1 = sol.subarraySum2(nums, k);
        int i2 = sol.sum3(nums, k);
//        System.out.println( sol.isValid("()"));
    }
}
