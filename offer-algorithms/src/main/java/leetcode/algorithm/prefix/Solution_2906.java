package leetcode.algorithm.prefix;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_2906 {

    public static void main(String[] args) {
        Solution_2906 sol = new Solution_2906();//

        System.out.println("==================");
    }

    int mod = 12345;

    //二维-> 一维. n*m<=10^5 可以用一维数组保存.
    // 数据溢出, int
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int len = n * m;
        long[] ps = new long[len + 1]; //ps[i] means[0,i) range val .
        long[] ss = new long[len + 1];// ss[i] means[i+1,n) range val;
        int[] a = new int[len];
        ps[0] = ss[len] = 1;
        init(ps, ss, grid, a);

        // calculate val
        int[] rs = new int[len];
        for (int i = 0; i < rs.length; i++) {
            rs[i] = (int) (ps[i] * ss[i + 1] % mod);
        }

        int k = 0;
        int[][] f = new int[n][m];
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++) {
                f[i][j] = rs[k++];
            }
        }
        return f;
    }

    private void init(long[] ps, long[] ss, int[][] grid, int[] a) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                a[cnt++] = grid[i][j];
            }
        }

        for (int i = 0; i < a.length; i++) {
            ps[i + 1] = ps[i] * a[i] % mod;
        }
        for (int i = a.length - 1; i >= 0; i--) {
            ss[i] = ss[i + 1] * a[i] % mod;
        }
    }

}
