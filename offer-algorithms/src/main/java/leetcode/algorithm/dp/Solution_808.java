package leetcode.algorithm.dp;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_808 {

    public static void main(String[] args) {
        Solution_808 sol = new Solution_808();
//        System.out.println(1 << 30);
        System.out.println(sol.soupServings(50));
        System.out.println("==================");
    }

    // 1. A:100 , B:0  ->  A 4 B 0
    //2.  A: 75, B : 25 -> A 3 B 1
    // 3. A:50 , B :50 ->  A 2 B 2
    // 4. A:25, B :75  ->  A 1 B 3
    public double soupServings(int n) {
        map = new HashMap<>();
        if (n > 10000) return 1;
        n = (n + 24) / 25;
        return dfs(n, n);

    }

    HashMap<Long, Double> map;

    //f(i,j) 表示 有i份 A, j份B 的情况下A在B之前完成的概率.
    double dfs(int i, int j) {
        if (i <= 0 && j <= 0) return 0.5;
        if (i <= 0) return 1;
        if (j <= 0) return 0;
        long key = ((long) i << 30) | j;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        double res = 0;
        res = 0.25d * (dfs(i - 4, j) + dfs(i - 3, j - 1) + dfs(i - 2, j - 2) + dfs(i - 1, j - 3));
        map.put(key, res);
        return res;
    }
}