package leetcode.algorithm.binarysearch;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3453 {

    public static void main(String[] args) {
        Solution_3453 sol = new Solution_3453();
        System.out.println(Long.MAX_VALUE);
        System.out.println(sol.separateSquares(
                new int[][]{{0, 0, 2}, {1, 1, 1}}
        ));

        System.out.println("==================");
    }

    // set S 表示 低于y 的面积,   随着y变大, s 变大.
    // y == 0 ,  s最小 , s具有单调性. 我们要的结果是 2*s = sum(squares.area)
    // 我们要做的就是枚举 y , 但是y的取值[0,10^9], 超时.
    // 所以, 选择二分 y
    public double separateSquares(int[][] squares) {
        Arrays.sort(squares, (a, b) -> a[1] - b[1]); // y 升序
        long sum = 0;

        int n = squares.length;
        long maxy = 0;
        for (int[] a : squares) {
            sum += 1l * a[2] * a[2];
            maxy = Math.max(maxy, a[1] + a[2]);
        }
        double l = squares[0][1], r = maxy;
        double target = 1.0d * sum / 2;
        int time = 60;
        while (time-- > 0) {

            double mid = 1.0d * (l + r) / 2; // y 的取值
            //            System.out.println(mid);
            var val = getSum(mid, squares, target);

            if (val < target) {
                l = mid;
            } else {
                r = mid;
            }

        }
        return r; // 最小值.
    }

    // y的取值.
    private double getSum(double maxy, int[][] squares, double target) {
        double res = 0;
        for (int i = 0; i < squares.length; i++) {
            double y = squares[i][1], l = squares[i][2];
            if ((y + l) < maxy) {
                res += 1d * l * l;
            } else if (y < maxy) {
                double dy = maxy - y;
                res += dy * l;
            } else {
                break;
            }
        }
        return res;
    }

}


