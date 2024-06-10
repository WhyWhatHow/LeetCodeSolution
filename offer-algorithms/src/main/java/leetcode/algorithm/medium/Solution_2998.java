package leetcode.algorithm.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_2998 {

    public static void main(String[] args) {
        Solution_2998 sol = new Solution_2998();

        System.out.println(sol.minimumOperationsToMakeEqual(
                26, 1
        ));
        System.out.println(sol.minimumOperationsToMakeEqualBfs(26, 1));
        System.out.println("==================");


    }

    public int minimumOperationsToMakeEqualBfs(int x, int y) {
        if (x <= y) return y - x;

        // x>y
        LinkedList<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>(); // 访问标记
        q.add(x);
        set.add(x);

        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer poll = q.poll();
                if (poll == y) {
                    return cnt < x - y ? cnt  : x - y;
                }

                if (poll % 11 == 0 && !set.contains(poll / 11)) {
                    set.add(poll / 11);
                    q.add(poll / 11);
                }

                if (poll % 5 == 0 && !set.contains(poll / 5)) {
                    set.add(poll / 5);
                    q.add(poll / 5);
                }

                if (!set.contains(poll + 1)) {
                    set.add(poll + 1);
                    q.add(poll + 1);
                }
                if (!set.contains(poll - 1)) {
                    set.add(poll - 1);
                    q.add(poll - 1);
                }
            }
            cnt++;
        }

        return cnt < x - y ? cnt : x - y;

    }

    HashMap<Integer, Integer> map = new HashMap<>();

    /**
     * xx = x / 11 + x % 11
     *
     * @param x
     * @param y
     * @return
     */
    public int minimumOperationsToMakeEqual(int x, int y) {

        return dfs(x, y);
    }


    /**
     * f(x) =
     * (1) x <= y     y - x
     * (2) x > y      x - y
     * (3) 11整除x    f(x/11) + 1
     * (4) 11不整除x，可以先变成11的倍数再操作
     * x - x%11 （x变小成11的倍数）
     * x + 11 - x%11（x变大成11的倍数）
     * (5) 5同理
     * <p>
     * ===================================
     * dfs(i)  为将i 转换为y 最小操作步数.
     * i<=y ,  dfs(i) = y-i ;
     * i> y:
     * m11 = i %11 ;
     * m5 = i%5;
     * dfs[i] = min(
     * i-y,
     * dfs(i/11)+ i%11 + 1, // 相当于处理x 中11的倍数部分(x-x%11), 然后将剩余的(x%11)通过x-- 去掉,  +1 代表本次的操作
     * dfs(i/5) + i%5 + 1, // 同上
     * dfs(i/11+1)+ 11- m11 +1 , //  将x 变为 11(x++)的倍数, 即 xx = x-x%11 +11,     +1 代表本次操作
     * dfs(i/5+1) +5-m5 +1 // 同上
     * )
     *
     * @param x
     * @param y
     * @return
     */
    int dfs(int x, int y) {
        if (x <= y) return y - x;
        // x> y
        if (map.containsKey(x)) {
            return map.get(x);
        }

        int val = x - y;


        int m5 = x % 5;
        int m11 = x % 11;

        val = Math.min(dfs((x / 11), y) + m11 + 1, val);
        // x++ -->xx = 11's num
        val = Math.min(dfs((x / 11 + 1), y) + 11 - m11 + 1, val);

        val = Math.min(dfs((x / 5), y) + m5 + 1, val);

        val = Math.min(dfs((x / 5 + 1), y) + 5 - m5 + 1, val);

//        if (x % 11 == 0) {
//            val = Math.min(val, dfs((x / 11), y) + 1);
//        } else {
////             +1 op -> x%11 =0 ==> x - x%11 +11
//            val = Math.min(val, dfs((x / 11 + 1), y) + 11 - x % 11 + 1);
//            // -1 op --> x%11 = 0 ==> x - x%11
//            val = Math.min(val, dfs((x / 11), y) + x % 11 + 1);
//        }
//
//        if (x % 5 == 0) {
//            val = Math.min(val, dfs((x / 5), y) + 1);
//        } else {
//            // -1
//            val = Math.min(val, dfs((x / 5), y) + x % 5 + 1);
//            // +1
//            val = Math.min(val, dfs((x / 5 + 1), y) + 5 - x % 5 + 1);
//        }

        map.put(x, val);

        return val;

    }

}


