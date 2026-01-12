package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1266 {

    public static void main(String[] args) {
        Solution_1266 sol = new Solution_1266();
        System.out.println(sol.minTimeToVisitAllPoints(
                new int[][]{{1, 1}, {3, 4}, {-1, 0}}
        ));
        System.out.println("==================");
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;

        for (int i = 1; i < points.length; i++) {
            int tox = points[i][0], toy = points[i][1];
            int x = points[i - 1][0], y = points[i - 1][1];
            int dx = Math.abs(x - tox);
            int dy = Math.abs(y - toy);
            int min = Math.min(dx, dy);
            int tmp = dx + dy;
            //
            int tt = Math.abs(dx - min) + min + Math.abs(dy - min);
            res += Math.min(tt,tmp);
        }
        return res;
    }
}


