package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1680 {


    public static void main(String[] args) {
        Solution_1680 sol = new Solution_1680();//
        System.out.println(sol.concatenatedBinary(3));
        System.out.println("==================");
    }

    final static int mod = 1000_000_007;

    public int concatenatedBinary(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            int len = Integer.toBinaryString(i).length();
            res = ((res << len) + i) % mod;
            System.out.println(res);
        }
        return (int) res;
    }


}
