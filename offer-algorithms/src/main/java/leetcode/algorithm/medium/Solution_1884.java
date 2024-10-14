package leetcode.algorithm.medium;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1884 {

    public static void main(String[] args) {
        Solution_1884 sol = new Solution_1884();
        System.out.println("==================");
    }

    public int twoEggDrop(int n) {
        map = new HashMap<>();
        return dfs(n);
    }


    HashMap<Integer, Integer> map; // k,v-> i level , op.

    /**
     * dfs[n] : 第i层鸡蛋破碎的情况下,最小操作数.
     * 假设n =10,
     * 1st 选择 4层:
     * con1: 鸡蛋坏掉, 至多需要1+(1,2,3){第二个鸡蛋的选择} =4;
     * con2: 鸡蛋不坏: 问题等价为6层的情况(前四层不坏) 即 `dfs(6)+1`;// 1表示第一次抛4的情况下不会坏的结果.
     *
     * @param n
     * @return
     */
    private int dfs(int n) {
        if (n == 0) return 0;
        if (map.containsKey(n)) return map.get(n);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
//            int con1 = i;//condition1:  not broken
//            int con2 = dfs(n - i) + 1;// broken
            res = Math.min(res, Math.max(i, dfs(n - i) + 1));
        }
        map.put(n, res);
        return res;
    }

}


