package leetcode.algorithm.prefix;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_525 {

    public static void main(String[] args) {
        Solution_525 sol = new Solution_525();//
        System.out.println(sol.findMaxLength(
                new int[]{0, 1}
        ));
        System.out.println("==================");
    }

    // 01, 相同数量, 返回长度.
    // f[i] means[0,i) range 0 的数量.
    // g[i] means[0,i) range 1 的数量.
    // 对于区间[l,r] 来说 如果是最长子数组的话, 会有
    // f[r+1] - f[l]  = g[r+1]-g[l]
    // ==> f[r+1]-g[r+1] = f[l] -g[l],
    // make F[i] = f[i] - g[i], 当对于不同的idx 而言, 有相同的值的时候,表示可以构成满足题意的解.
    // 用一个map 保存之前已经访问过的值的第一次出现下标, 那么结果就是max( i- map.get(F[i]))
    public int findMaxLength(int[] nums) {
        int[] f = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            f[i + 1] = f[i] + (nums[i] == 0 ? 1 : -1);
        }
        var map = new HashMap<Integer, Integer>();//key: f[i] ,val : FirstIndex
        map.put(0, 0);
        int res = 0;
        for (int i = 1; i < f.length; i++) {
            if (map.containsKey(f[i])) {
                res = Math.max(res, i - map.get(f[i]));
            } else {
                map.put(f[i], i);
            }
        }
        return res;
    }
}
