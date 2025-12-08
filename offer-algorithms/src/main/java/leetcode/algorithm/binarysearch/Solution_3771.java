package leetcode.algorithm.binarysearch;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3771 {

    public static void main(String[] args) {
        Solution_3771 sol = new Solution_3771();
        System.out.println(sol.totalScore(
                11
//                2
//                1
                ,
                new int[]{
//                        1, 1
//                        10000, 1
                        3, 6, 7
                }, new int[]{
//                        2, 1
//                        1,1
                        4, 2, 5
                }));
        System.out.println("==================");
    }

    /**
     * 不能用滑动窗口解题的原因是 产生的sc 可能的组合会是 010101,可能存在requirement 特别大的情况, 导致无法获得score .
     * example :  hp = 11
     * dam: 3, 6, 7
     * req: 4, 2, 5
     * sc0: 1, 1, 0 -> 2
     * sc1: 0, 1, 0 -> 1
     * sc2: 0, 0, 0 -> 0
     * 题目的答案会是 3 .
     * 如果横向处理, 我们需要o(n^2)复杂度, 超时.
     * `横难则竖, 正难则反` 思路: 思考竖着做是否可以呢? 代入案例是可以的.
     * 问题转换成如何求 对于 点i 可以获取的分数.
     * 假设在区间[j,i] range 内,开始的所有节点到i的最后的hp >=requirement[i]. 对于i点可以贡献的分数是i-j+1.
     * 即 original_hp - (s_i+1 -s_j) >=r_i ==>  `s_j >= s_i+1 - hp +r_i`
     * 其中s_i 表示[0,i) range 内damage 可以造成的伤害, 单调递增.
     */
    public long totalScore(int hp, int[] damage, int[] requirement) {
        int n = damage.length;
        long[] ss = new long[n + 1];
        for (int i = 0; i < damage.length; i++) {
            ss[i + 1] = ss[i] + damage[i];
        }

        long res = 0;
        for (int i = 0; i < damage.length; i++) {
            long tar = ss[i + 1] - hp + requirement[i];
            int j = search(ss, tar, i + 1);
            res += j != -1 ? i - j + 1 : 0;
        }
        return res;
    }

    private int search(long[] a, long tar, int r) {
        int l = 0;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] >= tar) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}


