package leetcode.algorithm.dfs;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1545 {

    public static void main(String[] args) {
        Solution_1545 sol = new Solution_1545();//
        System.out.println(Math.pow(2, 20) - 1);
        System.out.println(sol.findKthBit(

                4, 12
        ));
        System.out.println("==================");
    }

    public char findKthBit(int n, int k) {
        if (k == 1) return '0';

        int mid = 1 << (n - 1);
        if (k == mid) {
            return '1';
        } else if (k < mid) {
            return findKthBit(n - 1, k);
        } else {
            return invert(findKthBit(n - 1, mid * 2  - k));
        }
    }

    //        S1 = "0"
//        当 i > 1  时，Si = Si-1 + "1" + reverse(invert(Si-1))
//    S1 = "0"              len =1
//    S2 = "0 1 1"          len =3
//    S3 = "011 1 001"      len =3 + 1 + 3
//    S4 = "0111001 1 0110001" len = 7 + 1 + 7

    //  添加的1 始终是 2^(n-1) 次幂, 也就是说2^(n-1)
    // 假设第k位, k 是2^i, 返回1 .
    // k不是2^i次幂, k/2
    // simulation
    public char findKthBitStupid(int n, int k) {
        int len = (int) Math.pow(2, n);
        char[] cs = new char[2000_0000];
        Arrays.fill(cs, '0');
        int all = 1;
        while (all < len) {
            int prev = all;
            all = all + all + 1;
            cs[prev + 1] = '1';
            for (int i = 0; i <= prev; i++) {
                cs[all - i - 1] = invert(cs[i]);
            }

        }
        return cs[k - 1];
    }

    private char invert(char c) {
        return c == '1' ? '0' : '1';
    }
}
