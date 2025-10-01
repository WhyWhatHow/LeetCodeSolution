package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3100 {

    public static void main(String[] args) {
        Solution_3100 sol = new Solution_3100();
        System.out.println(sol.maxBottlesDrunk(
//                13, 6
                10,3 // 10,3,4,5,
        ));
        System.out.println("==================");
    }

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int res = numBottles; // 13,  7
        int left = res;
        while (left >= numExchange) {
            left -= numExchange;
            left++; // 喝掉的那一瓶
            res++;
            numExchange++;
        }
        return res;
    }
}


