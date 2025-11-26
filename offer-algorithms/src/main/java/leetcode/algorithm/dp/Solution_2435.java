package leetcode.algorithm.dp;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2435 {

    public static void main(String[] args) {
        Solution_2435 sol = new Solution_2435();
        System.out.println(1 << 23);
        System.out.println(sol.numberOfPaths(new int[][]
                        {{5, 2, 4}, {3, 0, 5}, {0, 7, 2}},
                3));
        System.out.println("==================");
    }

    int mod = 1000_000_007;


    public int numberOfPaths(int[][] grid, int k) {

        int m = grid.length, n = grid[0].length;

//        return dp(grid, k);
        f = new int[m][n][k];
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(f[i][j], -1);
            }
        }
        return dfsByf(grid, m - 1, n - 1, 0, k);
//        return dfs(grid, m - 1, n - 1, 0, k);
    }

    int dfsByf(int[][] grid, int i, int j, int s, int k) {
        if (i < 0 || j < 0)
            return 0;
        // check have ans or not
        if (f[i][j][s] != -1)
            return f[i][j][s];
        if (i == 0 && j == 0) {
            return f[i][j][s] = grid[i][j] % k == s ? 1 : 0;
        }
        // calculate presum
        grid[i][j] %= k;
        int presum = (s - grid[i][j] + k) % k;
        int res = dfs(grid, i - 1, j, presum, k) + dfs(grid, i, j - 1, presum, k);
        res = res % mod;
        return f[i][j][s] = res;
    }

    private int dfs(int[][] grid, int i, int j, int s, int k) {
        if (i < 0 || j < 0) return 0;
        grid[i][j] %= k;
        if (f[i][j][s] != -1) return f[i][j][s];

        // check
        if (i == 0 && j == 0) {
            f[i][j][s] = grid[i][j] % k == s ? 1 : 0;
            return f[i][j][s];
        }

        // calculate presum -> (presum + grid[i][j])%k  =s

        int presum = (s - grid[i][j] + k) % k;
        int res = 0;

        res = (dfs(grid, i - 1, j, presum, k) + dfs(grid, i, j - 1, presum, k)) % mod;
        f[i][j][s] = res;
        return res;
    }

    int[][][] f;

    /**
     * f(i,j,v) means (0,0)-> (i,j) sum%k == v 的路径数量.
     * nv = v+g[i+1][j]
     * f(i+1,j,nv)  = f(i,j,v) + f(i+1,j,nv) ;
     * nv = v+ g[i][j+1]
     * f(i,j+1,nv)  = f(i,j,v) + f(i,j+1,nv)
     */
    int dp(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        f = new int[m + 1][n + 1][k];


        f[0][0][grid[0][0]] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int v = 0; v < k; v++) {
                    if (f[i][j][v] == 0) continue; // not accessible.
                    // go right

                    if (i + 1 < m) {
                        int nv = (v + grid[i + 1][j]) % k;
                        f[i + 1][j][nv] = (f[i][j][v] + f[i + 1][j][nv]) % mod;
                    }
                    // go down
                    if (j + 1 < n) {
                        int nv = (v + grid[i][j + 1]) % k;
                        f[i][j + 1][nv] = (f[i][j + 1][nv] + f[i][j][v]) % mod;
                    }
                }
            }
        }
        return f[m - 1][n - 1][0];
    }


    // f(i,j,v) means 到(i, j)的路径和 mod k ==v 的路径数量.
    /**
     * wa ,超时.
     */
    HashMap<Long, Integer> map = new HashMap<>();

    private long genKey(int i, int j, int s) {
        return ((long) i << 30) | ((long) j << 7) | s;
    }

    // 到点(i,j) 和为sum, 且其sum%k == s 的情况下的数量.
    private int dfsByHashMap(int[][] grid, int i, int j, int s, int k) {
        if (i < 0 || j < 0) return 0;
        long key = genKey(i, j, s);

        if (i == 0 && j == 0) { // 初始节点.
            int res = grid[0][0] == s ? 1 : 0;
            map.put(key, res);
            return res;
        }

        if (map.containsKey(key)) return map.get(key);

        // 1. calculate preSum :  preSum + grid[i][j])%k == s ;
        int preSum = (s - grid[i][j]) % k;
        preSum = preSum < 0 ? preSum + k : preSum;

        long res = 0;

        res = dfs(grid, i - 1, j, preSum, k) + dfs(grid, i, j - 1, preSum, k);
//        res = dfs(grid, i - 1, j, (v + s) % k, k) + dfs(grid, i, j - 1, (v + s) % k, k);
        res = res % mod;
        map.put(key, (int) res);
        return (int) res;
    }

}


