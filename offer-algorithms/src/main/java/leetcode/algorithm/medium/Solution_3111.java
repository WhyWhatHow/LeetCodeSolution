package leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3111 {

    public static void main(String[] args) {
        Solution_3111 sol = new Solution_3111();
        System.out.println("==================");
    }

    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int ans = 0;
        int cur = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[cur][0] + w >= points[i][0]) continue;
            ans++;
            cur = i ;
        }
        return ans;
    }

}


