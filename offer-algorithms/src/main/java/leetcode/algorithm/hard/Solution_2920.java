package leetcode.algorithm.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #tree #dp
 * @author: WhyWhatHow
 **/

public class Solution_2920 {

    public static void main(String[] args) {
        Solution_2920 sol = new Solution_2920();
        int x = 10000;
        int cnt = 0;
        while (x > 0) {
            x /= 2;
            System.out.println(x);
            cnt++;
        }
        System.out.println("===" + cnt);
        System.out.println("==================");
    }

    /**
     * floor(coins[i] / 2) 等价于  coins[i] >> 1 ; set x = coins[i], x<=10^4, x 右移14次 为0. 所以只需统计前14次即可.
     *
     * @param edges
     * @param coins
     * @param k
     * @return
     */
    public int maximumPoints(int[][] edges, int[] coins, int k) {
        int n = coins.length;
        g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<Integer>());
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }
        return dfs(0, 0, -1, coins, k);

    }

    ArrayList<Integer>[] g;
    HashMap<Integer, Integer> map = new HashMap<>();

    /**
     * current node is i, you already do j time floor(x/2) ; and your parentNode is fa .
     * dfs(i,j,fa) is the max value of tree which rootId is i.
     * dfs(i,j,fa) = Max (
     * coins[i]>>j -k, j, fa)+ sum(dfs(child,j,fa)),  // chose method 1
     * coins[i]>>(j+1)  +sum(dfs(child,j+1,fa)); // chose method 2
     * @return
     */
    private int dfs(int i, int j, int fa, int[] coins, int k) {

        int key = (i << 5) | j;
        if (map.containsKey(key)) return map.get(key);
        int r = (coins[i] >> j) - k;
        int rf = coins[i] >> (j + 1);
        for (Integer sub : g[i]) {
            if (sub == fa) continue; // parent node.
            r += dfs(sub, j, i, coins, k);
            if (j + 1 <= 14)
                rf += dfs(sub, j + 1, i, coins, k);
        }
        r = Math.max(r, rf);
        map.put(key, r);
        return r;
    }

    /**
     * floor(coins[i] / 2) 等价于  coins[i] >> 1 ; set x = coins[i], x<=10^4, x 右移14次 为0. 所以只需统计前14次即可.
     *
     * @param edges
     * @param coins
     * @param k
     * @return
     */
    public int maximumPointsLing(int[][] edges, int[] coins, int k) {
        int n = coins.length;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            g[x].add(y);
            g[y].add(x);
        }

        int[][] memo = new int[n][14];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
//        return dfs(0, 0, -1);
        return dfs(0, 0, -1, memo, g, coins, k);
    }

    /**
     * dfs(i,j) means In tree 0->i range , use j times floor(x/2) , max value.
     * chose method_1:
     * method_2:
     */
    private int dfs(int i, int j, int fa, int[][] memo, List<Integer>[] g, int[] coins, int k) {
        if (memo[i][j] != -1) { // 之前计算过
            return memo[i][j];
        }
        int res1 = (coins[i] >> j) - k;
        int res2 = coins[i] >> (j + 1);
        for (int ch : g[i]) {
            if (ch == fa) continue;
            res1 += dfs(ch, j, i, memo, g, coins, k); // 不右移
            if (j < 13) { // j+1 >= 14 相当于 res2 += 0，无需递归
                res2 += dfs(ch, j + 1, i, memo, g, coins, k); // 右移
            }
        }
        return memo[i][j] = Math.max(res1, res2); // 记忆化
    }
}
