package leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_2943 {

    public static void main(String[] args) {
        Solution_2943 sol = new Solution_2943();
        System.out.println(sol.maximizeSquareHoleArea(3, 2, new int[]{3, 2}, new int[]{3, 2, 4}));
        System.out.println("==================");
    }

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int mh = getMax(hBars, 1);
        int mv = getMax(vBars, 1);
        mh = Math.min(mh, mv);
        return (mh + 1) * (mh + 1);
    }

    private int getMax(int[] hBars, int c) {
        int maxr = 1;
        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] - hBars[i - 1] == 1) {
                c++;
            } else {
                maxr = Math.max(maxr, c);
                c = 1;
            }
        }
        maxr = Math.max(maxr, c);
        return maxr;
    }

}


