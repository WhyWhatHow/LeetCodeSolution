package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3096 {

    public static void main(String[] args) {
        Solution_3096 sol = new Solution_3096();
        System.out.println(sol.minimumLevels(new int[]{
//                1, 0, 1, 0
                1,1
        }));
        System.out.println("==================");
    }

    public int minimumLevels(int[] possible) {
        int[] maxlefts = new int[possible.length];
        int sum = 0;
        maxlefts[0] = possible[0] == 0 ? -1 : 1;
        for (int i = 1; i < possible.length; i++) {
            if (possible[i] == 0) // hard  -1
                maxlefts[i] = maxlefts[i - 1] - 1;
            else // easy + 1
                maxlefts[i] = maxlefts[i - 1] + 1;
        }
        sum = maxlefts[maxlefts.length - 1];
        for (int i = 0; i < maxlefts.length - 1; i++) {
            if (maxlefts[i] > sum - maxlefts[i]) {
                return i + 1;
            }
        }
        return -1;
    }

}


