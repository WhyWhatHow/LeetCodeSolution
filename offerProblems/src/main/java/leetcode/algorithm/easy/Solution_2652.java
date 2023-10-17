package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_2652 {

    public static void main(String[] args) {
        Solution_2652 sol = new Solution_2652();

        System.out.println("==================");
        System.out.println(sol.sumOfMultiples(15));
    }

    int[] nums = new int[1000];


    public int sumOfMultiples(int n) {
        int res = 0;
        for (int i = 3; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                res += i;
            }
        }
        return res;

    }
}


