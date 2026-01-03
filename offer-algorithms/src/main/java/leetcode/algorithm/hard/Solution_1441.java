package leetcode.algorithm.hard;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1441 {

    public static void main(String[] args) {
        Solution_1441 sol = new Solution_1441();
        System.out.println("==================");
    }

    /**
     * 设1,2,3 为三个颜色.
     * 由题意知,  那么一row 可以的选择是121,类型以及123 类型.
     * 对于1 row:
     * 121: 121,131,212,232,313,323
     * 123: 123,132,213,231,312,321
     * 对于第二row:
     * 假设前一行是 121:那么可以的选择是 212, 232,313 三个(121型) 以及 231,312 两个 (123型)
     * 123: ==>{212,232,} {231,312,} 一共四个.
     * 对于之后的每一行,我们都有类似的规律.
     * 那么 可得: 设 121 为 a, 123 为b
     */
    public int numOfWays(int n) {
        long res = 0;
        int mod = 1000_000_007;
        long a = 6, b = 6;// 表示prev 行 121 的可能的方案数是 a个, 123 的方案数是b个.
        res = a + b;
        while (n-- > 0) {
            long na = (a * 3 + b * 2) % mod;
            long nb = (a * 2 + b * 2) % mod;
            res = (na + nb) % mod;
            a = na;
            b = nb;
        }
        return (int) res;
    }
}


