package leetcode.algorithm.dp;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3418 {

    public static void main(String[] args) {
        Solution_3418 sol = new Solution_3418();//
        System.out.println(sol.maximumAmount(new int[][]{
                {-7, 12, 12, 13}, {-6, 19, 19, -6}, {9, -2, -10, 16}, {-4, 14, -10, -9}}));
        System.out.println("==================");
    }

    HashMap<Long, Integer> map = new HashMap<>();

    long genKey(int i, int j, int k) {
        return (i << 12) | (j << 2) | k;
    }

    // set f(i,j,k) means in (i,j) has k options that can turn a nagitive val-> positive  max val .
    // coins(i,j) > 0 , ==> f(i,j,k)= max(f (i-1, j , k) , f(i,j-1,k) )  + coins(i,j)
    // coins(i,j) <0    ==> f(i,j,k) = max(f(i-1,j,k-1), f(i,j-1,k-1)) ; // 放置被夺走的.

    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;
        return dfs(n - 1, m - 1, 2, coins);
    }

    //    dfs(−1,j,k)=dfs(i,−1,k)=−∞。用 −∞ 表示不合法的状态，从而保证 max 不会取到不合法的状态。
//    dfs(0,0,0)=coins[0][0]。
//    dfs(0,0,k>0)=max(coins[0][0],0)。
    private int dfs(int i, int j, int k, int[][] coins) {
        if (i < 0 || j < 0 || k < 0) return Integer.MIN_VALUE / 2;
        //coins(0,0) <0 && k>0
        if (i == 0 && j == 0) {
            if (coins[i][j] < 0 && k > 0) {
                return 0;
            }
            return coins[i][j];
        }

        var key = genKey(i, j, k);
        if (map.containsKey(key)) return map.get(key);

        // 不选择使用k
        int res = coins[i][j] + Math.max(dfs(i - 1, j, k, coins), dfs(i, j - 1, k, coins));
        // 选择使用k
        if (coins[i][j] < 0 && k > 0)
            res = Math.max(res,
                    Math.max(dfs(i - 1, j, k - 1, coins), dfs(i, j - 1, k - 1, coins)));

        map.put(key, res);
        return res;
    }

}
