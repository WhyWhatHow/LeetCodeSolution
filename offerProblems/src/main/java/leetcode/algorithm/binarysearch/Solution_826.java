package leetcode.algorithm.binarysearch;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_826 {

    public static void main(String[] args) {
        Solution_826 sol = new Solution_826();
        System.out.println(sol.maxProfitAssignment(new int[]{
                2, 4, 6, 8, 10
//                87, 47, 57
        }, new int[]{
                10, 20, 30, 40, 50
//                24, 66, 99
        }, new int[]{
                4, 5, 6, 7
//                40, 25, 24
        }));
        System.out.println("==================");
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int step = 0;
        int[][] g = new int[difficulty.length][2];
        for (int i = 0; i < difficulty.length; i++) {
            g[i][0] = difficulty[i];
            g[i][1] = profit[i];
        }
        // diff[i] ==> maxProfit
        int[] maxProfit = new int[profit.length];
        maxProfit[0] = g[0][1];
        for (int i = 1; i < g.length; i++) {
            maxProfit[i] = Math.max(maxProfit[i - 1], g[i][1]);
        }
        Arrays.sort(g, (a, b) -> a[0] - b[0]);

        int ans = 0;
        for (int w : worker) {
            int loc = search(w, g);
            if (loc < 0) {
                continue;
            }
            ans += maxProfit[loc];
        }
        return ans;
    }

    // [)

    /**
     * 二分查找,返回 <= val 的下标, 每一次去掉一个中点
     * use res to record idx.
     */
    int search(int val, int[][] g) { // [0,n)
        if (val < g[0][0]) return -1;
        int left = 0, right = g.length - 1; //[0,n-1]
        int mid;
        int res = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (g[mid][0] <= val) { // [mid+1, n-1]
                res = mid;
                left = mid + 1;
            } else { // [0, mid-1]
                right = mid - 1;
            }
        }
        return res; //
    }


}


