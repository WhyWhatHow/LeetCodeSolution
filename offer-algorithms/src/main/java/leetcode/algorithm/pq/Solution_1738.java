package leetcode.algorithm.pq;

import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_1738 {

    public static void main(String[] args) {
        Solution_1738 sol = new Solution_1738();
        System.out.println(sol.kthLargestValue(new int[][]{
                {5, 2}, {1, 6}
        }, 4));
        System.out.println("==================");
    }

    /**
     * 1.难点在于 如何获取坐标(a,b) 的累积异或值. 我的处理方案是
     *  handle row : map[a][b] = map[a][b-1]^ matrix[a][b]
     *  handle col : map[a][b] = map[a][b] ^ map[a-1][b]
     *  2. 取 第 k 大的值
     *   pq 解决
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthLargestValue(int[][] matrix, int k) {
        int res = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] map = new int[n][m];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        map[0][0] = matrix[0][0];
        // row handle
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    map[i][j] = matrix[i][j];
                } else {
                    map[i][j] = map[i][j - 1] ^ matrix[i][j];
                }
            }
        }
        // col handle
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                map[i][j] = map[i - 1][j] ^ map[i][j];
            }
        }

        // add to pq
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pq.add(map[i][j]);
            }

        }


        while (k-- > 0 && !pq.isEmpty()) {
            res = pq.poll();
        }

        return res;
    }

}


