package leetcode.algorithm.matrix;

import java.util.ArrayList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1914 {

    public static void main(String[] args) {
        Solution_1914 sol = new Solution_1914();//
        System.out.println(sol.rotateGrid(
//                new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}},
//                2
                new int[][]{{3970,1906,3608,298,3072,3546,1502,773,4388,3115,747,3937},{2822,304,4179,1780,1709,1058,3645,681,2910,2513,4357,1038},{4471,2443,218,550,2766,4780,1997,1672,4095,161,4645,3838},{2035,2350,3653,4127,3208,4717,4347,3452,1601,3725,3060,2270},{188,2278,81,3454,3204,1897,2862,4381,3704,2587,743,3832},{996,4499,66,2742,1761,1189,608,509,2344,3271,3076,108},{3274,2042,2157,3226,2938,3766,2610,4510,219,1276,3712,4143},{744,234,2159,4478,4161,4549,4214,4272,701,4376,3110,4896},{4431,1011,757,2690,83,3546,946,1122,2216,3944,2715,2842},{898,4087,703,4153,3297,2968,3268,4717,1922,2527,3139,1516},{1086,1090,302,1273,2292,234,3268,2284,4203,3838,2227,3651},{2055,4406,2278,3351,3217,2506,4525,233,3829,63,4470,3170},{3797,3276,1755,1727,1131,4108,3633,1835,1345,1293,2778,2805},{1215,84,282,2721,2360,2321,1435,2617,1202,2876,3420,3034}},
                405548684
        ));
        System.out.println("==================");
    }


    record Ele(int x, int y, int val) {
    }

    public int[][] rotateGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] ng = new int[n][m];
        int level = Math.min(n, m) / 2;
        for (int i = 0; i < level; i++) {
            // build array
            var list = buildArray(grid, i);
//            System.out.println(list.size());
            // rotate array
            int curk = k % list.size();
            int size = list.size();
            // fill array
            for (int j = 0; j < list.size(); j++) {
                int to = (j - curk + size) % size;
                int v = list.get(j).val;
                ng[list.get(to).x][list.get(to).y] = v;
            }
        }

        return ng;
    }

    private ArrayList<Ele> buildArray(int[][] grid, int st) {
        int n = grid.length;
        int m = grid[0].length;
        int ex = n - st - 1;
        int ey = m - st - 1;
        var res = new ArrayList<Ele>();
        // go right y->ey
        for (int i = st; i <= ey; i++) {
            res.add(new Ele(st, i, grid[st][i]));
        }
        // go top x-> ex
        for (int i = st + 1; i <= ex; i++) {
            res.add(new Ele(i, ey, grid[i][ey]));
        }
        // go left
        for (int i = ey - 1; i >= st; i--) {
            res.add(new Ele(ex, i, grid[ex][i]));
        }
        // go down ex->x
        for (int i = ex - 1; i > st; i--) {
            res.add(new Ele(i, st, grid[i][st]));
        }
        return res;
    }


}
