package leetcode.algorithm.hard;

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
     * con1 : 鸡蛋碎掉, f[k-1][i-1] +1 ,
     * con2 : 鸡蛋不碎: f[k][n-i] +1 , 问题等价转化成 k个鸡蛋在n-i层的时的最小操作数.
     * 所以 f[k][n]= max {f[k-1][i-1]+1, f[k][n-i]+1}  // i 属于[1,n];
     * 问题又来了, 迭代1,n 会超时,所以需要思考优化方法, 比如二分查找.
        * T1(k-1, x-1) 表示鸡蛋碎了的情况，随着 x 增加而增加。
        * T2(k, n-x) 表示鸡蛋没碎的情况，随着 x 增加而减少。
     * 我们的目标是找到 min(max(T1, T2))。(看一下题哦)
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
        return f[k][n];
    }

    private int dfs(int[][] f, int k, int n) {
        if (k == 1 || n <= 1 || f[k][n] > 0) return f[k][n];
        int min = Integer.MAX_VALUE;
        int l = 1, r = n;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            int broken = dfs(f, k - 1, mid - 1); // broken egg
            int safe = dfs(f, k, n - mid); // not broken egg.
            if (broken < safe) { // chose min
                r = mid - 1;
                min = Math.min(min, safe + 1);
            } else {
                l = mid + 1;
                min = Math.min(min, broken + 1);
            }
        }
        f[k][n] =min ;
        return f[k][n];
    }


}


