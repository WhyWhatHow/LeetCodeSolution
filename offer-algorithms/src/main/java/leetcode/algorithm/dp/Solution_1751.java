package leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1751 {

    public static void main(String[] args) {
        Solution_1751 sol = new Solution_1751();

        System.out.println("==================");
    }

    int[][] f;

    /**
     * 设 f[i][j] 表示[0,i) events 中, 选择了j个事件的最大值.==> f[i][j] 是递增的. 所以可以用二份查找.
     * 选择第i个会议: f[i][j] = f[p][j-1] + events[i];  // 其中p 为[0,i-1) 范围内满足 events[p][1] < events[i][0] 的最大范围, 也就是[0,p] range 内的最大值.
     * 不选第i个会议: f[i][j] = f[i-1][j]
     *
     * @param events
     * @param k
     * @return
     */
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]); // 必须按照结束时间排序,(根据我们设定f[i] 为[0,i) 最大值, 如果按照开始时间排序,我们没有办法把查找[0,i) 降低. .
        int n = events.length;
        f = new int[n + 1][k + 1];

        for (int j = 1; j <= k; j++) {
            for (int i = 0; i < n; i++) {
                // chosen events[i]  [0,i)
                int idx = find(events, i);
                f[i + 1][j] = Math.max(f[i][j], f[idx + 1][j - 1] + events[i][2]);
            }
        }

//        f[n][k] = dfs(n, k, f, events);

        return f[n][k];
    }

    // 返回<=events[i][0] 时间下标的最大下标.
    private int find(int[][] events, int i) {
        int l = 0;
        int r = i - 1;
        int res = -1;
        int target = events[i][0];
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (events[mid][1] < target) {
                l = mid + 1;
                res = mid;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

//    // f[i][j] means [0,i) range j attended meetings max_value;
//    private int dfs(int i, int j, int[][] f, int[][] events) {
//        if (j == 1) {
//
//        }
//        if (f[i][j] != -1) return f[i][j];
//        int res = 0;
//
//        return f[i][j] = res;
//    }

}


