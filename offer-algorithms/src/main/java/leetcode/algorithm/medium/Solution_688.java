package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_688 {

    public static void main(String[] args) {
        double[][][] res = new double[200][26][26];

        Solution_688 sol = new Solution_688();
        System.out.println(sol.knightProbability(
                8, 10, 0, 0
//                3, 2, 0, 0
        ));

        System.out.println("==================");
    }

    int[] dirx = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    int[] diry = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
    double[][][] res = new double[200][26][26];

    /**
     * f(i,j,k) 表示马 在(i,j)点 余k步 时的概率.
     * f(i,j,k) = 1/8* sum( f(x,y,k-1) )
     *
     * @param n
     * @param k
     * @param row
     * @param column
     * @return
     */
    public double knightProbability(int n, int k, int row, int column) {
//        Arrays.fill(res, -1);
        dfs(n, k, row, column);
        return res[k][row][column];
    }

    double base = 0.125d;

    /**
     * f(i,j,k) 表示马 在(i,j)点 余k步 时的概率.
     * f(i,j,k) = 1/8* sum( f(x,y,k-1) )
     *
     * @param n
     * @param k
     * @param row
     * @param column
     */
    private double dfs(int n, int k, int row, int column) {
        if (k == 0) {
            res[k][row][column] = 1;
            return 1;
        }

        if (res[k][row][column] > 0) return res[k][row][column];
        double val = 0;
        for (int i = 0; i < dirx.length; i++) {
            int x = dirx[i] + row;
            int y = diry[i] + column;
            if (x < 0 || y < 0 || x >= n || y >= n) continue;
            System.out.println("x:" + x + " y :" + y);
            val += base * dfs(n, k - 1, x, y);
        }
        res[k][row][column] = val;
        return val;
    }


}


