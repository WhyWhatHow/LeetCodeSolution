package leetcode.algorithm.dp;

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

    // f(i,j,km) means 到(i, j)的路径和 mod k ==km 的路径数量.
    /**
     * int v = g[i][j]
     * f(i,j,p) = f(i-1,j,(v+p)%k==p ) + f(i, j-1, (v+p)%k==p )
     */
    HashMap<Long, Integer> map = new HashMap<>();

    long genKey(int i, int j, int k) {
        long l = (long) (i << 30) | (long) (j << 7) | k;
        return l;
    }


    public int numberOfPaths(int[][] grid, int k) {

        int m = grid.length, n = grid[0].length;
        // init
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = grid[i][j] % k;
            }
        }
        return dp(grid, k);
//        return dfs(grid, m - 1, n - 1, 0, k);
    }

    int[][][] f;

    /**
     * f(i,j,v) means (0,0)-> (i,j) sum%k == v 的路径数量.
     *  nv = v+g[i+1][j]
     *  f(i+1,j,nv)  = f(i,j,v) + f(i+1,j,nv) ;
     *  nv = v+ g[i][j+1]
     *  f(i,j+1,nv)  = f(i,j,v) + f(i,j+1,nv)
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

    // 到点(i,j) 和为sum, 且其sum%k == p 的情况下的数量.
    private int dfs(int[][] grid, int i, int j, int p, int k) {
        if (i < 0 || j < 0) return 0;
//        if (i == 0 && j == 0) return p == 0 ? 1 : 0;

        long key = genKey(i, j, p);
        if (map.containsKey(key)) return map.get(key);
        long res = 0;
        int v = grid[i][j] % k;
        int tar = k - v;

        res = dfs(grid, i - 1, j, (p + mod - v) % k, k) + dfs(grid, i, j - 1, (p + mod - v) % k, k);
//        res = dfs(grid, i - 1, j, (v + p) % k, k) + dfs(grid, i, j - 1, (v + p) % k, k);
        res = res % mod;
        map.put(key, (int) res);
        return (int) res;
    }

}


