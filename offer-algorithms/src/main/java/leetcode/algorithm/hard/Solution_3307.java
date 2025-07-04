package leetcode.algorithm.hard;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3307 {

    public static void main(String[] args) {
        Solution_3307 sol = new Solution_3307();
        System.out.println(Long.MAX_VALUE);
        System.out.println(sol.kthCharacter(10, new int[]{
                0, 1, 0, 1
        }));
        System.out.println("==================");
    }

    /**
     * k = 10, operations = [0,1,0,1]
     * a
     * 1 : aa
     * 2 : aabb
     * 3 : aabb aabb
     * 4 : aabbaabb bbccbbcc
     * 有题意分析知, 只有在右移的时候c 会发生变化,因此只需要统计右移的次数即可..
     * Sn = Sn-1 + ops(Sn-1);
     * 如果k<Sn的长度, 说明没有用到ops[n] 所以, n-- ,前进.
     * 相反, 则说明 用到了当前操作ops[n] ,
     *
     * @param k
     * @param ops
     * @return
     */
    public char kthCharacter(long k, int[] ops) {
        char[] cs = new char[26];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = (char) ('a' + i);
        }
        // idx
//        int idx = 0;
//        long tmp;
//        for (int i = ops.length - 1; i >= 0; i--) {
//            if (i > 60) continue; // 2^60> maxK , so
//            tmp = 1L << i; // 2^i ,
//            if (k > tmp) { // 需要右移的次数.
//                k -= tmp;
//                idx += ops[i]; // only ops[i]==1 , change char
//            }
//        }
        int idx = dfs(k, Math.min(ops.length - 1, 60), ops);


        return cs[idx % 26];
    }

    /**
     * if k < 2^m ,  nothing change
     * else :   idx+1 ;
     *
     * @param k
     * @param m   2^m , 判断 k<2^m
     * @param ops
     * @return
     */
    private int dfs(long k, int m, int[] ops) {
        if (m < 0) return 0;

        long tmp = 1L << m;


        if (k < tmp) {  // 没有用到当前位置.
            return dfs(k, m - 1, ops);
        }
        return dfs(k - tmp, m - 1, ops) + ops[m];

    }


}


