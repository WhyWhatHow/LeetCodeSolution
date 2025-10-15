package leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3350 {

    public static void main(String[] args) {
        Solution_3350 sol = new Solution_3350();

        System.out.println(sol.maxIncreasingSubarrays(List.of(
//                2, 5, 7, 8, 9, 2, 3, 4, 3, 1
                1, 2, 3, 4, 4, 4, 4, 5, 6, 7
        )));
        System.out.println("==================");
    }

    public int maxIncreasingSubarrays(List<Integer> nums) {
        int cnt = 1;
        int max = 0;
        int prev = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                cnt++;
            } else {
                max = Math.max(max, cnt / 2);
                max = Math.max(max, Math.min(prev, cnt));
                prev = cnt;
                cnt = 1;
            }
        }
        max = Math.max(max, cnt / 2);
        max = Math.max(max, Math.min(prev, cnt));
        return max;
    }

    public int maxIncreasingSubarraysSlow(List<Integer> nums) {
        int n = nums.size();
        int[] f = new int[n]; // f[i] means[ f[i], i] range 递增.
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                f[i] = f[i - 1];
            } else {
                f[i] = i;
            }
        }
        int maxK = 0;
        int cnt = 0;
//        int prev = 0;
        var q = new ArrayList<Integer>();
        for (int i = 0; i < f.length; i++) {
            if (i == 0) {
                cnt = 1;
                continue;
            }
            if (f[i] == f[i - 1]) {
                cnt++;
//                maxK= Math.max(cnt/2,)
            } else {
                q.add(cnt);
                cnt = 1;
            }
        }
        q.add(cnt);

        maxK = q.get(0) / 2;
        for (int i = 1; i < q.size(); i++) {
            maxK = Math.max(maxK, Math.min(q.get(i - 1), q.get(i)));
        }
        return maxK;
    }

}


