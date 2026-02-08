package leetcode.algorithm.weekly;

import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2025-12-07 10:29
 **/
public class Weekly_488 {
    public static void main(String[] args) {
        Weekly_488 sol = new Weekly_488();
//        sol.
        System.out.println(sol.countSubarrays(
                new int[]{1, 3, 2},
                0));
        System.out.println("---------------------");
    }

    // cost <= k

    //   cost = (max(nums[l..r]) - min(nums[l..r])) * (r - l + 1)。
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        if (n == 0) return 0;
        int l = 0, r = l;
        var maxmap = new TreeMap<Integer, Integer>();
        var minmap = new TreeMap<Integer, Integer>();
        long res = 0;
        while (l < n && r < n) {

            maxmap.compute(nums[r], (kk, v) -> v == null ? 1 : v + 1);
            minmap.compute(nums[r], (kk, v) -> v == null ? 1 : v + 1);
            while (l <= r) {

                // compute cost
                long cost = 1l * (maxmap.lastKey() - minmap.firstKey()) * (r - l + 1);
                if (cost <= k) break;

                // handle not qualified val
                maxmap = remove(maxmap, nums[l]);
                minmap = remove(minmap, nums[l]);
                l++;
            }
            res += r - l + 1;
            r++;
//            if (r < l) r = l;
        }
        return res;
    }


    private TreeMap remove(TreeMap<Integer, Integer> map, int num) {
        var val = map.compute(num, (kk, v) -> v - 1);
        if (val <= 0) {
            map.remove(num);
        }
        return map;
    }


    public List<Long> mergeAdjacent(int[] nums) {
//        var list = new LinkedList<Long>();
        var s = new Stack<Long>();
        for (int i = 0; i < nums.length; i++) {
            long tar = nums[i];
            while (!s.isEmpty() && s.peek() == tar) {
                s.pop();
                tar += tar;
            }
            s.push(tar);
        }
        return s;
    }

    public int dominantIndices(int[] nums) {
        int n = nums.length;
        int cnt = 1;
        int res = 0;
        long val = nums[n - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (Double.compare(nums[i], val * 1.0d / cnt) > 0) {
                res++;
            }
            val += nums[i];
            cnt++;
        }
        return res;
    }

}
 