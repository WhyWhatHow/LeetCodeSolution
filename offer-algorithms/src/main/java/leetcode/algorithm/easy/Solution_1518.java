package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1518 {

    public static void main(String[] args) {
        Solution_1518 sol = new Solution_1518();
        System.out.println(sol.numWaterBottles(9, 3));
        System.out.println("==================");
    }


    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        int a = numExchange;
        int b = numBottles;
        while (b > 0) {
            int mod = b % a;
            b = b / a;
            res += b;
            if (b == 0) break;
            else  b += mod;

        }
        return res;
    }

}


