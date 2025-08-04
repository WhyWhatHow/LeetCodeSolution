package leetcode.algorithm.window;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_904 {

    public static void main(String[] args) {
        Solution_904 sol = new Solution_904();
        System.out.println(sol.totalFruit(new int[]{
//                1, 2, 3, 2, 2
//                0, 1, 2
                1, 0, 1, 4, 1, 4, 1, 2, 3
        }));
        System.out.println("==================");
    }

    public int totalFruit(int[] f) {
        int n = f.length;
        HashMap<Integer, Integer> map = new HashMap<>();// {key: type, val: cnt}
        int res = 0;
        int cnt = 0;
        int l = 0, r = 0;
        while (r <= n) {
            if (cnt > 2) {
                res = Math.max(res, r - 1 - l);
                while (l <= r && cnt > 2) {
                    int val = map.compute(f[l], (k, v) -> v - 1);
                    if (val == 0) cnt--;
                    l++;
                }

            }
            if (r == n) break;
            int val = map.compute(f[r], (k, v) -> v == null ? 1 : v + 1);
            if (val == 1) cnt++;
            r++;
        }
        return Math.max(res, r - l);

    }

}


