package leetcode.algorithm.hard;

import java.util.TreeMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2106 {

    public static void main(String[] args) {
        Solution_2106 sol = new Solution_2106();
        System.out.println(sol.maxTotalFruits(new int[][]{
                        {2, 8}, {6, 3}, {8, 6}
//                        {2000_00,1000}
//                        {0, 10000}
                },
                5, 4
//                0,2000_00
//                2000_00, 2000_00
        ));
        System.out.println("==================");
    }

    // 统计 从[startPos-k,startPos] -> [startPos, startPos+k] 之间的最大值.
    // 使用treemap 解题 , key 表示位置, val: 表示[0,i] range内所有的水果.
    // 对于[i,j] 区间而言,  map.floor(j) - map.floor(i-1)
    // 注意: 由于需要 0这个位置,需要默认放置{-1,0} 作为下界. 以及 {2000_00, presum} 作为上界(貌似可以省略).
    // map{key : pos, val means [0,i] pre_sum ;}
    // [i,j]  map[j]- map[i-1]

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int sum = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>(); //  key: position , val: [0,key] val;
        map.put(-1, 0);
        for (int[] f : fruits) {
            sum += f[1];
            map.put(f[0], sum);
        }
        int MAX = 2000_00;
        map.put(MAX, sum); //

        int res = 0;
        // go to left
        for (int l = 0; l <= k; l++) {
            int lp = startPos - l;
            lp = Math.max(0, lp);
            int r = k - l;
            int rp = lp + r;
            rp = Math.min(rp, MAX);
            res = Math.max(map.floorEntry(rp).getValue() - map.floorEntry(lp - 1).getValue(), res);
        }

//        right
        for (int r = 0; r <= k; r++) {
            int rp = startPos + r;
            rp = Math.min(rp, MAX);
            int l = k - r;
            int lp = rp - l;
            lp = Math.max(0, lp);
            res = Math.max(map.floorEntry(rp).getValue() - map.floorEntry(lp - 1).getValue(), res);
        }
        return res;
    }


    //  数组
    // 统计 从[startPos-k,startPos] -> [startPos, startPos+k] 之间的最大值.
    // 设 f[i] 表示 [0,i) 范围内的果子之和.
    // [0,i] 范围的前缀和, [i,j] f[j]-f[i-1] ,如果要表示0 , 需要整体右移一格, 不方便思考.
    // 则 区间[i,j]内的果子和则是:   f[j+1]-f[i]
    public int maxTotalFruitsByArray(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int MAX = 2000_00;
        int[] dp = new int[2000_05];

        // count preSum
        int j = 0;
        for (int[] ff : fruits) {
            int i = ff[0], val = ff[1];
            while (j <= i) {
                dp[j + 1] = dp[j];
                j++;
            }
            dp[i + 1] = dp[i] + val;
//            j = i;
        }

        while (j + 1 < dp.length) {
            dp[j + 1] = dp[j];
            j++;
        }

        //  最大水果数量
        int res = 0;

        // 向左走
        for (int l = 0; l <= k; l++) { // l 向左走的步数.
            int r = k - l;
            int lpos = startPos - l;
            lpos = Math.max(0, lpos);
            int rpos = lpos + r;
            rpos = Math.min(MAX, rpos);
            res = Math.max(res, dp[rpos + 1] - dp[lpos]);
        }

        // 向右走
        for (int r = 0; r <= k; r++) {
            int l = k - r;
            int rpos = startPos + r;
            rpos = Math.min(MAX, rpos);
            int lpos = rpos - l;
            lpos = Math.max(0, lpos);
            res = Math.max(dp[rpos + 1] - dp[lpos], res);
        }

        return res;
    }
}


