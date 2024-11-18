package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_661 {

    public static void main(String[] args) {
        Solution_661 sol = new Solution_661();
        System.out.println(sol.imageSmoother(new int[][]{
                {100, 200, 100},
                {200, 50, 200},
                {100, 200, 100}
        }));
        System.out.println("==================");
    }

    public int[][] imageSmoother(int[][] img) {
        int[][] g = new int[img.length][img[0].length];
        int[] dir = new int[]{-1, 1, 1, -1, -1}; //
        int[] dd = new int[]{-1, 0, 1, 0, -1}; // up down left right

        for (int i = 0; i < img.length; i++) {

            for (int j = 0; j < img[0].length; j++) {
                int sum = 0, cnt = 1;
                int[] handle = handle(i, j, img, dir);
                sum += handle[0];
                cnt += handle[1];
                handle = handle(i, j, img, dd);
                sum += handle[0];
                cnt += handle[1];
                g[i][j] = (int) Math.floor(1.0d * (sum + img[i][j]) / cnt);

            }
        }
        return g;
    }

    private int[] handle(int x, int y, int[][] g, int[] dir) {
        int sum = 0;
        int cnt = 0;
        for (int i = 1; i < dir.length; i++) {
           int dx = x+ dir[i - 1];
            int dy = y+ dir[i];
            if (dx < 0 || dy < 0 || dx >= g.length || dy >= g[0].length) continue;
            cnt++;
            sum += g[dx][dy];
        }
        return new int[]{sum, cnt};
    }

}


