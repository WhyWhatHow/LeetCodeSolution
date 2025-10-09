package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3140 {

    public static void main(String[] args) {
        Solution_3140 sol = new Solution_3140();
        System.out.println(sol.maximumEnergy(new int[]{
                5, 10, -19, -2, 1
        }, 3));
        System.out.println("==================");
    }

    public int maximumEnergy(int[] energy, int k) {

        int res = Integer.MIN_VALUE;
        for (int i = energy.length - 1; i >energy.length - k - 1; i--) {
            int j = i;
            int sum = 0;
            while (j >= 0) {
                sum += energy[j];
                res = Math.max(sum, res);
                j -= k;
            }
        }
        return res;
    }
}


