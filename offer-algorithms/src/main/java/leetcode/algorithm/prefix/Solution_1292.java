package leetcode.algorithm.prefix;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1292 {

    public static void main(String[] args) {
        Solution_1292 sol = new Solution_1292();
        System.out.println(sol.maxSideLength(
//                new int[][]{{1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}},
//                4
                new int[][]{{18, 70}, {61, 1}, {25, 85}, {14, 40}, {11, 96}, {97, 96}, {63, 45}},
                40184
        ));

        System.out.println("==================");
    }


    public int maxSideLength(int[][] mat, int threshold) {
        int min = 10_000;
        int n = mat.length;
        int m = mat[0].length;

        // init ps
        int[][] ps = new int[n + 1][m + 1]; // ps[i+1][j+1] means (0,0)到 (i,j) 之间的前缀和.
        // ps[i+1][j+1] = ps[i][j+1] + ps[i+1][j] - ps[i][j] + mat[i][j]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                min = Math.min(min, mat[i][j]);
                ps[i + 1][j + 1] = ps[i][j + 1] + ps[i + 1][j] - ps[i][j] + mat[i][j];
            }
        }

        if (min > threshold) return 0;


        int maxLen = Math.min(n, m);
        int res = 1;

        for (int k = 2; k <= maxLen; k++) {
            boolean yes = false;
            for (int i = k; i <= n; i++) {
                for (int j = k; j <= m; j++) {
                    // 求区间和, (i-k, j-k) 到 (i-1, j-1) 的矩形区域和时:
                    int t = ps[i][j] - ps[i - k][j] - ps[i][j - k] + ps[i - k][j - k];
                    if (t <= threshold) {
                        yes = true;
                        break;
                    }
                }
                if (yes) break;
            }
            if (yes) res = k;
            else break;
        }
        return res;
    }

}


