package leetcode.algorithm.dp;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #dp #hard
 * @author: WhyWhatHow
 **/

public class Solution_3154 {

    public static void main(String[] args) {
        Solution_3154 sol = new Solution_3154();
//        System.out.println(sol.waysToReachStair(1));
        System.out.println(sol.waysToReachStair(0));
        System.out.println("==================");

    }

    public int waysToReachStair(int k) {
//        return dfs();
        return dfs(k, 1, 0, false);

    }

    HashMap<String, Integer> map = new HashMap<>();

    /**
     * i ==k , return 1 ;
     * i ==k+1,  i-1 -> k
     * i == k+2
     *
     * @param k    max台阶
     * @param i    当前的i阶台阶
     * @param jump 当前的jump值
     * @param used 标记方案1 是否用过
     * @return
     */
    private int dfs(int k, int i, int jump, boolean used) {
        if (i > k + 1) return 0;

        StringBuilder sb = new StringBuilder();
        String key = sb.append(i).append(',').append(jump).append(used).toString();

        if (map.containsKey(key)) {
            return map.get(key);
        }
        int res = 0;
        if (i == k) res = 1;

        res += dfs(k, i + (1 << jump), jump + 1, false);

        if (!used && i != 0) res += dfs(k, i - 1, jump, true);

        map.put(key, res);
        return res;
    }
    // r->l :

}


