package leetcode.algorithm.dp;

import java.util.*;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3651 {

    public static void main(String[] args) {
        Solution_3651 sol = new Solution_3651();//
        System.out.println(sol.minCost(
                new int[][]{{1, 3, 3}, {2, 5, 4}, {4, 3, 5}},
                2
        ));
        System.out.println("==================");
    }


    // set f(i,j,t) : 表示 在t次跳跃中,到达点(i,j) 最小成本.
    // f(i, j ,t) 取值有两种情况.
    // 1. 不跳跃.    min ( f(i-1,j,t)  , f(i, j-1,t) ) +grid[i][j] ;
    // 2.跳跃. 对于跳跃到的点 (i,j) 而言,
    // f(i,j,t) =min(f(i',j',t-1))  condition: grid[i'][j']>=grid[i][j]
    // 由此, 我们维护一个map=>{key: grid[i][j], val:{(i,j), }} val表示于之相关的点的集合,
    // 由于我们要的是grid[i'][y'] >=grid[i][j],
    // 对于 每一个key ,我们需要维护一个值表示到这个key的最小值, mn[key] = ? , example: key2< key1,  所以 mn[key2]  = min(mn[key1],mn[key2]).枚举的节点值.
    // 因而, 推导出一个优化的思路, 将key 按照逆序排列后, 上一个key的mn 可以自动用到下一个key中, 进而减小计算.
    // 即 : 当我们把key 按照降序排列后,我们只需维护一个统一的mn 表示当前key的取值最小值即可.

    // f(0,0,0) = 0 ;
    int[][][] f;

    public int minCost(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int MAX = Integer.MAX_VALUE;

        // init f
        f = new int[n][m][k+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(f[i][j], MAX);
            }
        }
        f[0][0][0] = 0;
        // 对于k==0 的情况的处理.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i > 0) f[i][j][0] = Math.min(f[i][j][0], f[i - 1][j][0] + grid[i][j]);
                if (j > 0) f[i][j][0] = Math.min(f[i][j][0], f[i][j - 1][0] + grid[i][j]);
            }
        }

        var map = new HashMap<Integer, List<int[]>>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                var list = map.getOrDefault(grid[i][j], new ArrayList<>());
                list.add(new int[]{i, j});
                map.put(grid[i][j], list);
            }
        }

        var keys = map.keySet().stream().sorted(Collections.reverseOrder()).toList();

        // handle every level
        for (int t = 1; t <= k; t++) {
            // case key desc, so we should define mn as t-1 min_val cost.
            int mn = MAX; // mn as minCost for.
            for (Integer key : keys) {  // 对每一个值找到其的最小代价.
                var list = map.get(key);
                // find mn in of this key.
                for (int[] a : list) {
                    int x = a[0], y = a[1];
                    mn = Math.min(mn, f[x][y][t - 1]);
                }
                // update key -> mn
                for (int[] a : list) {
                    int x = a[0], y = a[1];
                    f[x][y][t] = Math.min(f[x][y][t], mn);
                }
            }
            // 不跳的情况
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i > 0) f[i][j][t] = Math.min(f[i][j][t], f[i - 1][j][t] + grid[i][j]);
                    if (j > 0) f[i][j][t] = Math.min(f[i][j][t], f[i][j - 1][t] + grid[i][j]);
                }
            }
        }

        // 求结果
        int res = MAX;
        for (int i = 0; i <= k; i++) {
            res = Math.min(res, f[n - 1][m - 1][i]);
        }
        return res;

    }

}


