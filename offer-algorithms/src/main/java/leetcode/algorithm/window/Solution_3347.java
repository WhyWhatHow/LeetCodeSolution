package leetcode.algorithm.window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3347 {

    public static void main(String[] args) {
        Solution_3347 sol = new Solution_3347();
        System.out.println(sol.maxFrequency(new int[]{
//                1, 4, 5
                        88, 53
                },
//                1, 2
                27, 2
        ));
        System.out.println("==================");
    }

    // 枚举一个可以取得的值, 滑动整个窗口,找到符合题意的最大值.
    // 思考这个可以取得的值取值范围是多少呢? [min-k, max+k] 如果我们对于每一个数据都进行枚举, 数据要求10^9 会超时, 所以取巧每一个区间,取三个值, 分别是{x-k,x,x+k},
    // 枚举每一个可能取得到的值,使用滑窗更新 每一个x 对应的符合题意的数据. 解题即可.
    // [l,r) means
    // nums[l]是大于等于 x-k的第一个数.
    // nums[r] 是 大于x+k 的第一个数.
    //因而 [l,r) 就是所有满足题意可以选择的数据, 因为我们只能操作numsOptions 次, 所以最终,对于x ,我们的可以得到的结果是 min(r-l-cnt,op) + cnt ;
    // 补充, cnt 是 nums[i]==x 的数字数量.
    // 所以, 我们的最大值是 res = max(res, min(r-l-cnt, numOperations)+cnt) ;
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        var map = new HashMap<Integer, Integer>();
        // count nums op time.
        for (int i : nums) {
            map.compute(i, (kk, v) -> v == null ? 1 : v + 1);
        }
        var set = new TreeSet<Integer>();
        for (int num : nums) {
            set.add(num - k);
            set.add(num);
            set.add(num + k);
        }

        int n = nums.length;
        int l = 0, r = 0;
        int res = 0;

        for (Integer x : set) {

            // l limit  ==>  `nums[l]>=x`
            while (l < n && nums[l] < x - k) {
                l++;
            }

            // r limit
            while (r < n && nums[r] <= x + k) {
                r++;
            }


            // [l, r) ==>r-l
            int cnt = map.getOrDefault(x, 0);
            res = Math.max(res, Math.min(numOperations, r - l - cnt) + cnt);
        }

        return res;

    }
}


