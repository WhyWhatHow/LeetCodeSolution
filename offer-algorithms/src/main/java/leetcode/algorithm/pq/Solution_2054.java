package leetcode.algorithm.pq;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2054 {

    public static void main(String[] args) {
        Solution_2054 sol = new Solution_2054();
        System.out.println("==================");
    }

    /**
     * 1. 按照st时间升序.
     * 2. 枚举每一个event 作为第一个事件, 然后找到符合这个事件的后序事件.
     * 3. 定义 ss[i] 表示从[i,n) range 中,val的最大值.
     * @param events
     * @return
     */
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> { // st asc ,val desc
            if (a[0] != b[0])
                return a[0] - b[0];
            else return b[2] - a[2];
        });

        /// 初始化后缀最大值.
        int n = events.length;
        int[] ss = new int[events.length]; // ss[i] means [i, n) range maxVal ;
        ss[n - 1] = events[n - 1][2];
        for (int i = events.length - 1; i > 0; i--) {
            ss[i - 1] = Math.max(events[i - 1][2], ss[i]);
        }

        // 枚举 event 作为第一个event
        int max = 0;
        for (int i = 0; i < events.length; i++) {
            int end = events[i][1];
            int val = events[i][2];
            int idx = findQualifiedRange(i + 1, events, end);
            if (idx != -1) {
                max = Math.max(max, val + ss[idx]);
            } else {
                max = Math.max(val, max);
            }
        }
        return max;

    }


    //[st,e.len) 找到 startTime> endTime 第一个下标;
    private int findQualifiedRange(int st, int[][] events, int tar) {
        int l = st;
        int r = events.length - 1;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (events[mid][0] > tar) {
                r = mid - 1;
                res = mid;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

}


