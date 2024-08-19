package leetcode.algorithm.dp;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #dp #hard
 * @author: WhyWhatHow
 **/

public class Solution_552 {

    public static void main(String[] args) {
        Solution_552 sol = new Solution_552();
        System.out.println("==================");
    }

    int mod = 1_000_000_000 + 7;

    public int checkRecord(int n) {
        return (int) dfs(n, 0, 0);
    }

    HashMap<String, Integer> map = new HashMap<>();
    int[][][] f = new int[100000][2][3];

    /**
     * 从右往左填
     *
     * @param i 表示剩余n个位置没有填
     * @param j 填A的数量
     * @param k 当前位置n, 右侧有多少个连续的L
     * @return
     */
    private long dfs(int i, int j, int k) {
        if (i == 0) return 1;
//         string overtime reason.  #think
//        String key = i + "," + j + "," + k;
//        if (map.containsKey(key)) {
//            return map.get(key);
//        }
        if (f[i][j][k] > 0) return f[i][j][k];
        long res = dfs(i - 1, j, 0); // P
        if (j == 0) res += dfs(i - 1, 1, 0); //A
        if (k < 2) res += dfs(i - 1, j, k + 1);//L

        res %= mod;
        f[i][j][k] = (int) res;
//        map.put(key, (int) res);
        return res;
    }

}


