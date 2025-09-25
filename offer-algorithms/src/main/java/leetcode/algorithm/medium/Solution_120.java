package leetcode.algorithm.medium;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_120 {

    public static void main(String[] args) {
        Solution_120 sol = new Solution_120();
//        System.out.println(sol.minimumTotalByPQ(List.of(

        System.out.println(sol.minimumTotal(List.of(
                //                List.of(-10)
                ////////////////////////
//                List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3)
                List.of(-1), List.of(2, 3), List.of(1, -1, -3)
        )));
        System.out.println("==================");
    }

    //f[i][j] means (0,0)->(i,j) range minVal
    // f[i][j]  = min(f[i-1][j], f[i-1][j-1])+g[i][j];
    public int minimumTotal(List<List<Integer>> lists) {
        int n = lists.size();
        int[][] f = new int[n][n];
        for (int i = 0; i < f.length; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE);
        }
        f[0][0] = lists.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                f[i][j] = Math.min(f[i - 1][j], j == 0 ? Integer.MAX_VALUE : f[i - 1][j - 1]) + lists.get(i).get(j);
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i : f[n - 1]) {
            res = Math.min(i, res);
        }
        return res;
    }


    int[] dir = new int[]{0, 1};

    // 超时,需要剪枝,
    public int minimumTotalByPQ(List<List<Integer>> triangle) {
        int n = triangle.size();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);// int[]: {x,y,countVal}
        pq.add(new int[]{0, 0, triangle.get(0).get(0)});
        int[][] m = new int[n][n];
        for (int i = 0; i < m.length; i++) {
            Arrays.fill(m[i], Integer.MAX_VALUE);
        }
        int res = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            int[] a = pq.poll();
            int x = a[0], y = a[1], val = a[2];
            if (x == n - 1) res = Math.min(res, val);
            if (m[x][y] < val) continue; // 跳过不必要的节点.

            m[x][y] = val;

            int xx = 1 + x;

            for (int i = 0; i < dir.length; i++) {
                int yy = dir[i] + y;
                if (xx >= n || yy >= triangle.get(xx).size()) continue;  //
                int sum = val + triangle.get(xx).get(yy);
                if (m[xx][yy] > sum) {
                    m[xx][yy] = sum;
                    pq.add(new int[]{xx, yy, sum});
                }
            }
        }
        return res;
    }
}


