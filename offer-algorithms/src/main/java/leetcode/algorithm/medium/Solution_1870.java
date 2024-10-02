package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1870 {

    public static void main(String[] args) {
        double res = 2.01 - 2;
        res = Math.round(res * 100.0) / 100.0;

        System.out.println(res);
        Solution_1870 sol = new Solution_1870();
        System.out.println(sol.minSpeedOnTime(new int[]{
                        1, 1, 100000
                },
                2.01
        ));
        System.out.println("==================");
    }

    /**
     * 去浮点:x100
     *
     * @param dist
     * @param hour
     * @return
     */
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        if (hour < n - 1) return -1;

        int left = 1, right = 10_000_001;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (check(dist, hour, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    /**
     * check v is qualified or not.
     *
     * @param dist
     * @param hour
     * @param v    speed per hour
     * @return
     */
    private boolean check(int[] dist, double hour, int v) {
        double cnt = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            cnt += Math.ceil((double) dist[i] / v);
        }
        cnt += (double) dist[dist.length - 1] / v;
        return cnt <= hour;
    }
}


