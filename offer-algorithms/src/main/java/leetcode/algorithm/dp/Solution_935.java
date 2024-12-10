package leetcode.algorithm.dp;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_935 {

    public static void main(String[] args) {
        Solution_935 sol = new Solution_935();
        System.out.println(Integer.MAX_VALUE > sol.MOD);
        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) + " : " + sol.knightDialer(i + 1));
        }
        System.out.println("==================");
    }

    int MOD = 1000_000_000 + 7;

    public int knightDialer(int n) {
        // init g
//      04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94
        int[][] g = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};

        int[][] arr = new int[10][n + 1];
        for (int i = 0; i < 10; i++) {
            dfs(g, i, n, arr);
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res += arr[i][n];
            if (res > MOD) res %= MOD;
        }
        return res;
    }

    // f(i,n) means current idx is i  , has n step's max value.
    // f(i,n) = sum(f(j,n-1))  j can reach out i.
    private int dfs(int[][] g, int cur, int n, int[][] res) {
        if (n <= 0) return 0;
        if (n == 1) {
            res[cur][n] = 1;
            return 1;
        }
        if (res[cur][n] > 0) return res[cur][n];
        int val = 0;

        for (int i : g[cur]) {
            val += dfs(g, i, n - 1, res);
            if (val > MOD) val %= MOD;
        }
//        if (val > MOD) val %= MOD;
        res[cur][n] = val;
        return val;
    }
}


