package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3001 {

    public static void main(String[] args) {
        Solution_3001 sol = new Solution_3001();
//        System.out.println(sol.minMovesToCaptureTheQueen(1, 1, 1, 4, 1, 8));
        sol.minMovesToCaptureTheQueen(8,4,8,8,7,7);
        System.out.println("==================");
    }


    //    (a, b) 表示白色车的位置。
//            (c, d) 表示白色象的位置。
//            (e, f) 表示黑皇后的位置。

    /**
     * 解决两个点, 判断 rook and queen, bishop and queen 是否在一条直线上.
     * 如果是, 判断 rook 会不会挡住 bishop, 如果会 结果是2 , 不会结果是1.
     *
     * @return
     */
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        // check bishop and queen
        if (check(a, b, c, d, e, f)) return 1;
            // check rook and queen
        else if (a == e) {
            if ((c == a && ((d < b && d > f) || (d > b && d < f)))) return 2;
            else return 1;
        } else if (b == f) {
            if (d == b && ((c > a && c < e) || (c > e && c < a))) return 2;
            else return 1;
        } else
            return 2;
    }

    int[] dir = new int[]{-1, 1, 1, -1, -1};

    // 判断 象 与 queen 是否在同一对角线
    private boolean check(int a, int b, int c, int d, int e, int f) {
        for (int i = 1; i < dir.length; i++) {
            int x = e;
            int y = f;
            boolean check = false; // 判断rook 是否会在bishop, 和 queen中间.
            while (true) {
                x += dir[i - 1];
                y += dir[i];
                if (x < 0 || y < 0 || x > 8 || y > 8) break;
                if (x == a && y == b) check = true;
                if (!check && x == c && y == d) return true;
            }
        }
        return false;
    }
}


