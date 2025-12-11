package leetcode.algorithm.medium;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3531 {

    public static void main(String[] args) {
        Solution_3531 sol = new Solution_3531();
        System.out.println("==================");
    }

    // 需要统计 对于x[i] 对应的max and min 即可.
    public int countCoveredBuildings(int n, int[][] buildings) {
        // init
        int[][] xs = new int[n + 1][2]; // xmax, xmin,
        int[][] ys = new int[n + 1][2]; // ymax ,ymin
        for (int i = 0; i < xs.length; i++) {
            xs[i][0] = 0; //max
            xs[i][1] = n + 1; // min
            ys[i][0] = 0;// max
            ys[i][1] = n + 1;// min
        }

        for (int[] a : buildings) {
            int x = a[0], y = a[1];
            xs[x][0] = Math.max(xs[x][0], y);
            xs[x][1] = Math.min(xs[x][1], y);
            ys[y][0] = Math.max(ys[y][0], x);
            ys[y][1] = Math.min(ys[y][1], x);
        }

        // calculate
        int res = 0;
        for (int[] a : buildings) {
            int x = a[0], y = a[1];
            if (xs[x][0] > y && xs[x][1] < y && ys[y][0] > x && ys[y][1] < x) {
                res++;
            }
        }
        return res;
    }

    public int countCoveredBuildingsBYTreeSet(int n, int[][] buildings) {

        // init
        TreeSet<Integer>[] xset = new TreeSet[n + 1];
        TreeSet<Integer>[] yset = new TreeSet[n + 1];


        Arrays.setAll(xset, i -> new TreeSet<Integer>());
        Arrays.setAll(yset, i -> new TreeSet<Integer>());

        for (int[] a : buildings) {
            int x = a[0], y = a[1];
            xset[x].add(y);
            yset[y].add(x);
        }

        int res = 0;
        // calculate
        for (int[] a : buildings) {
            int x = a[0], y = a[1];
            boolean yes = true;
            //top
            yes = yes && xset[x].getLast() > y;
            // down
            yes = yes && xset[x].getFirst() < y;
            // left && right
            yes = yes && yset[y].getFirst() < x && yset[y].getLast() > x;
            res += yes ? 1 : 0;
        }
        return res;
    }

}


