package leetcode.algorithm.hard;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_887 {

    public static void main(String[] args) {
        Solution_887 sol = new Solution_887();
        System.out.println(sol.superEggDrop(
                3, 14
        ));
        System.out.println("==================");
    }

    /***
     * k\n | 1 | 2 | 3| 4| 5| 6|
     * 1   | 1 | 2 | 3| 4| 5| 6|
     * 2   | 1 |
     * 3   | 1 |
     * 设f[k][n] 为 n层楼, k个鸡蛋 可以确定f 的最小操作数.
     * 对于 0-n 之间的楼层, 假设选择i层,
     * con1 : 鸡蛋碎掉, f[k-1][i] +1 ,
     * con2 : 鸡蛋不碎: f[k][n-i] +1 , 问题等价转化成 k个鸡蛋在n-i层的时的最小操作数.
     * 所以 f[k][n]= max {f[k-1][i-1]+1, f[k][n-i]+1}  // i 属于[1,n];
     * eg : f[2][2] = f[1][0]+1,
     * @param k
     * @param n
     * @return
     */
    public int superEggDrop(int k, int n) {
        int[][] f = new int[k + 1][n + 1];
        for (int i = 1; i < f[1].length; i++) {
            f[1][i] = i;
        }
        for (int i = 1; i < f.length; i++) {
            f[i][1] = 1;
        }

        dfs(f, k, n);
        // wa
//        for (int i = 2; i < f.length; i++) { // 鸡蛋数
//            for (int j = 2; j <= n; j++) { // 楼层 层数
//                for (int l = 1; l < j; l++) {
//                    int tmp = Math.max(f[i - 1][l], f[i][j - l]) + 1;
//                    f[i][j] = Math.max(f[i][j],tmp);
//                }
//            }
//        }
        return f[k][n];
//        map = new HashMap<>();
//        return dfs(n, k);
    }

    private int dfs(int[][] f, int k, int n) {
        if (k == 1 || n <= 1 || f[k][n] > 0) return f[k][n];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int max = Math.max(dfs(f, k - 1, i-1), dfs(f, k, n - i)) + 1;
            min =Math.min(min,max);
        }
        f[k][n] = min ;
        return f[k][n];
    }

    HashMap<Integer, Integer> map;

    /**
     * @param n
     * @param k
     * @return
     */
    private int dfs(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (k == 1) return n;
        int key = (k << 10) | n;
        if (k >= 0 && map.containsKey(key)) return map.get(key);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            // 第i 层 鸡蛋碎掉 dfs( k-1, i) ;
            // 第 i层, 鸡蛋不随, dfs(n-i, k)
            res = Math.min(res, Math.max(dfs(i, k - 1), dfs(n - i, k)) + 1);
        }

        map.put(key, res);
        return res;
    }

}


