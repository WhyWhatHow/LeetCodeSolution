package leetcode.algorithm.prefix;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1094 {

    public static void main(String[] args) {
        Solution_1094 sol = new Solution_1094();
        System.out.println(sol.carPooling(new int[][]{
                {2, 1, 5}, {3, 5, 7}
        }, 3));
        System.out.println("==================");
    }


    public boolean carPooling(int[][] trips, int capacity) {
        int[] ds = new int[1002];
        for (int[] t : trips) {
            if (t[0] > capacity) return false;
            ds[t[2]] -= t[0];
            ds[t[1]] += t[0];

        }
        int sum = 0;
        for (int i = 0; i < ds.length; i++) {
            sum += ds[i];
            if (sum > capacity) return false;

        }
        return true;
    }
}


