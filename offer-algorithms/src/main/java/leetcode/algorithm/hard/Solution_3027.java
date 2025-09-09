package leetcode.algorithm.hard;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3027 {

    public static void main(String[] args) {
        Solution_3027 sol = new Solution_3027();
        System.out.println(sol.numberOfPairs(new int[][]{
//                {1, 1}, {2, 2}, {3, 3}
                {6, 2}, {4, 4}, {2, 6}
        }));
        System.out.println("==================");
    }

    // 优化思路: 我已经维护了AB两点, 以保证ax<=bx,
    // 根据题目要求: by <=ay, 所以对于 by>ay的点跳过即可.
    // 那么其他点呢? 当前的做法是对于⬜(i,j) 遍历其中的点, 判断是否是否有不符合题意的点.
    // 要如何解决呢?  假设k为(i,j) 之间的点, 已知  ix<=kx<=jx &&  iy>=jy,
    // 如果j 要作为B点, 要求很简单, (i,j) range maxY<jY (原因, 大于 iY的点已经被去掉了)
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return b[1] - a[1];
        });
        int res = 0;
        for (int i = 0; i < points.length; i++) {
//            int minHeight = 0 ;
            int maxHeight = Integer.MIN_VALUE;
            for (int j = i + 1; j < points.length; j++) {
                // check Ay>= By , if not remove it.
                if (points[i][1] < points[j][1]) continue;
                if (maxHeight < points[j][1]) {
                    maxHeight = points[j][1];
                    res++;
                }

            }
        }
        return res;
    }

    private boolean check(int[][] points, int a, int b) {

        for (int i = a + 1; i < b; i++) {
            int x = points[i][0];
            int y = points[i][1];
            if (x >= points[a][0] && x <= points[b][0] && y <= points[a][1] && y >= points[b][1]) return false;
        }
        return true;
    }
}


