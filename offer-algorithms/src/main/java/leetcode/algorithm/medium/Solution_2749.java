package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2749 {

    public static void main(String[] args) {
        Solution_2749 sol = new Solution_2749();
        System.out.println(sol.makeTheIntegerZero(3, -2));
        System.out.println("==================");
    }


    /**
     * 一次循环是: num1 -num2 -2^i,
     * 第k次循环后的值会是  num1 - k*num2 - k * 2^i(i 可以变化)
     * 假设在第k次循环时结束, 那么 我们 有 num1 - k*num2 = k*2^i ( i 可以变化)
     * 令 x = num1 - k*num2;
     * 等式右侧: 变相等于x的二进制1出现的次数.
     * 等式左侧: 最多可以由x个1 组成.
     * 两个共同决定了k 的取值范围[x.bitcount() , x]
     * 若k 满足这个范围,则表示k为其中的一个解.
     * 题目要求最小解, 遍历k 是不是就可以了?
     * 是的.
     *
     * @param num1
     * @param num2
     * @return
     */
    public int makeTheIntegerZero(int num1, int num2) {
        long val = num1;
        long k = 1;
        while (true) {
            val -= num2;
            if (k > val) return -1;
            if (k >= Long.bitCount(val)) return (int) k;
            k++;
        }
    }
}


