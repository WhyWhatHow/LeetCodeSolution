package leetcode.algorithm.dp;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #dp #2200 #redo
 * @author: WhyWhatHow
 **/

public class Solution_3129 {

    public static void main(String[] args) {
        Solution_3129 sol = new Solution_3129();
        System.out.println(sol.numberOfStableArrays(
//                3, 3, 2
                20, 15, 75
        ));
        System.out.println("==================");
    }

    int mod = 1_000_000_007;
    int zero, one, limit;

    public int numberOfStableArrays(int zero, int one, int limit) {
        this.zero = zero;
        this.one = one;
        this.limit = limit;

        long res = (dfs(zero, one, 0) % mod + dfs(zero, one, 1) % mod);
        return (int) (res % mod);
    }

    HashMap<String, Long> map = new HashMap<>();

    /***
     * 设 dfs(i,j,k) 表示用i个0, j个1, 以及i=j位置填k (0,或者1) 时的合法方案数.
     * when k=0,
     * dfs(i,j,0) = dfs(i-1,j,1) + dfs(i-1,j,0) - dfs(i-limit-1, j, 0)
     * when k= 1,
     * dfs(i,j,1) = dfs(i,j-1,0) + dfs(i,j,1) - dfs(i, j-limit-1, j, 1)
     * @param i
     * @param j
     * @param k
     */
    long dfs(int i, int j, int k) {
        if (i < 0 || j < 0) return 0;

        if (i == 0) return k == 1 && j <= limit ? 1 : 0;
        if (j == 0) return k == 0 && i <= limit ? 1 : 0;

        String key = i + "," + j + "," + k;
        if (map.containsKey(key)) return map.get(key);

        long ans = 0;
        if (k == 0) {
            ans = dfs(i - 1, j, 1) + dfs(i - 1, j, 0)
                    - dfs(i - limit - 1, j, 1)
            ;
//            ans = i > limit ? ans - dfs(i - limit - 1, j, 1) : ans;

        } else {
            ans = dfs(i, j - 1, 0) + dfs(i, j - 1, 1)
                    - dfs(i, j - limit - 1, 0)
            ;
//            ans = j > limit ? ans - dfs(i, j - limit - 1, 0) : ans;
        }
        if (ans < 0) {
            ans += mod;
        }
        ans %= mod;
        map.put(key, ans);
        return ans;
    }


}


