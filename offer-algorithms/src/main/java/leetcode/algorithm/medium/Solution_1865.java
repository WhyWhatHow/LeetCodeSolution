package leetcode.algorithm.medium;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1865 {

    public static void main(String[] args) {
        Solution_1865 sol = new Solution_1865();

        System.out.println("==================");
    }


}


class FindSumPairs {
    HashMap<Integer, Integer> map = new HashMap<>();// k: num, v:cnt
    int[] nums;
    int[] a;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.a = nums1;
        Arrays.sort(a);
        for (int i : nums2) {
            map.compute(i, (k, v) -> v == null ? 1 : v + 1);
        }
        this.nums = nums2;
    }

    public void add(int index, int val) {
        map.compute(nums[index], (k, v) -> v > 0 ? v - 1 : 0);
        nums[index] += val;
        map.compute(nums[index], (k, v) -> v == null ? 1 : v + 1);
    }

    public int count(int tot) {
        int cnt = 0;
        for (int i : a) {
            if (i > tot) break;
            cnt += map.getOrDefault(tot - i, 0);
        }
        return cnt;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */