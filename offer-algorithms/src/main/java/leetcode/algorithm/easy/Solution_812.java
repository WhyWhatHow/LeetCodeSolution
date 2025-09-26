package leetcode.algorithm.easy;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_812 {

    public static void main(String[] args) {
        Solution_812 sol = new Solution_812();
        System.out.println("==================");
    }

    public double largestTriangleArea(int[][] points) {
        double res = 0;
        // 移动所有的点, 保证没有负数.
        for (int i = 0; i < points.length; i++) {
            points[i][0] += 50;
            points[i][1] += 50;
        }
        // 按照x asc ,y asc
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
        });
        // 枚举每一个三角形
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
//                    if(check(points,i,j,k)){
                    res = Math.max(calArea(points, i, j, k), res);
//                    }
                }
            }
        }
        return res ;
    }


    // s = 0.5d *(向量ac * 向量ab)
// ac = (cx-ax, cy-ay) , ab= (bx-ax, by-ay)
// s = 0.5d * (Xac * Xab - Yac*Yab)
    private double calArea(int[][] points, int a, int b, int c) {
        int xac = points[c][0] - points[a][0];
        int yac = points[c][1] - points[a][1];
        int xab = points[b][0] - points[a][0];
        int yab = points[b][1] - points[a][1];
        return Math.abs(0.5d * (xac * yab - yac * xab));
    }

}


