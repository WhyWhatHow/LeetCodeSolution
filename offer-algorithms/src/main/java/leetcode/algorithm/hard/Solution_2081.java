package leetcode.algorithm.hard;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2081 {

    public static void main(String[] args) {
        Solution_2081 sol = new Solution_2081();
        System.out.println(sol.kMirror(2, 5));
        System.out.println(Long.toString(121, 3));
        System.out.println(Integer.toString(121, 3));
        System.out.println("==================");
    }

    static ArrayList<Long>[] ans = new ArrayList[10]; // 2-9 进制 每一个合格的元素数.
    static boolean inited = false;

    static void init() {
        if (inited) return;
        inited = true;
        Arrays.setAll(ans, i -> new ArrayList<>()); //


        for (int base = 1; ; base *= 10) {
            if (base >= 1000_000) break;
            //  gen  奇数个的回文数 10进制中, 比如base = 10 , 那么结果就是 [101,999]
            // odd , 121-> prefix = 12, 保留1
            for (int i = base; i < base * 10; i++) {
                long x = i;
                for (int t = i / 10; t > 0; t /= 10) {
                    x = x * 10 + t % 10;
                }
                doHandle(x);
            }

            // gen  偶数位 的回文数, 前缀是base
            for (int i = base; i < base * 10; i++) {
                long x = i; // example 12, -> 1221
                for (int t = i; t > 0; t /= 10) {
                    x = x * 10 + t % 10;
                }
                doHandle(x);
            }
        }


    }

    // 判断是否是 x 是否是 k进制下的 回文, 如果是, 则加入
    private static boolean doHandle(long x) {
        for (int k = 2; k < 10; k++) {
            // ISSUE [whywhathow]  [must] size 的大小要如何确定呢?
            if (ans[k].size()<30 && check(x, k)) {
                ans[k].add(x);
            }
        }
        return true;
    }

    // 判断x 在k进制下是否是回文.
    private static boolean check(long x, int k) {
        String s = Long.toString(x, k);
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    long res;

    public long kMirror(int k, int n) {
        res = 0;
        init();
        for (int i = 0; i < n; i++) {
            res += ans[k].get(i);
        }
        return res;
    }


}


