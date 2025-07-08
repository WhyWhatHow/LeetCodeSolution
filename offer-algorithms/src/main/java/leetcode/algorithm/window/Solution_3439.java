package leetcode.algorithm.window;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3439 {

    public static void main(String[] args) {
        Solution_3439 sol = new Solution_3439();
        System.out.println(sol.maxFreeTime(
                10, 1,
                new int[]{
                        0, 2, 9
                }, new int[]{
                        1, 4, 10
                }));
        System.out.println("==================");
    }

    /**
     * 统计所有的空闲时间,  假设我们有n个会议要开, 那么我们就会有n+1个空闲时间, 空闲时间取值可以为0.
     * 题目要求我们最多可以移动k个会议, 是不是可以转化为求 长度为k+1 的slide_window 的最大值.
     *
     * @param eventTime
     * @param k
     * @param startTime
     * @param endTime
     * @return
     */
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] freeTime = new int[n + 1];

        // init freeTime //
        freeTime[0] = startTime[0];
        for (int i = 1; i < n; i++) {
            freeTime[i] = startTime[i] - endTime[i - 1];
        }
        freeTime[n] = eventTime - endTime[n - 1];

        // k+1 , freeTime MAX value;
        int max = 0;
        int l = 0;
        int r = l;
        int ans = freeTime[0];

        while (r + 1 < freeTime.length) {
            if ((r - l + 1) == k + 1) {

                max = Math.max(ans, max);
                ans -= freeTime[l++];
            } else {
                r++;
                ans += freeTime[r];
            }
        }
        return max = Math.max(max, ans );
    }

}


