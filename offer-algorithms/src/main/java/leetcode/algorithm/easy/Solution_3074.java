package leetcode.algorithm.easy;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3074 {

    public static void main(String[] args) {
        Solution_3074 sol = new Solution_3074();
        System.out.println(sol.minimumBoxes(new int[]{9, 8, 8, 2, 3, 1, 6},
                new int[]{10, 1, 4, 10, 8, 5}));
        System.out.println("==================");
    }

    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for (int i : apple) {
            sum += i;
        }
        Arrays.sort(capacity);
        int cnt = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            if (sum <= 0) break;
            sum -= capacity[i];
            cnt++;
        }
        return cnt;
    }

}


